    public static boolean helper(int idx,int leap, int[] game,HashSet<Integer> visited){
        if (idx < 0 || visited.contains(idx)){
            return false;
        }
        else if (idx >= game.length-1){
            return true;
        }
        else if (game[idx] == 1){
            return false;
        }
        visited.add(idx);
        boolean b1 = helper(idx-1,leap,game,visited);
        boolean b2 = helper(idx+1,leap,game,visited);
        boolean b3 = helper(idx+leap,leap,game,visited);
        return b1 || b2 || b3;
    }
