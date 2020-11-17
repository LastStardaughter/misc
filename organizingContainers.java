//https://www.hackerrank.com/challenges/organizing-containers-of-balls/
    static String organizingContainers(int[][] container) {
        Map<Integer, Integer> containerSizes=new TreeMap<Integer, Integer>();
        Map<Integer, Integer> ballQuantities=new TreeMap<Integer, Integer>();
        
        int curContainer=0;
        int[] balls=new int[container.length];
        Arrays.fill(balls,0);
        
        for (int row=0;row<container.length;row++)
        {
            for(int col=0;col<container.length;col++){
                curContainer+=container[col][row];
                balls[col]+=container[col][row];
            }
            add(curContainer, containerSizes);
            curContainer=0;
        }
        
        for(int type : balls){
            add(type, ballQuantities);
        }
        System.out.println(containerSizes);
        System.out.println(ballQuantities);
        
        return ballQuantities.equals(containerSizes) ? "Possible" : "Impossible";
    }
        
    static void add(int n, Map<Integer, Integer> map){
        if(!map.containsKey(n)){
            map.put(n,1);
        } else {
            map.put(n, map.get(n)+1);
        }
    }