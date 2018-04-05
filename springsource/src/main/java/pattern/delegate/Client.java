package pattern.delegate;

/**
 * 委托人
 */
public class Client {

    public static void main(String[] args) {
        HokageNinja hokageNinja = new HokageNinja();

        Task task = new Task(TaskType.LEVEL_A, "暗杀风之国大名");
        hokageNinja.performTask(task);

        task = new Task(TaskType.LEVEL_D, "寻找失踪的小猫");
        hokageNinja.performTask(task);
    }
}
