public class TreasureHunter {
    public static void main(final String[] args) {
        int[][] steps={{2, 3}, {1, 1}, {0, 2}, {1, 2}, {2, 4}, {3, 1}};
        int[] a=treasureHunt(2, 2, steps);
        System.out.println(a[0]+", "+a[1]);
    }

    static int[] treasureHunt(int x, int y, int[][] steps){
        int[] delta;
        for (int[] step : steps) {
            delta = decode(step);
            x+=delta[0];
            y+=delta[1];
        }
        int[] loc = {x,y};
        return loc;
    }

    static int[] decode(int[] step){
        int[] delta={0,0};
        switch(step[0]){
            case 0: delta[1]=-step[1];
            break;
            case 1: delta[0]=step[1];
            break;
            case 2: delta[1]=step[1];
            break;
            case 3: delta[0]=-step[1];
            break;
            default: System.out.println("Error: Invalid direction!");
        }
        return delta;
    }
    
}
