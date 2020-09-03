    static int utopianTree(int n) {
        if (n==0){return 1;}
        int pow= ((n-1)/2)+2;
        return n%2==0 ? (int) Math.pow(2,pow) -1 : (int) Math.pow(2,pow) -2;
    }