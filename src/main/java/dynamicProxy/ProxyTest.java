package dynamicProxy;

import org.junit.Test;

public class ProxyTest {

    @Test
    public void test() {
        MyService myService = new MyServiceImpl();
        MyHandle myHandle = new MyHandle(myService);
        MyService instance = (MyService) myHandle.getInstance();
        instance.addto(new User());
        instance.deleteto(1);
    }
}
