class Solution {
    public int[] dailyTemperatures(int[] temperatures) 
    {
        int[] ret = new int[temperatures.length];
        

        for (int i = 0; i < temperatures.length - 1; ++i)
        {
            int left = i;
            int right = left + 1;

            if (left > 0 && temperatures[left] == temperatures[left - 1])
            {
                ret[i] = ret[i - 1] - 1;
                if (ret[i] < 0)
                {
                    ret[i] = 0;
                }
                continue;
            }

            while(right < temperatures.length)
            {
                if (temperatures[left] < temperatures[right])
                {
                    ret[i] = right - left;
                    break;
                }

                // else if (right == temperatures.length - 1)
                // {
                //     ret[i] = 0;
                // }

                ++right;
            }

        }

        return ret;
    }
}