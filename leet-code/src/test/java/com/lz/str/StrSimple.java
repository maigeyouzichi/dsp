package com.lz.str;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 字符串 -- 简单
 * @author lihao
 * @date 2022-01-18 21:07
 */
public class StrSimple {

    /**
     * 13. 罗马数字转整数
     */
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int pre = findValue(chars[0]);
        int result = 0;
        for (int i = 1; i < chars.length; i++) {
            int num = findValue(chars[i]);
            if (pre<num) result -= pre;
            else result += pre;

            pre = num;
        }
        return result + pre;
    }

    private int findValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default:return 0;
        }
    }

    /**
     * 14. 最长公共前缀
     */
    public String longestCommonPrefix(String[] strs) {
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            if (str.length() == 0) return "";
            for (int j = 0; j <= str.length(); j++) {
                if (j == res.length()) break;
                if (j == str.length()) {
                    res = str;
                    break;
                }
                if (str.charAt(j) != res.charAt(j)) {
                    res = res.substring(0,j);
                    break;
                }
            }
        }
        return res;
    }

    /**
     * 20,有效的括号
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && s.charAt(i) == getChar(stack.peek())) {
                stack.pop();
            }else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    private char getChar(char c) {
        switch (c) {
            case '(': return ')';
            case '{': return '}';
            case '[': return ']';
            default: return '-';
        }
    }


    /**
     * 28, 实现strStr()
     */
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) return -1;
        if (needle.length() == 0) { return 0;}
        else if (haystack.length() == 0){return -1;}
        int j = 0;
        while (j < haystack.length()) {
            if (needle.charAt(0) == haystack.charAt(j)) {
                int k = j;
                int i = 0;
                if (k + needle.length() > haystack.length()) return -1;
                while (k < haystack.length()) {
                    if (haystack.charAt(k) == needle.charAt(i)){
                        i ++;
                        k ++;
                        if (i==needle.length()) return k-i;
                    }else {
                        break;
                    }
                }
            }
            j ++;
        }
        return -1;
    }

    /**
     * 28, 实现strStr()
     *  -- 优化 kmp算法
     */
    public int strStr2(String haystack, String needle) {
        //构建next数组
        int m = haystack.length();
        int n = needle.length();
        if (n==0) return 0;
        if (n>m) return -1;
        int[] next = new int[n];
        int j = 0;
        for (int i = 1; i < n; i++) {
            while (j>0 && needle.charAt(i) != needle.charAt(j)) {
                j = next[j-1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                j ++;
            }
            next[i] = j;
        }
        //遍历 -> 判断子串
        j = 0;
        for (int i = 0; i < m; i++) {
            while (j>0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j-1];
            }
            if (needle.charAt(j) == haystack.charAt(i)) {
                j ++;
            }
            if (j == n) return i-(n-1);
        }
        return -1;
    }


    /**
     * 58. 最后一个单词的长度
     */
    public int lengthOfLastWord(String s) {
        int i = s.length() -1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i --;
        }
        int res = 0;
        while (i >= 0) {
            if (s.charAt(i) == ' ') return res;
            res ++;
            i --;
        }
        return res;
    }

    /**
     * 67. 二进制求和
     */
    public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        int k = 0;
        String res = "";
        while (i>=0 || j>=0) {
            int num1 = i>=0 ? Integer.parseInt(String.valueOf(a.charAt(i))) : 0;
            int num2 = j>=0 ? Integer.parseInt(String.valueOf(b.charAt(j))) : 0;
            int tmp = num1 + num2 + k;
            if (tmp == 2) {
                res = "0"+res;
                k = 1;
            }else if (tmp == 3){
                res = "1"+res;
                k = 1;
            }else {
                res = tmp + res;
                k = 0;
            }
            i --;
            j --;
        }
        if (k == 1) {
            res = "1"+res;
        }
        return res;
    }

    /**
     * 67. 二进制求和
     * 优化
     */
    public String addBinary2(String a, String b) {
        int k = 0;
        int sum = 0;
        StringBuilder str = new StringBuilder();
        for (int i = a.length()-1,j=b.length()-1; i>=0 || j>=0 ; i--,j--) {
            sum += i>=0 ? a.charAt(i)-'0' : 0;
            sum += j>=0 ? b.charAt(j)-'0' : 0;
            sum += k;
            k = sum/2;
            str.append(sum % 2);
            sum = 0;
        }
        if (k>0) str.append(k);
        return str.reverse().toString();
    }

    /**
     * 125. 验证回文串
     */
    public boolean isPalindrome(String s) {
        if (s.equals("")) return true;
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i ++;
                continue;
            };
            if (!Character.isLetterOrDigit(s.charAt(j))) {
                j --;
                continue;
            };
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i++;
            j--;
        }
        return true;
    }

    /**
     * 242. 有效的字母异位词
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    /**
     * 344. 反转字符串
     */
    public void reverseString(char[] s) {
        int i = 0;
        int j = s.length -1;
        char tmp = 0;
        while (i < j) {
            tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i ++;
            j --;
        }
    }

    /**
     * 345. 反转字符串中的元音字母
     */
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = s.length() -1;
        char tmp = 0;
        while (i < j) {
            if (!isVowels(chars[i])) {
                i ++;
                continue;
            }
            if (!isVowels(chars[j])) {
                j --;
                continue;
            }
            tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
            i ++;
            j --;
        }
        return String.valueOf(chars);
    }

    private boolean isVowels(char c) {
        switch (c) {
            case 'a' :
            case 'A' :
            case 'e' :
            case 'E' :
            case 'i' :
            case 'I' :
            case 'o' :
            case 'O' :
            case 'u' :
            case 'U' :
                return true;
            default: return false;
        }
    }

    /**
     * 387. 字符串中的第一个唯一字符
     */
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) return -1;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer count = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), count+1);
        }
        for (int i = 0; i < s.length(); i++) {
            Integer count = map.get(s.charAt(i));
            if (count == 1) return i;
        }
        return -1;
    }

    /**
     * 389. 找不同
     */
    public char findTheDifference(String s, String t) {
        char[] arr01 = s.toCharArray();
        char[] arr02 = t.toCharArray();
        Arrays.sort(arr01);
        Arrays.sort(arr02);
        for (int i = 0; i < s.length(); i++) {
            if (arr01[i] != arr02[i]) return arr02[i];
        }
        return arr02[t.length()-1];
    }

    /**
     * 392. 判断子序列
     */
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean flag = false;
            for (int j = index; j < t.length(); j++) {
                if (t.charAt(j) == c) {
                    index = j + 1;
                    flag = true;
                    break;
                }
            }
            if (!flag) return false;
        }
        return true;
    }

    /**
     * 409. 最长回文串
     */
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer count = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), count+1);
        }
        int doubleCount = 0;
        for (Map.Entry<Character, Integer> entity : map.entrySet()) {
            Integer value = entity.getValue();
            doubleCount += value/2;
        }
        if (2*doubleCount == s.length()) return 2*doubleCount;
        else return 2*doubleCount +1;
    }

    public int longestPalindrome2(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        int doubleCount = 0;
        int i = 0;
        while (i < s.length()-1) {
            if (chars[i] == chars[i+1]) {
                doubleCount ++;
                i += 2;
            }else {
                i++;
            }

        }
        if (2*doubleCount == s.length()) return 2*doubleCount;
        else return 2*doubleCount +1;
    }

    /**
     * 415. 字符串相加
     */
    public String addStrings(String num1, String num2) {
        int i = num1.length() -1;
        int j = num2.length() -1;
        int sum = 0;
        int k = 0;
        StringBuilder sb = new StringBuilder();
        while (i >=0 || j >=0) {
            sum += i>=0?num1.charAt(i)-'0' : 0;
            sum += j>=0? num2.charAt(j)-'0': 0;
            sb.append((sum+k)%10);
            k = (sum +k )/10;
            sum =0;
            i --;
            j --;
        }
        if (k > 0) sb.append(k);
        return sb.reverse().toString();
    }

    /**
     * 459. 重复的子字符串
     */
    public boolean repeatedSubstringPattern(String s) {
        return (s+s).substring(1,(s+s).length()-1).contains(s);
    }


    @Test
    public void test() {
        System.out.println("abac".indexOf('a', 1));
    }
}
