class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; ++i)
        {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; ++i)
        {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        // for (int i = 0; i < numCourses; ++i)
        // {
        //     if (adj.get(i).isEmpty())
        //     {
        //         adj.get(i).remove();
        //     }
        // }

        boolean[] vis = new boolean[numCourses];
        boolean[] curr = new boolean[numCourses];

        for (int i = 0; i < numCourses; ++i)
        {
            if (dfs_cycle(i, adj, vis, curr))
                return false;
        }
        return true;
    }

    boolean dfs_cycle(int i, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] curr)
    {
        if (curr[i])
        {
            return true; // Well already in the current path.
        }

        if (vis[i])
        {
            return false; // Already processed and visited no need to visit again.
        }

        vis[i] = true;
        curr[i] = true;

        for (int k : adj.get(i))
        {
            if (dfs_cycle(k, adj, vis, curr))
            {
                return true;
            }
        }

        curr[i] = false;
        return false;
    }
}