import java.util.HashSet;
import java.util.Arrays;

public class DivisibleByEightHelper {
    public static void main(String[] args) {
        HashSet<String> eights=new HashSet<String>();
        for(int n=104;n<1000;n+=8){
        char[] nca=Integer.toString(n).toCharArray();
        Arrays.sort(nca);
        eights.add(new String(nca));
        }
        
        System.out.println(eights);
    }
}
