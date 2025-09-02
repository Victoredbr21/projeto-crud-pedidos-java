package entities;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private Date moment;
    private OrderStatus status;
    private Client Client;
    private List<OrdemItem> items;

    //construtores


    public Order(Date moment, List<OrdemItem> items, Client client, OrderStatus status) {
        this.moment = moment;
        this.items = new ArrayList<>();
        this.Client = Client;
        this.status = status;
    }
    //getters

    public Date getMoment() {
        return moment;
    }

    public List<OrdemItem> getItems() {
        return items;
    }

    public Client getClient() {
        return Client;
    }

    public OrderStatus getStatus() {
        return status;
    }

    //setters


    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public void setItems(List<OrdemItem> items) {
        this.items = items;
    }

    public void setClient(Client client) {
        this.Client = Client;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    //metodos

    public void addItem(OrdemItem item) {
        this.items.add(item);
        System.out.println("Item" + item + "adicionado");
    }
    public void removeItem(OrdemItem item) {
        this.items.remove(item);
        System.out.println("Item" + item + " removido");
    }
    public Double total() {
        Double soma = 0.0;
        for (Integer i = 0; i < items.size(); i++){
            soma += items.get(i).subTotal();
        }
        return soma;
    }
    
}// marcador
