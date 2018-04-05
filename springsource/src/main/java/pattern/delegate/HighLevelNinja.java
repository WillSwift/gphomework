package pattern.delegate;

public class HighLevelNinja implements Ninja {
    public void performTask(Task task) {
        System.out.println("我是上忍，正在执行" + task.getTaskType().getName() + "，任务内容为：" + task.getContent());
    }
}
