package spring.principle.event;

/**
 * 其他的事件
 *
 * @author wangyan0315@sunwayworld.com
 * @date 2021/12/20
 */
public class OtherEvent extends ApplicationEvent{
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public OtherEvent(Object source) {
        super(source);
    }
}
