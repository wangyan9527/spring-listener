package jdk.listener;

import java.util.EventListener;

import jdk.event.TaskFinishEvent;

/**
 * 事件的抽象监听器
 * EventListener接口是一个标记接口，内部没有方法
 *
 *
 * @date 2021/12/20
 */
public interface TaskFinishEventListener extends EventListener {

    /**
     * 事件发生时的响应方法
     */
    void onTaskFinish(TaskFinishEvent event);

}
