/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution 
{
    int ret = 0;

    public int averageOfSubtree(TreeNode root) 
    {
        ret = 0;

        avg (root);
        return ret;
        
    }

    int helper (TreeNode node)
    {
        if (node == null)
            return 0;

        int left = helper(node.left);
        int right = helper(node.right);

        return left + right + node.val;
    }

    int trav (TreeNode node)
    {
        if (node == null)
            return 0;

        int left = trav (node.left);
        int right = trav (node.right);

        return left + right + 1;
    }

    void avg (TreeNode node)
    {
        if (node == null)
            return;

        int sum = helper (node);
        int count = trav (node);

        if (node.val == sum / count)
            ++ret;

        avg (node.left);
        avg (node.right);

    }
}