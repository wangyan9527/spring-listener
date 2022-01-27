package jdk.event;

import java.util.EventObject;

/**
 * 任务结束事件
 *
 *
 * @date 2021/12/20
 */
public class TaskFinishEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public TaskFinishEvent(Object source) {
        super(source);
    }
}
