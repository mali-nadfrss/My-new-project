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
    public int[] treeQueries(TreeNode root, int[] queries) {
        maxHeight = 0;
        int[] pre = new int[100001];
        preOrder(root,pre,0);
        int[] post = new int[100001];
        maxHeight = 0;
        postOrder(root,post,0);
        int len = queries.length;
        int[] ans = new int[len];
        for(int i = 0 ; i < len; i++){
            ans[i] = Math.max(pre[queries[i]], post[queries[i]]);
        }
        return ans;
    }
    
    int maxHeight = 0;
    
    void preOrder(TreeNode root, int[] pre, int height){
        if(root == null){
            return;
        }
        pre[root.val] = maxHeight;
        maxHeight = Math.max(height, maxHeight);
        
        preOrder(root.left, pre, height+1);
        preOrder(root.right, pre, height+1);
    }
    
    void postOrder(TreeNode root, int[] post, int height){
        if(root == null){
            return;
        }
        post[root.val] = maxHeight;
        maxHeight = Math.max(height, maxHeight);
    
        postOrder(root.right, post,height+1);
        postOrder(root.left, post, height+1);
    }
}