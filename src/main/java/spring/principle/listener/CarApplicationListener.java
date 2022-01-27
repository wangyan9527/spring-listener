package spring.principle.listener;

import org.springframework.stereotype.Component;

import spring.principle.event.OtherEvent;

/**
 * 监听OtherEvent事件的监听器
 * 有两种方式实现监听器：
 * 1.实现ApplicationListener接口
 * 2.使用@EventListener(OtherEvent.class)注解，修饰在方法上
 * {@link org.springframework.context.event.EventListener}
 *
 *
 * @date 2021/12/20
 */
@Component
public class CarApplicationListener implements ApplicationListener<OtherEvent> {

    @Override
    public void onApplicationEvent(OtherEvent event) {
        System.out.println("监听到OtherEvent，CarApplicationListener执行了");
    }
}
