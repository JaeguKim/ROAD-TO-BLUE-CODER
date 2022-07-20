package prob1268;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private String[] products;
    private String searchWord;

    class Node {
        boolean isLeaf;
        Node[] children;
        String product;

        public Node() {
            isLeaf = false;
            children = new Node[26];
        }

        public void makeTree(String word, int wordIdx) {
            if (wordIdx > word.length()-1)
                return;
            Node child = children[word.charAt(wordIdx)-'a'];
            if (child == null) {
                child = new Node();
                children[word.charAt(wordIdx)-'a'] = child;
            }
            if (wordIdx == word.length()-1) {
                child.isLeaf = true;
                child.product = word;
            }
            child.makeTree(word,wordIdx+1);
        }
    }

    public void search(List<String> res, Node cur) {
        if (cur == null)
            return;
        if (cur.isLeaf && res.size() < 3) {
            res.add(cur.product);
        }
        for (int i=0;i<26;++i) {
            Node child = cur.children[i];
            if (child != null)
                search(res,child);
        }
    }

    // N : len(searchWord), M : len(products), K : len(products[i])
    // Time Complexity : O(M * K + N * K)
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        this.products = products;
        this.searchWord = searchWord;
        Node root = new Node();
        for (int i=0; i<searchWord.length(); ++i) {
            for (int j=0; j<products.length; ++j) {
                root.makeTree(products[j],0);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        Node cur = root;
        for (char ch : searchWord.toCharArray()) {
            if (cur != null)
                cur = cur.children[ch-'a'];
            List<String> res = new ArrayList<>();
            search(res,cur);
            ans.add(res);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<String>> res = sol.suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"},"mouse");
        System.out.println(res);
    }
}
