package entities;

 public class OrdemItem {
        private Integer quantity;
        private Double price;

        //construtores
        public OrdemItem() {
        } //sobrecarga

        public OrdemItem(Integer quantity, Double price, Product Product) {
            this.quantity = quantity;
            this.price = price;

        }

        //getters

        public Integer getQuantity() {
            return quantity;
        }

        public Double getPrice() {
            return price;
        }

        //setters

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public void setPrice(Double price) {
            this.price = price;
        }
        public Double subTotal() {
            Double resultado = this.quantity * this.price;
            return resultado;
        }

     @Override
     public String toString() {
         return "OrdemItem{" +
                 "quantity=" + quantity +
                 ", price= $" + price +
                 '}';
     }

    } // essa chave fecha a classe
