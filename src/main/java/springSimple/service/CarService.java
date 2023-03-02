package springSimple.service;

import lombok.SneakyThrows;
import springSimple.event.Event;
import springSimple.event.OrderCompletedEvent;
import springSimple.listener.Listener;

import java.util.concurrent.TimeUnit;

/**
 * 物流服务，监听下单事件，用户下单后发货
 *
 * @author wy
 */
public class CarService implements Listener<OrderCompletedEvent> {

    @SneakyThrows
    @Override
    public void onApplicationEvent(OrderCompletedEvent event) {
        System.out.println("订单" + event.getSource() + "已经发货！");
        TimeUnit.SECONDS.sleep(2);
    }

    @Override
    public boolean supportsEventType(Event event) {
        return event instanceof OrderCompletedEvent;
    }
}
