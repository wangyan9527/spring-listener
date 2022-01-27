package spring.principle.publisher;

import spring.principle.event.ApplicationEvent;
import spring.principle.listener.ApplicationListener;

/**
 * 事件发布器接口
 *
 *
 * @date 2021/12/20
 */
public interface ApplicationEventMulticaster {

    /**
     * 往广播器中添加listener
     * @param listener
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * 发布事件
     * @param event
     */
    void multicastEvent(ApplicationEvent event);

}
