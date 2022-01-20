package com.lz.str;

import org.junit.jupiter.api.Test;

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


    @Test
    public void test() {
        addBinary("1010", "1011");
    }
}
