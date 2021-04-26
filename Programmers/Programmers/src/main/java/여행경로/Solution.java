package 여행경로;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    Set<Integer> visit = new HashSet<>();
    Map<String,List<Ticket>> map = new HashMap<>();
    String[][] tickets;
    int ticketCnt;

    public class Ticket implements Comparable<Ticket>{
        int num;
        String from;
        String to;
        public Ticket(int num,String from, String to) {
            this.num = num;
            this.from = from;
            this.to = to;
        }

        @Override
        public int compareTo(Ticket o) {
            if (from.compareTo(o.from) != 0) return from.compareTo(o.from);
            return to.compareTo(o.to);
        }
    }

   boolean dfs(String cur, Stack<String> ans, int used) {
       ans.push(cur);
       if (used == ticketCnt) return true;
       List<Ticket> tickets = map.getOrDefault(cur,null);
       if (tickets != null) {
           for (Ticket ticket : tickets) {
               if (visit.contains(ticket.num)) continue;
               visit.add(ticket.num);
               boolean found = dfs(ticket.to,ans,used+1);
               if (found) return true;
               visit.remove(ticket.num);
           }
       }
       ans.pop();
       return false;
   }

    public String[] solution(String[][] tickets) {
       List<Ticket> list = new ArrayList<>();
       for (int i=0;i<tickets.length;i++) {
           String[] ticket = tickets[i];
           list.add(new Ticket(i+1,ticket[0],ticket[1]));
       }
       Collections.sort(list);
        ticketCnt = tickets.length;
        for (Ticket ticket : list) {
            if (map.containsKey(ticket.from) == false) {
                map.put(ticket.from,new ArrayList<>());
            }
            map.get(ticket.from).add(ticket);
        }
        Stack<String> ans = new Stack<>();
        dfs("ICN",ans, 0);
        return ans.stream().collect(Collectors.toList()).toArray(new String[0]);
    }
}
