import java.util.HashMap;
import java.util.Set;

public class Pairs {
    public static void main(String[] args) {
        System.out.println(pairs(2, new int[]{1,5,3,4,2}));
    }

    static int pairs(int k, int[] arr){
        int count=0;
        HashMap<Integer, Integer> map=new HashMap<Integer, Integer>((int) (k/0.7f));
        for(int i : arr){
            if(map.containsKey(i)){
                map.put(i, map.get(i)+1);
            } else map.put(i,1);
        }
        Set<Integer> set= map.keySet();
        for(int i : set){
            if(map.containsKey(i+k)){
                count+=map.get(i)*map.get(i+k);
            }
        }
        return count;        
    }

    /*
    static int pairs(int k, int[] arr){
        int count=0;
        for(int i=0; i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(Math.abs(arr[i]-arr[j])==k){count++;}
            }
        }
        return count;
    }
    */
}
