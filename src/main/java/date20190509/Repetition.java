package date20190509;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Repetition {
    public static void main(String[] args) {
        print("aaaBBBBaaA23");
    }

    private static void print(String param) {
        int length = param.length();
        int tem;
        String s;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            s = param.substring(i, i + 1);
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                tem = map.get(s) + 1;
                map.remove(s);
                map.put(s, tem);
            }

        }
        Set<String> strings = map.keySet();
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strings) {
            stringBuilder.append(str + ":" + map.get(str) + ",");
        }
        System.out.println("{" + stringBuilder.substring(0, stringBuilder.length() - 1) + "}");
    }
}
