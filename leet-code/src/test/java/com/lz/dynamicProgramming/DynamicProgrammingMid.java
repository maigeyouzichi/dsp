package com.lz.dynamicProgramming;

import java.util.LinkedList;
import java.util.List;

/**
 * 动态规划,中等题目
 *
 * @author lihao
 * @date 2021-11-29 10:41
 */
public class DynamicProgrammingMid {

    /**
     * 5. 最长回文子串
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * 思路: dp[i][j]表示索引i到j的子串是否为回文串,dp[i][j]为回文串的条件是dp[i+1][j-1]=true && str[i]=str[j],别的情况全部是false
     * 注: 需要考虑长度.
     */
    String longestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        char[] chars = s.toCharArray();
        int max = 1;
        int indexStart = 0;
        //长度为1或者2的子串
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            if (i < s.length() - 1 && chars[i] == chars[i + 1]) {
                dp[i][i + 1] = true;
                max = 2;
                indexStart = i;
            }
        }
        //长度大于2的子串
        for (int len = 3; len <= s.length(); len++) {
            for (int i = 0; i < s.length(); i++) {
                int j = i + len - 1;
                if (j >= s.length()) break;
                if (chars[i] == chars[j] && dp[i + 1][j - 1]) {//对于长度为2的情况并不适用
                    dp[i][j] = true;
                    if ((len > max)) {
                        max = len;
                        indexStart = i;
                    }
                }
            }
        }
        //获取子串的起始索引和长度即可
        return s.substring(indexStart, indexStart + max);
    }

    /**
     * 22. 括号生成
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合
     * 思路:
     * 当我们清楚所有 i<n 时括号的可能生成排列后，对与 i=n 的情况，我们考虑整个括号排列中最左边的括号。
     * 它一定是一个左括号，那么它可以和它对应的右括号组成一组完整的括号 "( )"，我们认为这一组是相比 n-1 增加进来的括号。
     * 那么，剩下 n-1 组括号有可能在哪呢？
     * 【这里是重点，请着重理解】
     * 剩下的括号要么在这一组新增的括号内部，要么在这一组新增括号的外部（右侧）。
     * 既然知道了 i<n 的情况，那我们就可以对所有情况进行遍历：
     * "(" + 【i=p时所有括号的排列组合】 + ")" + 【i=q时所有括号的排列组合】
     * 其中 p + q = n-1，且 p q 均为非负整数。
     * 事实上，当上述 p 从 0 取到 n-1，q 从 n-1 取到 0 后，所有情况就遍历完了。
     * 注：上述遍历是没有重复情况出现的，即当 (p1,q1)≠(p2,q2) 时，按上述方式取的括号组合一定不同。
     * <p>
     * 作者：yuyu-13
     * 链接：https://leetcode-cn.com/problems/generate-parentheses/solution/zui-jian-dan-yi-dong-de-dong-tai-gui-hua-bu
     * -lun-da/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    List<String> generateParenthesis(int n) {
        if (n == 0) return new LinkedList<>();
        LinkedList<LinkedList<String>> dp = new LinkedList<>();
        LinkedList<String> list0 = new LinkedList<>();
        list0.add("");//避免遍历时为空
        dp.add(list0);
        LinkedList<String> list1 = new LinkedList<>();
        list1.add("()");
        dp.add(list1);

        for (int i = 2; i < n + 1; i++) {
            LinkedList<String> tmp = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                List<String> one = dp.get(j);
                List<String> two = dp.get(i - 1 - j);
                for (String s : one) {
                    for (String s1 : two) {
                        tmp.add("(" + s + ")" + s1);
                    }
                }
            }
            dp.add(tmp);
        }
        return dp.get(n);
    }

    /**
     * 跳跃游戏 II
     * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * 假设你总是可以到达数组的最后一个位置。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/jump-game-ii
     * 思路: 数组索引为0的为第一个边界,每次找到当次的最大可达边界即为第二个边界,当遍历到边界时,step执行+1操作,边界值更换下一个边界,
     * 如果,满足最后一步完成目标,即返回step+1;
     */
    int jump(int[] nums) {
        if (nums[0] == 0 || nums.length == 1) return 0;
        int step = 0;
        int currentMaxIndex = 0;//实时的最右可达最大边界
        int stepMaxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            currentMaxIndex = Math.max(currentMaxIndex, i + nums[i]);
            if (nums[i] + i >= nums.length - 1) {
                return step + 1;
            }
            if (i == stepMaxIndex) {
                step++;
                stepMaxIndex = currentMaxIndex;
            }
        }
        return 0;
    }

    /**
     * 跳跃游戏
     * <p>
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个下标。
     * 理解: 不断遍历,不断更新最远可达位置,如果最远可达位置不再更新,return结果
     */
    boolean canJump(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i <= maxIndex; i++) {
            maxIndex = Math.max(maxIndex,nums[i]+i);
            if (nums[i]+i >= nums.length-1) return true;
        }
        return false;
    }


}
