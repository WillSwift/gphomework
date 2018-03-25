package pattern.proxy.tom;

import pattern.proxy.model.Person;

import java.lang.reflect.Method;

public class GPExpress implements GPInvocationHandler {

    private Person target;

    public Object getInstance(Person target) {
        this.target = target;
        Class clazz = target.getClass();
        return GPProxy.newInstance(new GPClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("GP快递，很高兴为你服务");
        System.out.println("----");
        Object result = method.invoke(target, args);
        System.out.println("----");
        System.out.println("放心，保证送到");
        return result;
    }
}
