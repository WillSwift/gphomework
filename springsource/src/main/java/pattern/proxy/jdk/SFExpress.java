package pattern.proxy.jdk;

import pattern.proxy.model.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 顺丰快递
 */
public class SFExpress implements InvocationHandler {

    private Person target;

    public Object getInstance(Person target) {
        this.target = target;
        Class clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是顺丰快递，请把你要寄的快递交给我，并告诉我你要寄到哪里");
        System.out.println("----------");
        Object result = method.invoke(target, args);
        System.out.println("----------");
        System.out.println("放心吧，我一定会尽快帮你寄到的");
        return result;
    }
}
