package DP;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 动态规划，里面涉及到重叠子问题，通过加入缓存表来提高计算速度，减小时间复杂度
class Solution {
    public int fib(int n) {
        if (n == 0){
            return 0;
        }
        int[] cache = new int[n];
        return dp(cache, n);
    }
    public int dp(int[] cache, int n){
        if (n == 1 || n == 2){
            if (cache[n-1] == 0){
                cache[n-1] = 1;
            }
            return cache[n-1];
        }
        if (cache[n-1] != 0){
            return cache[n-1];
        }
        cache[n-1] = dp(cache, n-1)+dp(cache, n-2);
        return cache[n-1];
    }
}

public class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int n = Integer.parseInt(line);

            int ret = new Solution().fib(n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
