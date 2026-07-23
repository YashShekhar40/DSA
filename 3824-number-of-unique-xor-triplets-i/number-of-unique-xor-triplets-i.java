class Solution {
    public int uniqueXorTriplets(int[] nums) 
    {
        int n = nums.length;

        if (n <= 2)
            return n;

        String s = Integer.toBinaryString(n);
        return 1 << s.length();
        
    }
}