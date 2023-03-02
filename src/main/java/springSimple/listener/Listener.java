package springSimple.listener;

import springSimple.event.Event;

public interface Listener<E extends Event> {

    /**
     * 事件发生时触发
     *
     * @param event
     */
    void onApplicationEvent(E event);

    /**
     * 判断监听器是否与事件匹配
     *
     * @param event 事件
     * @return 是否匹配
     */
    boolean supportsEventType(Event event);

}
