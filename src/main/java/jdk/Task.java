package jdk;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 任务信息
 *
 *
 * @date 2021/12/20
 */
@Data
@AllArgsConstructor
public class Task {

    private String name;

    private TaskFinishStatus status;

}
