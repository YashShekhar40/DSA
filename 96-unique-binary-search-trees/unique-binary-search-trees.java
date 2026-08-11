class Solution {
    public int numTrees(int n) 
    {
        int[] uniq = new int[n + 1];

        Arrays.fill(uniq, 1);

        for (int i = 2; i <= n; ++i)
        {
            int total = 0;

            for (int root = 1; root <= i; ++root)
            {
                total += uniq[root - 1] * uniq[i - root];
            }

            uniq[i] = total;
        }

        return uniq[n];


        
    }
}