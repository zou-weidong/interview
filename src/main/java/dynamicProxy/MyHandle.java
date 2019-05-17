package dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Logger;

public class MyHandle implements InvocationHandler {

    private static final Logger logger = Logger.getLogger(MyHandle.class.getName());
    private Object target;

    public MyHandle(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        logger.info("动态代理之前");
        //在这里可以根据method的方式来判断是否要做什么操作
        //1.根据method的名字  2.method上面的自定义注解
        String name = method.getName();
        boolean annotationPresent = method.isAnnotationPresent(LogInfo.class);

        return method.invoke(target, args);
    }

    /**
     * 活动实例
     *
     * @return
     */
    public Object getInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

}
