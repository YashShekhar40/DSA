class Solution {
    public List<Integer> findMissingElements(int[] nums) {
       Arrays.sort(nums); 

       int min = nums[0];
       int max = nums[nums.length - 1];
       int count = 0;
       List<Integer> ret = new ArrayList<>();

       for (int i = min; i <= max; ++i)
       {
            if (i != nums[count])
            {
                ret.add(i);
            }

            else
            {
                ++count;
            }
       }

       return ret;
    }
}