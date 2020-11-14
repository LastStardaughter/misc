import java.util.HashMap;
import java.util.Map;

public class DivisibleByEight {
    static String solve(String n) {
        final String YES = "YES", NO = "NO";
        if ((n.equals("8") || n.equals("0"))
                || n.length() == 2 && Integer.parseInt(n) % 8 == 0
                || n.length() == 2 && Integer.parseInt(new String(new char[]{n.charAt(1), n.charAt(0)})) % 8 == 0
        ) {
            return YES;
        } else if (n.length() < 3) return NO;

        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < n.length(); i++) {
            Character character = n.charAt(i);
            if (!counter.containsKey(character)) {
                counter.put(character, 1);
            } else {
                int temp = counter.get(character);
                counter.put(character, ++temp);
            }
        }

        if(counter.get('0') !=null && counter.get('0')>=3){return YES;}
        for (int i = 104; i < 1000; i+=8) {
            Map<Character, Integer> current=map(i);
            boolean match=true;
            for(char digit : current.keySet()){
                if(counter.containsKey(digit) && counter.get(digit)>=current.get(digit)){}
                else match=false;
            }
            if(match){return YES;}
        }
        return NO;
    }

    static Map<Character, Integer> map (int x){
        String n=Integer.toString(x);
        Map<Character, Integer> counter = new HashMap<>();
        for (int i = 0; i < n.length(); i++) {
            Character character = n.charAt(i);
            if (!counter.containsKey(character)) {
                counter.put(character, 1);
            } else {
                int temp = counter.get(character);
                counter.put(character, ++temp);
            }
        }
        return counter;
    }
}