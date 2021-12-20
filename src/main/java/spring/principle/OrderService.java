package spring.principle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import spring.principle.context.ApplicationContext;
import spring.principle.event.OrderSuccessEvent;

/**
 * 模拟订单服务
 *
 * @author wangyan0315@sunwayworld.com
 * @date 2021/12/20
 */
@Component
public class OrderService {

    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 用户下单
     */
    public void order() {
        // 下单成功
        System.out.println("下单成功...");

        // 发短信通知用户（粗暴异步），
        new Thread(() -> {
            DemoTest.applicationContext.publishEvent(new OrderSuccessEvent(this));
        }).start();

        // 也可以在Config配置类中设置线程池来开启异步处理，之后可以直接通过下面的方式来发布事件
//       DemoTest.applicationContext.publishEvent(new OrderSuccessEvent(this));

        System.out.println("main线程结束");

        try {
            Thread.sleep(1000L * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
