class Solution {
    public int[] singleNumber(int[] nums) {
        /**
        xor of all numbers = 3 ^ 5 (011 ^ 101)
        diffBit = xor & (-xor)
         xor = 0110 ( only the different bits of 3 and 5 are set)
        -xor = 1010
        ------------
           &   0010   <-- only the rightmost set bit remains

        diffBit helps to set only the rightmost different bit (all other bits are 0). So that one number will have this bit = 0 and other has 1

        so when we do diffBit & nums[i] it gives 0 or 1 - so we can group them into 2 groups. 
1,1,5 - will fall into group 1 where diffBit & this number  = 0 - xor of all these numbers give 5
2,2,3 - will fall into group 2 where diffBit & this number  = 1 - xor of all these numbers give 3
         */

         if (nums == null || nums.length == 0) {
            return new int[0];
         }

         int xor = 0;
         for (int num : nums) {
            xor = xor ^ num;
         }

         int diffBit = xor & (-xor);

         
         int x = 0;
         int y = 0;
         for (int num : nums) {
            if ((diffBit & num) == 0) {
                x = x ^ num;
            } else {
                y = y ^ num;
            }
         }

         return new int[] {x, y};
        
    }
}