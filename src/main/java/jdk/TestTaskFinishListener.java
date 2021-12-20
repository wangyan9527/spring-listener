package jdk;

import jdk.event.TaskFinishEvent;
import jdk.listener.MailTaskFinishListener;
import jdk.listener.TaskFinishEventListener;
import jdk.publisher.TaskFinishEventPublisher;

/**
 * 测试类
 *
 * @author wangyan0315@sunwayworld.com
 * @date 2021/12/20
 */
public class TestTaskFinishListener {

    public static void main(String[] args) {
        // 监听器使用的是观察者模式，将主题Subject替换成事件Event，观察者Observer替换成监听器Listener
        // 观察者模式中主题负责维护主题和观察者之间的映射关系，以及在自身状态改变时通知
        // 而监听器则将这两者放入到一个新的角色事件发布器EventPublish中。

        Task task = new Task("任务1", TaskFinishStatus.SUCCESS);

        TaskFinishEvent event = new TaskFinishEvent(task);

        TaskFinishEventPublisher publisher = new TaskFinishEventPublisher();

        TaskFinishEventListener emailListener = new MailTaskFinishListener("xxx@163.com");

        // 注册监听器
        publisher.register(emailListener);

        // 发布事件
        publisher.publishEvent(event);
    }

}
