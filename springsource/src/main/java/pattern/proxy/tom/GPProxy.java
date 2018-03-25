package pattern.proxy.tom;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GPProxy {

    public static Object newInstance(GPClassLoader classLoader, Class<?>[] interfaces, GPInvocationHandler h) {
        try {
            // 1.动态生成源代码.java文件
            String src = generateSrc(interfaces);

            // 2.Java文件输出磁盘
            String filePath = GPProxy.class.getResource("").getPath();
            System.out.println(filePath);
            File file = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(file);
            fw.write(src);
            fw.flush();
            fw.close();

            // 3.把生成的.java文件编译成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(file);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();

            // 4.编译生成的.class文件加载到JVM中
            Class proxyClass = classLoader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(GPInvocationHandler.class);
            file.delete();

            // 5.返回字节码重组以后的新的代理对象
            return c.newInstance(h);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        final String ln = "\r\n";
        StringBuffer sb = new StringBuffer();
        sb.append("package pattern.proxy.tom;").append(ln);
        sb.append("import java.lang.reflect.Method;").append(ln);
        sb.append("import pattern.proxy.model.Person;").append(ln);
        sb.append("public class $Proxy0 implements ").append(interfaces[0].getName()).append("{").append(ln);
        sb.append("GPInvocationHandler h;").append(ln);
        sb.append("public $Proxy0(GPInvocationHandler h) {").append(ln);
        sb.append("this.h = h;").append(ln);
        sb.append("}").append(ln);

        for (Method m : interfaces[0].getMethods()) {
            sb.append("public ").append(m.getReturnType().getName()).append(" ").append(m.getName())
                    .append("() {").append(ln);
            sb.append("try {").append(ln);
            sb.append("Method m = ").append(interfaces[0].getName()).append(".class.getMethod(\"")
                    .append(m.getName()).append("\", new Class[]{});").append(ln);
            sb.append("this.h.invoke(this, m, null);").append(ln);
            sb.append("} catch(Throwable e) {").append(ln);
            sb.append("e.printStackTrace();").append(ln);
            sb.append("}").append(ln);
            sb.append("}").append(ln);
        }
        sb.append("}").append(ln);

        return sb.toString();
    }
}
