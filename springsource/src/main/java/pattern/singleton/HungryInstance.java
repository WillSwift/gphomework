package pattern.singleton;

/**
 * 饿汉式
 */
public class HungryInstance {

    private static HungryInstance INSTANCE = new HungryInstance();

    private HungryInstance() {

    }

    public static HungryInstance getInstance() {
        return INSTANCE;
    }
}
