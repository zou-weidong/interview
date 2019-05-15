package dynamicProxy;

public class MyServiceImpl implements MyService {
    @Override
    public void addto(User user) {
        System.out.println("add......... " + user.toString());
    }

    @Override
    public int updateto(User user) {
        System.out.println("update......... " + user.toString());
        return 1;
    }

    @Override
    public int deleteto(int id) {
        System.out.println("delete......... " + id);
        return 1;
    }
}
