package pattern.delegate;

/**
 * 任务
 */
public class Task {

    private TaskType taskType;
    private String content;

    public Task(TaskType taskType, String content) {
        this.taskType = taskType;
        this.content = content;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
