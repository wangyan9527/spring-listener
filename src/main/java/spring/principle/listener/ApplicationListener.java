package spring.principle.listener;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import spring.principle.event.ApplicationEvent;

/**
 * 监听器接口，监听事件抽象基类的所有子类对象
 *
 *
 * @date 2021/12/20
 */
@FunctionalInterface
public interface ApplicationListener<E extends ApplicationEvent> {

    /**
     * 当监听器监听到对应的事件发布时，会回调本方法
     *
     * @param event
     */
    void onApplicationEvent(E event);

    /**
     * 当前监听器是否匹配本次事件
     *
     * @param event
     * @param applicationListener
     * @return
     */
    default boolean supportsEventType(ApplicationEvent event, ApplicationListener applicationListener) {
        Type[] genericInterfaces = applicationListener.getClass().getGenericInterfaces();
        for (Type genericInterface : genericInterfaces) {
            // 获取泛型化类型
            Class eventClass = (Class) ((ParameterizedType) genericInterface).getActualTypeArguments()[0];
            if (eventClass.equals(event.getClass())) {
                return true;
            }
        }
        return false;
    }

}
