package pattern.delegate;

public enum TaskType {
    LEVEL_S("S级任务"), LEVEL_A("A级任务"), LEVEL_B("B级任务"), LEVEL_C("C级任务"), LEVEL_D("D级任务");

    private String name;

    TaskType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
