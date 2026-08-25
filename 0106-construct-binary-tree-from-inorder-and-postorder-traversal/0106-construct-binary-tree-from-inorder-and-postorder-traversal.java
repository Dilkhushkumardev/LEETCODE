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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0){
            return null;
        }
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i],i);
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);

        for( int i = postorder.length - 2; i >= 0; i--){
            TreeNode node = new TreeNode(postorder[i]);
            TreeNode parent = null;

            while(!stack.isEmpty() && inorderMap.get(stack.peek().val) > inorderMap.get(node.val)){
                parent = stack.pop();
            }
            if(parent != null){
                parent.left = node;
            }else{
                stack.peek().right = node;
            }
            stack.push(node);
        }
        return root;
    }
}