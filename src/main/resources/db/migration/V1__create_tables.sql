CREATE TABLE clients (
    id         BIGSERIAL    PRIMARY KEY,
    name       VARCHAR(150) NOT NULL,
    email      VARCHAR(200) NOT NULL UNIQUE,
    birth_date DATE         NOT NULL,
    created_at TIMESTAMP    NOT NULL DEFAULT NOW()
);

CREATE TABLE products (
    id         BIGSERIAL      PRIMARY KEY,
    name       VARCHAR(200)   NOT NULL,
    price      NUMERIC(10, 2) NOT NULL CHECK (price >= 0),
    created_at TIMESTAMP      NOT NULL DEFAULT NOW()
);

CREATE TABLE orders (
    id         BIGSERIAL    PRIMARY KEY,
    moment     TIMESTAMP    NOT NULL DEFAULT NOW(),
    status     VARCHAR(30)  NOT NULL,
    client_id  BIGINT       NOT NULL REFERENCES clients(id),
    created_at TIMESTAMP    NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP    NOT NULL DEFAULT NOW()
);

CREATE TABLE order_items (
    id         BIGSERIAL      PRIMARY KEY,
    order_id   BIGINT         NOT NULL REFERENCES orders(id) ON DELETE CASCADE,
    product_id BIGINT         NOT NULL REFERENCES products(id),
    quantity   INTEGER        NOT NULL CHECK (quantity > 0),
    price      NUMERIC(10, 2) NOT NULL CHECK (price >= 0)
);

CREATE INDEX idx_orders_client   ON orders(client_id);
CREATE INDEX idx_order_items_order   ON order_items(order_id);
CREATE INDEX idx_order_items_product ON order_items(product_id);
