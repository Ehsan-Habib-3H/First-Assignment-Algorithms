import java.util.*;
import java.util.stream.Collectors;

public class Exercises2 {

    /*
    Given an array of integers nums and an integer target, return indices of the two numbers
    such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
    */

    public int[] twoSum(int[] nums, int target) {
        // TODO
        for (int i = 0; i < nums.length; ++i)
            for (int j = 0; j < nums.length; ++j)
                if (j != i && nums[i] + nums[j] == target)
                    return new int[]{i, j};
        return null;
    }

    /*
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

    For example, 2 is written as II in Roman numeral, just two ones added together.
    12 is written as XII, which is simply X + II.
    The number 27 is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right.
    However, the numeral for four is not IIII.
    Instead, the number four is written as IV.
    Because the one is before the five we subtract it making four.
    The same principle applies to the number nine, which is written as IX.
    There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

    Given a roman numeral, convert it to an integer.
    */

    public int romanToInt(String s) {
        int ans = 0;
        Map<String, Integer> hm = new HashMap<String, Integer>();
        hm.put("I", 1);
        hm.put("V", 5);
        hm.put("X", 10);
        hm.put("L", 50);
        hm.put("C", 100);
        hm.put("D", 500);
        hm.put("M", 1000);
        for (int i = 0; i < s.length(); ++i) {
            //6 cases:
            if (i != s.length() - 1) {
                if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'V') {
                    ans += 4;
                    ++i;
                    continue;
                } else if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'X') {
                    ans += 9;
                    ++i;
                    continue;
                } else if (s.charAt(i) == 'X' && s.charAt(i + 1) == 'L') {
                    ans += 40;
                    ++i;
                    continue;
                } else if (s.charAt(i) == 'X' && s.charAt(i + 1) == 'C') {
                    ans += 90;
                    ++i;
                    continue;
                } else if (s.charAt(i) == 'C' && s.charAt(i + 1) == 'D') {
                    ans += 400;
                    ++i;
                    continue;
                } else if (s.charAt(i) == 'C' && s.charAt(i + 1) == 'M') {
                    ans += 900;
                    ++i;
                    continue;
                }
            }

            ans += hm.get(String.valueOf(s.charAt(i)));
        }
        return ans;
    }

    /*
    Given an array nums of distinct integers, return all the possible permutations.
    You can return the answer in any order.
    */
    public void traceIt(List<Integer> current, List<Integer> perm, List<List<Integer>> result) {
        if (current.isEmpty()) {
            result.add(perm);
            return;
        }
        for (int i = 0; i < current.size(); ++i) {
            int num = current.get(i);
            List<Integer> tmp = new ArrayList<>(current);
            tmp.remove(i);
            List<Integer> perm2 = new ArrayList<>(perm);
            perm2.add(num);
            traceIt(tmp, perm2, result);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        List<Integer> current = Arrays.stream(nums).boxed().toList();
        traceIt(current, new ArrayList<>(), permutations);
        return permutations;
    }

    public static void main(String[] args) {
//        int [] test = {1,2,3,4};
//        System.out.println(permute(test));
    }
}