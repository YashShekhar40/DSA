class Solution {
    public int reverse(int x) 
    {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        int count = 0;
        int temp = Math.abs(x);

        while (temp > 0)
        {
            temp /= 10;
            ++count;
        }


        int[] num = new int[count];

        temp = Math.abs(x);
        --count;

        while (temp > 0)
        {
            num[count] = temp % 10;
            temp /= 10;
            --count;
        }

        long ret = 0;
        for (int i = num.length - 1; i >= 0; --i)
        {
            ret *= 10;
            ret += num[i];
        }

        if (x < 0)
        {
            ret = -1 * ret;
        }

        if (ret > max || ret < min)
        {
            return 0;
        }

        return (int)ret;

    
        
    }
}