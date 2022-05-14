package com.lz.dynamicProgramming;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode上的动态规划
 * 难度简单
 *
 * @author lihao
 * @date 2021-11-24 14:21
 */
public class DynamicProgrammingSimple {

    /**
     * 53. 最大子序和
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     * 理解:
     * dp[i]表示以第i个数结尾的连续数组最大和,我们需要求出最大的dp[i]
     * 这个题目不是很符合一般的动态规划的套路,没有使用数据存储中间值,不是常规思维
     * 从左向右遍历,左索引为0,右索引为i,这段数值相加为正数就保留,为负数直接全部舍弃.会出现新的左索引.
     * <p>
     * 这个题目和股票最佳抛售时间一样,复杂度都是o(n),一次遍历,再计算和的时候,负数可以直接省去,用一个变量记录历史最大值,即为结果.
     */
    int function001(int[] nums) {
        if (nums.length == 0) return 0;
        int pre = 0;
        int result = nums[0];
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre + nums[i], nums[i]);
            result = Math.max(pre, result);
        }
        return result;
    }

    /**
     * 70. 爬楼梯
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 注意：给定 n 是一个正整数。
     * 思路: dp[n]表示n阶楼梯可以选择的爬楼方式
     * dp[i] = dp[i-1] + dp[i-2]
     */
    int function002(int n) {
        if (n == 1 || n == 2 || n == 3) {
            return n;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i < 4; i++) {
            dp[i] = i;
        }
        for (int i = 4; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    @Test
    void test001() {
        System.out.println(4 << 1);
    }

    /**
     * 118. 杨辉三角
     * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
     * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
     * 提示:
     * 1 <= numRows <= 30
     * 思路: 需要一个二维数组,长度为行数,非负数记录入数组
     */
    List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    tmp.add(1);
                } else {
                    tmp.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(tmp);
        }
        return result;
    }

    /**
     * 杨辉三角2
     * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
     * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
     * 思路: 这个题区别于上题,上题需要保存集合中全部数据,该题目只需要集合的最后一个元素集合
     */
    List<Integer> getRow(int rowIndex) {
        //储存最终结果
        List<Integer> result = new ArrayList<>();
        //初始值
        if (rowIndex == 0) {
            result.add(1);
            return result;
        }
        //储存中间结果
        int[][] dp = new int[rowIndex + 1][rowIndex + 1];
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                }
                if (i == rowIndex) {
                    result.add(dp[i][j]);
                }
            }
        }
        return result;
    }

    /**
     * 121. 买卖股票的最佳时机
     * 给定一个数组 prices ，它的第i个元素prices[i] 表示一支给定股票第 i 天的价格。
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
     * 思路: 不要局限在动态规划的套路中, 有些题目不是百分百满足动态规划的
     */
    int maxProfit(int[] prices) {
        //最低价格
        int low = Integer.MAX_VALUE;
        //利润
        int p = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < low) {
                low = prices[i];
            } else if (prices[i] - low > p) {
                p = prices[i] - low;
            }
        }
        return p;
    }

    int maxProfit02(int[] prices) {
        int min = Integer.MAX_VALUE;//最低价
        int res = 0;//结果
        for (int price : prices) {
            res = Math.max(res, price - min);
            min = Math.min(min, price);
        }
        return res;
    }

    /**
     * 338. 比特位计数
     * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案
     * 解读: 如果i为奇数 : dp[i] = dp[i-1]+1,因为奇数比偶数多了一个最后的1,其余都一样.
     * 如果i为偶数 : dp[i] = dp[i/2],因为任何数x2都是在最后加一个0
     */
    int[] countBits(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i >> 1];
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        return dp;
    }

    /**
     * 392. 判断子序列
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     * 思路: dp[i]记录着s串的第i-1次遍历时即第i-1个字符在t串的位置数+1,同时设置标记,
     * 如果某一次没有发现t串中存在相同的字符,直接返回错误.
     */
    boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        int[] dp = new int[s.length()+1];
        boolean flag = true;
        out:
        for (int i = 0; i < s.length(); i++) {
            if (!flag) return false;
            flag = false;
            for (int j = dp[i]; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i+1] = j+1;
                    flag = true;
                    continue out;
                }
            }
        }
        return flag;
    }

    boolean isSubsequence02(String s, String t) {
        if (s.length() > t.length()) return false;
        int index = -1;
        char[] subChars = s.toCharArray();
        char[] chars = t.toCharArray();
        //遍历子串
        out:
        for (int i = 0; i < subChars.length; i++) {
            char target = subChars[i];
            for (int j = index+1; j < chars.length; j++) {
                if (chars[j] == target) {
                    index = j;
                    continue out;
                }
            }
            return false;
        }
        return true;
    }

    /**
     * 746. 使用最小花费爬楼梯
     * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
     * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
     * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
     * 思路: dp[i]表示走到索引为i的阶梯需要的最小花费体力
     */
    int minCostClimbingStairs(int[] cost) {
        if (cost.length == 1) return cost[0];
        if (cost.length == 2) return Math.min(cost[0],cost[1]);
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i-1],dp[i-2])+cost[i];
        }
        return Math.min(dp[dp.length-2],dp[dp.length -1]);
    }

    /**
     * 509. 斐波那契数
     * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     * F(0) = 0，F(1) = 1
     * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
     * 给你 n ，请计算 F(n)
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/fibonacci-number
     */
    int fib(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    /**
     * 1025. 除数博弈
     * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
     * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
     * 选出任一 x，满足 0 < x < N 且 N % x == 0 。
     * 用 N - x 替换黑板上的数字 N 。
     * 如果玩家无法执行这些操作，就会输掉游戏。
     * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 False。假设两个玩家都以最佳状态参与游戏。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/divisor-game
     */
    boolean divisorGame(int n) {
        return n%2 ==0;
    }

    /**
     * 1137. 第 N 个泰波那契数
     * 泰波那契序列 Tn 定义如下： 
     * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
     * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/n-th-tribonacci-number
     */
    int tribonacci(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        if (n==2) return 1;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i-3]+dp[i-2]+dp[i-1];
        }
        return dp[n];
    }

    /**
     * 1646. 获取生成数组中的最大值
     * 给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
     * nums[0] = 0
     * nums[1] = 1
     * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
     * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
     * 返回生成数组 nums 中的 最大 值。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/get-maximum-in-generated-array
     */
    int getMaximumGenerated(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        int max = 1;
        for (int i = 0; i < n + 1; i++) {
            if (2*i >=2 && 2*i<=n) {
                dp[2*i] = dp[i];
            }
            if (2*i+1>=2 && 2*i+1<=n) {
                dp[2*i+1]= dp[i] + dp[i+1];
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }

    /**
     * 07. 传递信息
     * 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
     * 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
     * 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
     * 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
     * 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/chuan-di-xin-xi
     * 思路: dp[i][j]表示第i轮传递到编号为j的同学的方案数
     */
    int numWays(int n, int[][] relation, int k) {
        int[][] dp = new int[k+1][n];
        dp[0][0] = 1;
        for (int i = 0; i < k; i++) {
            for (int[] arr : relation) {
                int src = arr[0];int des = arr[1];
                dp[i+1][des] += dp[i][src];
            }
        }
        return dp[k][n-1];
    }

    /**
     * LCS 01. 下载插件
     * 小扣打算给自己的 VS code 安装使用插件，初始状态下带宽每分钟可以完成 1 个插件的下载。假定每分钟选择以下两种策略之一:
     * 使用当前带宽下载插件
     * 将带宽加倍（下载插件数量随之加倍）
     * 请返回小扣完成下载 n 个插件最少需要多少分钟。
     * 注意：实际的下载的插件数量可以超过 n 个
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/Ju9Xwi
     * 思路: 如果一分钟下不完全部,就选择加倍
     */
    int leastMinutes(int n) {
        int speed = 1;
        int time = 0;
        while (speed < n) {
            speed = speed << 1;
            time ++;
        }
        return time +1;
    }

    /**
     * 面试题 08.01. 三步问题
     * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。
     * 实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/three-steps-problem-lcci
     */
    int waysToStep(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < n+1; i++) {
            //取模，对两个较大的数之和取模再对整体取模，防止越界（这里也是有讲究的）
            //假如对三个dp[i-n]都 % 1000000007，那么也是会出现越界情况（导致溢出变为负数的问题）
            //因为如果本来三个dp[i-n]都接近 1000000007 那么取模后仍然不变，但三个相加则溢出
            //但对两个较大的dp[i-n]:dp[i-2],dp[i-3]之和mod 1000000007，那么这两个较大的数相加大于 1000000007但又不溢出
            //取模后变成一个很小的数，与dp[i-1]相加也不溢出
            //所以取模操作也需要仔细分析
            dp[i] = (dp[i-1] + (dp[i-2] + dp[i-3]) % 1000000007) % 1000000007;
        }
        return dp[n];
    }

    /**
     * 面试题 16.17. 连续数列
     * 给定一个整数数组，找出总和最大的连续数列，并返回总和
     * 重复题目
     */
    int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i] ,nums[i]);
            max = Math.max(max,sum);
        }
        return max;
    }

    /**
     * 面试题 17.16. 按摩师
     * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
     * 在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
     * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/the-masseuse-lcci
     * 思路: dp[i]表示第i天接收预约最大总时长,还是基本的动态规划问题
     */
    int massage(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0],nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[nums.length-1];
    }

    /**
     * 面试题 05.03. 翻转数位
     * 给定一个32位整数 num，你可以将一个数位从0变为1。请编写一个程序，找出你能够获得的最长的一串1的长度。
     * 思路: 通过位运算,实现遍历num每一位的效果,临时临时变量记录每段连续1的长度.
     */
    int reverseBits(int num) {
        int max = 0;int tmp =0; int len = 0;
        for (int i = 0; i < 32; i++) {
            if ((num & 1) ==1) {
                tmp++;
                len++;
            }else {
                len = tmp +1;
                tmp = 0;
            }
            num >>=1;
            max = Math.max(max,len);
        }
        return max;
    }

    @Test
    public void test002(){
        int m = 4;
        m >>>= 1;
        System.out.println(m);
    }
}