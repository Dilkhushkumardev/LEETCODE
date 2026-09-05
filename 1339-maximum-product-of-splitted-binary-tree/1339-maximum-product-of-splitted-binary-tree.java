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
class Solution {
    private static final int MOD = 1000000007;
    private long maxProduct = 0;
    private long totalSum = 0;

    public int maxProduct(TreeNode root) {
        totalSum  = calculateSum(root);
        findMaxProduct(root);

        return (int)(maxProduct % MOD);
    }
    private long calculateSum(TreeNode node){
        if(node == null){
            return 0;
        }
        return node.val + calculateSum(node.left) + calculateSum(node.right);
    }
    private long findMaxProduct(TreeNode node){
        if(node == null){
            return 0;
        }
        long leftSum = findMaxProduct(node.left);
        long rightSum = findMaxProduct(node.right);
        long currentSum = leftSum + rightSum + node.val;
        
        long product = currentSum * (totalSum - currentSum);
        if(product > maxProduct){
            maxProduct = product;
        }
        return currentSum;
    }
}