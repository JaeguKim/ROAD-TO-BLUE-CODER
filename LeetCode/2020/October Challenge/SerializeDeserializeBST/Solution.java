import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

// solution not using global variable
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "X";
        return root.val+","+serialize(root.left)+","+serialize(root.right);
    }

    public TreeNode deserializeHelper(Queue<String> queue){
        String front = queue.poll();
        if (front.equals("X")) return null;
        TreeNode newNode = new TreeNode(Integer.parseInt(front));
        newNode.left = deserializeHelper(queue);
        newNode.right = deserializeHelper(queue);
        return newNode;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }
}

// solution using global variable
// public class Codec {

//     String res = "";
//     String[] encoded;
//     TreeNode newRoot;
//     int idx = 0;

//     public void serializeHelper(TreeNode node, String dir){
//         if (node == null) return;
//         if (node.left == null && node.right == null){
//             res += String.format("%s%sE,",node.val,dir);
//             return;
//         }
//         res += String.format("%s%s,",node.val,dir);
//         if (node.left != null) serializeHelper(node.left,"L");
//         else res += "empty,";
//         if (node.right != null) serializeHelper(node.right,"R");
//         else res += "empty,";
//     }

//     // Encodes a tree to a single string.
//     public String serialize(TreeNode root) {
//         res = "";
//         serializeHelper(root,"");
//         return res;
//     }

//     public void deserializeHelper(TreeNode root, String dir){
//         if (idx > encoded.length-1) return;
//         if (dir == null){
//             if (encoded[idx].contains("L")) deserializeHelper(root,"L");
//             else idx++;
//             if (idx < encoded.length && encoded[idx].contains("R")) deserializeHelper(root,"R");
//             return;
//         }
//         int nodeVal = Integer.parseInt(encoded[idx].split("[LR]")[0]);
//         TreeNode newNode = new TreeNode(nodeVal);
//         if (dir.equals("L")) root.left = newNode;
//         else if (dir.equals("R")) root.right = newNode;
//         if (encoded[idx].contains("E")){
//             idx++;
//             return;         
//         }
//         else {
//             idx++;
//             if (idx < encoded.length && encoded[idx].contains("L")) deserializeHelper(newNode,"L");
//             else idx++;
//             if (idx < encoded.length && encoded[idx].contains("R")) deserializeHelper(newNode,"R");
//             else idx++;   
//         }
//     }

//     // Decodes your encoded data to tree.
//     public TreeNode deserialize(String data) {
//         if (data.equals("")) return null;
//         System.out.println(data);
//         encoded = data.split(",");
//         idx = 0;
//         if (encoded.length == 0) return null;
//         else if (encoded.length == 1){
//             int nodeVal = Integer.parseInt(encoded[idx].split("E")[0]);
//             return new TreeNode(nodeVal);
//         }
//         TreeNode root = new TreeNode(Integer.parseInt(encoded[idx++]));
//         deserializeHelper(root,null);
//         return root;
//     }
// }

