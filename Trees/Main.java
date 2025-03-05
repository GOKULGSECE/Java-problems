package Trees;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    Set<TreeNode> st;
    int ans;

    public int minCameraCover(TreeNode root) {
        st = new HashSet<>();
        ans = 0;
        st.add(null);
        dfs(root, null);
        return ans;
    }

    public void dfs(TreeNode root, TreeNode previous) {
        if (root != null) {
            System.out.println(root.val);
            if (root.left != null) dfs(root.left, root);
            if (root.right != null) dfs(root.right, root);
        }
        if (previous == null && !st.contains(root) || !st.contains(root.left) || !st.contains(root.right)) {
            ans++;
            st.add(root);
            st.add(previous);
            st.add(root.right);
            st.add(root.left);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating a sample binary tree:
        //         0
        //        / \
        //       1   2
        //      /   /
        //     3   4
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(4);

        Solution solution = new Solution();
        int minCameras = solution.minCameraCover(root);
        System.out.println("Minimum cameras needed: " + minCameras);
    }
}
