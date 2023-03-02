package springSimple;

import org.junit.Before;
import org.junit.Test;
import springSimple.context.ApplicationContext;
import springSimple.event.OrderCanceledEvent;
import springSimple.event.OrderCompletedEvent;
import springSimple.service.CarService;
import springSimple.service.RefundService;
import springSimple.service.SmsService;

public class EventTest {

    private ApplicationContext applicationContext = new ApplicationContext();

    // 模拟Spring启动，初始化容器并注册bean
    @Before
    public void refreshApplication() {
        applicationContext.registerListener(new SmsService());
        applicationContext.registerListener(new CarService());
        applicationContext.registerListener(new RefundService());
    }

    // 模拟下单
    @Test
    public void orderCompletedService() {
        // 扣减库存...

        // 生成订单... orderId=10086

        // 订单流水...

        // 下单成功，发布事件
        applicationContext.publish(new OrderCompletedEvent(10086L));
    }

    // 模拟取消订单
    @Test
    public void orderCanceledService() {
        // 回退库存...

        // 更改订单状态... orderId=10086

        // 订单流水...

        // 订单取消成功，发布事件
        applicationContext.publish(new OrderCanceledEvent(10086L));
    }

}
