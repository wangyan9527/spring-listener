package springSimple.service;

import lombok.SneakyThrows;
import springSimple.event.Event;
import springSimple.event.OrderCompletedEvent;
import springSimple.listener.Listener;

import java.util.concurrent.TimeUnit;

/**
 * 短信服务，监听下单事件，下单后发短信通知用户
 *
 * @author wy
 */
public class SmsService implements Listener<OrderCompletedEvent> {

    @SneakyThrows
    @Override
    public void onApplicationEvent(OrderCompletedEvent event) {
        System.out.println("下单成功！您的单号是：" + event.getSource());
        TimeUnit.SECONDS.sleep(2);
    }

    @Override
    public boolean supportsEventType(Event event) {
        return event instanceof OrderCompletedEvent;
    }
}
