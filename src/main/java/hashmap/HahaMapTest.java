package hashmap;

import java.util.HashMap;
import java.util.Map;

public class HahaMapTest {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(1, 10);
        map.put(1, 100);
        map.put(2, 2);
        map.put(3, 3);
        map.put(4, 3);
        map.put(5, 3);
        map.put(6, 3);
        map.put(7, 3);
        map.put(8, 3);
        map.put(9, 3);
        map.put(10, 3);

        System.out.println(map.keySet().toString());
    }
}
