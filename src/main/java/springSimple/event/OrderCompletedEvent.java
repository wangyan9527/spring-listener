package springSimple.event;

public class OrderCompletedEvent extends Event {

    public OrderCompletedEvent(Object source) {
        super(source);
    }
}
