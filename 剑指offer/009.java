public class Solution {
    public int Fibonacci(int n) {
        if (n < 2) {
            return n;
        }
        int fib1 = 1;
        int fib2 = 0;
        int fibN = 0;
        for (int i = 2; i <= n; i++) {
            fibN = fib1 + fib2;
            fib2 = fib1;
            fib1 = fibN;
        }
        return fibN;
    }
}