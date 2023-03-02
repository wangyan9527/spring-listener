package springSimple.service;

import lombok.SneakyThrows;
import springSimple.event.Event;
import springSimple.event.OrderCanceledEvent;
import springSimple.listener.Listener;

import java.util.concurrent.TimeUnit;

/**
 * 退款服务，监听取消订单事件，为用户退款
 *
 * @author wy
 */
public class RefundService implements Listener<OrderCanceledEvent> {

    @SneakyThrows
    @Override
    public void onApplicationEvent(OrderCanceledEvent event) {
        System.out.println("退款成功！" + event.getSource() + "元已经退回！");
        TimeUnit.SECONDS.sleep(2);
    }

    @Override
    public boolean supportsEventType(Event event) {
        return event instanceof OrderCanceledEvent;
    }
}
