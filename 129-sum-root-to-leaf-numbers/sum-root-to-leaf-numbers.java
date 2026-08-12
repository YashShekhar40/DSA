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
    public int sumNumbers(TreeNode root) 
    {
        helper(root, 0);
        
        return ret;
    }

    void helper(TreeNode node, int sum)
    {
        

        sum = sum * 10 + node.val;
        

        if (node.left != null)
        helper(node.left, sum);

        if (node.right != null)
        helper(node.right, sum);

        if (node.left == null && node.right == null){
            ret += sum;
            System.out.println(sum);
            return;
        }
    }
}