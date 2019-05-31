package zijietiaodong;

public class PronTest {
    public static void main(String[] args) {
        int po1 = po(35, 28);
        System.out.println(po1);
    }

    private static int po(int a, int b) {
        return a % b == 0 ? b : po(b, a % b);
    }
}
