static int alternatingCharacters(String s) {
        if (s.length()<2){return 0;}
        int count=0;
        char cur, prev=s.charAt(0);
        for(int i=1;i<s.length();i++){
            cur=s.charAt(i);
            if(cur==prev){count++;}
            prev=cur;
        }
        return count;
    }