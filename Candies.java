public class Candies {
    public static void main(String[] args) {
        System.out.println(candies(3, new int[]{1,2,2}));
        System.out.println(candies(10, new int[]{2,4,2,6,1,7,8,9,2,1}));
        System.out.println(candies(8, new int[]{2,4,3,5,2,6,4,5}));        
    }

    static long candies(int students, int[] ratings){
        int prev, cur, count=1;
        long candies=0;
        int[] left=new int[students], right=new int[students];

        prev=ratings[0];
        left[0]=0;
        for(int i=1;i<students;i++){
            cur=ratings[i];
            if(cur>prev){
                count++;
            } else {count=1;}
            left[i]=count;
            prev=cur;
        }

        count=1;
        prev=ratings[students-1];
        right[students-1]=0;
        for(int i=students-1;i>=0;i--){
            cur=ratings[i];
            if(cur>prev){
                count++;
            } else {count=1;}
            right[i]=count;
            prev=cur;
        }

        for(int i=0;i<students;i++){
            candies+= left[i] > right[i] ? left[i] : right[i];
        }
        return candies;
    }
}
