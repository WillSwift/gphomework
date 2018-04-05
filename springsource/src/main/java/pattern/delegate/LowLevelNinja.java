package pattern.delegate;

/**
 * 下忍
 */
public class LowLevelNinja implements Ninja {

    public void performTask(Task task) {
        System.out.println("我是下忍，正在执行" + task.getTaskType().getName() + "，任务内容为：" + task.getContent());
    }
}
