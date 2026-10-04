class Solution {
    public int minRotations(String s) 
    {
        int curr = 0;
        int ret = 0;

        for (int i = 0; i < s.length(); ++i)
        {
            int temp = s.charAt(i) - '0';

            int ind = Math.min(Math.abs(curr - temp), Math.min((9 - temp + curr + 1), (9 - curr + temp + 1)));
            ret += ind;
            curr = temp;

            System.out.println(ind);
        }
        return ret;
    }
}