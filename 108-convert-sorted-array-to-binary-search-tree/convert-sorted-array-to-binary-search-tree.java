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
    public TreeNode sortedArrayToBST(int[] nums) {
        int left =0;
        int right = nums.length-1;
        return solve(nums, left, right);
    }
    public static TreeNode solve(int[] nums,int left,int right){
         if(left > right) return null;
         int mid = (left + right)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = solve(nums,left,mid-1);
        node.right = solve(nums,mid+1, right);
        return node;
    }
}