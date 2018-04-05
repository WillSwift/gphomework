package pattern.delegate;

/**
 * 火影
 */
public class HokageNinja implements Ninja {

    public void performTask(Task task) {
        switch (task.getTaskType()) {
            case LEVEL_S:
                new HighLevelNinja().performTask(task);
                break;
            case LEVEL_A:
                new HighLevelNinja().performTask(task);
                break;
            case LEVEL_B:
                new MiddleLevelNinja().performTask(task);
                break;
            case LEVEL_C:
                new LowLevelNinja().performTask(task);
                break;
            case LEVEL_D:
                new LowLevelNinja().performTask(task);
                break;
        }
    }
}
