import java.util.HashSet;
import java.util.Arrays;
import java.util.List;

public class DivisibleByEight{
    static String solve(String n){
        final String YES="YES", NO="NO";
        if (n.length()==1){
            if (n.equals("8")){
                return YES;
            }
            return NO;
        }
        char[] temp;
        HashSet<Character> nca; //new char array? I don't remember why I named it this.
        if(n.length()==2){
            HashSet<HashSet<Character>> twoDigit=new HashSet<HashSet<Character>>();
            for(int i=16;i<100;i+=8){
                temp=Integer.toString(i).toCharArray();
                nca=new HashSet<Character>();
                nca.add(temp[0]);
                nca.add(temp[1]);
                twoDigit.add(nca);
                }
            temp=n.toCharArray();
            nca=new HashSet<Character>();
            nca.add(temp[0]);
            nca.add(temp[1]);
            if(twoDigit.contains(nca)){return YES;}
            return NO;
        }        
        //HashSet<HashSet<Character>> threeDigit=new HashSet<HashSet<Character>>();
        temp=n.toCharArray();
        HashSet<Character> digits=new HashSet<Character>();
        for(int i=0;i<n.length();i++){
            digits.add(temp[i]);
        }
        for(int i=104;i<1000;i+=8){
            temp=Integer.toString(i).toCharArray();
            nca=new HashSet<Character>();
            nca.add(temp[0]);
            nca.add(temp[1]);
            nca.add(temp[2]);
            if(digits.containsAll(nca)){return YES;}
        }
        return NO;
    }
}