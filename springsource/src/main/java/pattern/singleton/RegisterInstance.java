package pattern.singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 注册登记式
 */
public class RegisterInstance {

    private static Map<String, RegisterInstance> map = new ConcurrentHashMap<String, RegisterInstance>();

    private RegisterInstance() {

    }

    public static RegisterInstance getInstance(String name) {
        if (name == null) {
            name = RegisterInstance.class.getName();
        }
        map.putIfAbsent(name, new RegisterInstance());
        return map.get(name);
    }
}
