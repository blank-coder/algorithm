package DP;

public class fib {
    public static void main(String[] args) {
        int a = fib1(20);
        System.out.println(a);
    }

    // 动态规划，里面涉及到重叠子问题，通过加入缓存表来提高计算速度，减小时间复杂度

    public static  int fib1(int n) {
        if (n == 0){
            return 0;
        }
        int[] cache = new int[n];
        return dp(cache, n);
    }
    public static  int dp(int[] cache, int n){
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

