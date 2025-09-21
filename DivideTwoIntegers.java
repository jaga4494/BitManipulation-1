class Solution {
    // 24/5, 28/5, 10/3, 37/6
    // TC: log(dividend)
    public int divide(int dividend, int divisor) {
        if (dividend == 0 && divisor != 0) {
            return 0;
        }

        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }

        if (dividend == Integer.MIN_VALUE) {
            if (divisor == 1) {
                return dividend;
            } else if (divisor == -1) {
                return Integer.MAX_VALUE;
            }
            
        }

        // Do the long inside abs and not like (long) Math.abs(dividend). it will not work. -2147483648 is used like:
        // int test1 = Math.abs((-2147483648));
        // long test2 = (long) Math.abs((-2147483648));
        // System.out.println(test1 + "  " + test2);
        // gives -2147483648  -2147483648

        long x =  Math.abs((long) dividend);
        long y =  Math.abs((long) divisor);
        
        System.out.println(x + "  " + y);
        int ans = 0;
        while (x >= y) {
            int count = 0;
            
            while ((y << 1) <= x) {
                y = y << 1;
                ++count;
            }
            // like for 10/3, first time count = 1. So ans += 2^1.
            // then x = 10 - 6 = 4.
            // now, 3 << 1 = 6 so wont so inside above while. count remains 0. we need to add 1 to ans. 
            if (count == 0) { 
                ans++;
                break;
            }

            ans += Math.pow(2, count);
            x = x - y;
            y = Math.abs(divisor);

            // System.out.println(count);
            
        }
        
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            return -ans;
        }
        return ans;
        
    }
}