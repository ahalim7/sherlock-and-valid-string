/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package halim.lessons.sherlockandvalidstring;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author AbdElHalim
 */
public class StringValidator {

    public static void main(String[] args) {
        String result = isValid("aaaabbcc");
        System.out.println(result);
    }

    static String isValid(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        Iterator<Integer> itr = map.values().iterator();
        boolean first = true, second = true;
        int val1 = 0, val2 = 0;
        int countOfVal1 = 0, countOfVal2 = 0;

        while (itr.hasNext()) {
            int i = itr.next();

            if (first) {
                val1 = i;
                first = false;
                countOfVal1++;
                continue;
            }
            if (i == val1) {
                countOfVal1++;
                continue;
            }

            if (second) {
                val2 = i;
                countOfVal2++;
                second = false;
                continue;
            }
            if (i == val2) {
                countOfVal2++;
                continue;
            }

            return "NO";
        }

        if (countOfVal1 > 1 && countOfVal2 > 1) {
            return "NO";
        } else {
            return "YES";
        }
    }
    // Complete the isValid function below.
//    static String isValid(String s) {
//
//        Set<Character> map = new HashSet<>();
//        String removed = "";
//        int removedChecker = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (!map.contains(s.charAt(i))) {
//                map.add(s.charAt(i));
//            } else {
//                map.remove(s.charAt(i));
//                removed += s.charAt(i);
//            }
//        }
//
//        for (char c : map) {
//            if (removed.contains(c + "")) {
//                removedChecker++;
//            }
//        }
//        return (map.size() == 1 || map.size() == removedChecker) ? "YES" : "NO";
//    }
}
