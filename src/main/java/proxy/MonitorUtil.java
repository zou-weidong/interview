package proxy;

public class MonitorUtil {

    private static ThreadLocal<Long> t1 = new ThreadLocal<>();

    public static void start() {
        t1.set(System.currentTimeMillis());
    }

    public static void finish(String methodName) {
        long millis = System.currentTimeMillis();
        System.out.println(methodName + "耗时：" + (millis - t1.get() + "ms"));
    }

}
