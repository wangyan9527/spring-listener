package springSimple.event;

public class OrderCanceledEvent extends Event {

    public OrderCanceledEvent(Object source) {
        super(source);
    }
}
