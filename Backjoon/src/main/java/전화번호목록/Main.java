package 전화번호목록;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    static class Trie {
        boolean isLeaf = false;
        Trie[] children = new Trie[10];
    }

    static BufferedReader br;
    static BufferedWriter bw;

    public static String solve(String fname, boolean test) throws IOException {
        if (test) br = new BufferedReader(new FileReader(fname));
        else br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-->0) {
            int n = Integer.parseInt(br.readLine());
            Trie root = new Trie();
            boolean isConsistent = true;
            List<String> phoneList = new ArrayList<>();
            while (n-->0) {
                phoneList.add(br.readLine());
            }
            Collections.sort(phoneList, Comparator.comparingInt(String::length));
            for (String phone : phoneList) {
                if (isConsistent == false) {
                    break;
                }
                Trie cur = root;
                for (int i=0;i<phone.length();i++) {
                    char ch = phone.charAt(i);
                    if (cur.children[ch-'0'] == null) {
                        cur.children[ch-'0'] = new Trie();
                    }
                    cur = cur.children[ch-'0'];
                    if (cur.isLeaf) {
                        isConsistent = false;
                    }
                }
                cur.isLeaf = true;
            }
            if (isConsistent) {
                sb.append("YES\n");
            }
            else {
                sb.append("NO\n");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        String res = solve("test", false);
        bw.write(res + "\n");
        bw.flush();
    }
}
