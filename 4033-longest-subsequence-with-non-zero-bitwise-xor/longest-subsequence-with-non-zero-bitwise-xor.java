class Solution {
    public int longestSubsequence(int[] nums) 
    {
        int xor = 0;
        boolean zero = true;

        for (int num : nums)
        {
            xor ^= num;

            if(num > 0)
            {
                zero = false;
            }
        }

        if (xor != 0)
        {
            return nums.length;
        }

        return zero ? 0 : nums.length - 1;
        
    }
}