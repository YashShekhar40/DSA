class Solution {
    public int findMinMoves(int[] machines) 
    {
        int sum = 0;
        // int max = 0;
        // int max_count = 0;
        // int min = Integer.MAX_VALUE;
        // int min_count = 0;

        for (int i = 0; i < machines.length; ++i)
        {
            sum += machines[i];

            // max = Math.max(max, machines[i]);
            // min = Math.min(min, machines[i]);
        }

        // for (int i = 0; i < machines.length; ++i)
        // {
        //     if (machines[i] == max)
        //     {
        //         ++max_count;
        //     }
            
        //     if (machines[i] == min)
        //     {
        //         ++min_count;
        //     }
        // }

        if (sum % machines.length != 0)
        {
            return -1;
        }

        int ret = 0;
        int curr = 0;
        int req = sum / machines.length;

        for (int i = 0; i < machines.length; ++i)
        {
             curr += machines[i] - req;

            // ret = Math.max(ret, Math.abs(curr));

            ret = Math.max(Math.max(ret, Math.abs(curr)), machines[i] - req);
        }


        return ret;
        
    }
}