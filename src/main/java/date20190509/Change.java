package date20190509;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Change {
    public static void main(String[] args) {
        boolean bool = change("abc", "bbc");
        boolean boole = change("abc", "ddc");
        System.out.println(bool);
        System.out.println(boole);
    }

    /**
     * 思路是：判断两个字符串字符相等的个数与字符串长度的关系
     * <p>
     * 相等字符： 数量为0 true ；数量为偶ture；数量为奇时，
     *
     * @param s1
     * @param s2
     * @return
     */
    private static boolean change(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0 || s1.length() != s2.length()) {
            return false;
        }

        return true;
    }


    private static int judge(String s1, String s2) {
        int length = s1.length();
        int tmp1;
        String first;
        String second;
        Map<String, Integer> firstMap = new HashMap<>();
        Map<String, Integer> secondMap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            first = s1.substring(i, i + 1);
            second = s1.substring(i, i + 1);

            if (!firstMap.containsKey(first)) {
                firstMap.put(first, 1);
            } else {
                tmp1 = firstMap.get(first) + 1;
                firstMap.remove(first);
                firstMap.put(first, tmp1);
            }

            if (!secondMap.containsKey(second)) {
                secondMap.put(second, 1);
            } else {
                tmp1 = secondMap.get(second) + 1;
                secondMap.remove(second);
                secondMap.put(second, tmp1);
            }
        }
        int firstSize = firstMap.size();
        int secondSize = secondMap.size();
        firstMap.putAll(secondMap);


        return 1;
    }

}
