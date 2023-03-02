package springSimple.event;

import lombok.Getter;

@Getter
public class Event {

    private Object source;

    public Event(Object source) {
        this.source = source;
    }

}
