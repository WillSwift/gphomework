package pattern.delegate;

public class MiddleLevelNinja implements Ninja {
    public void performTask(Task task) {
        System.out.println("我是中忍，正在执行" + task.getTaskType().getName() + "，任务内容为：" + task.getContent());
    }
}
