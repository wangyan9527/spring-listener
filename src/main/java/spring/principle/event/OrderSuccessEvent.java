package spring.principle.event;

/**
 * 下单成功事件
 *
 *
 * @date 2021/12/20
 */
public class OrderSuccessEvent extends ApplicationEvent{
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public OrderSuccessEvent(Object source) {
        super(source);
    }
}
