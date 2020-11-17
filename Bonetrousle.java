/*
In all cases, we know that if n<T(b) or k<b it's unsolvable, where T(x) is the xth triangular number (1,3,6,10,15,21...)
We have three algorithms:
Scott's algorithm: if k<(n-T(b-1)) take the biggest box and call recursively. Else, take the smallest b-1 boxes plus one more box that makes up the difference.
Marcus's algorithm: Take the biggest box you can (how to decide that?), call recursively
John's algorithm: Find the average size box you need to take and take boxes around that size.

Scott's algorithm in human-readable terms. Note: T(n)=n(n+1)/2
To buy n strands of spaghetti in b boxes with k boxes available
Step 1. If n<b(b+1)/2 or k<b, you're gonna have a bad time.
Step 2. If we're buying 1 box, get the box with n strands in it.
If there is no such box, you're gonna have a bad time.
Step 3. Calculate remainder r=n-b(b-1)/2
Step 4. If k<r, buy the biggest box then solve for what's left.
Step 5. If k>=r, buy the smallest b-1 boxes and box r
*/
import java.util.Arrays;

class Problem{
    long n, k;
    int b;

    Problem (long n, long k, int b){
        this.n=n;
        this.k=k;
        this.b=b;
    }
}

public class Bonetrousle {

    public static void main(String[] args) {
        Problem[] problems={new Problem(12,8,3), new Problem(10,3,3), new Problem(9,10,2), new Problem(12,6,3)};
        for(Problem p : problems){
            System.out.println(Arrays.toString(bonetrousle(p.n, p.k, p.b)));
        }
    }

    //Triangular number sequence
    static long T(long n){
        return (n+n*n)>>1;
    }
    //Scott's algorithm.
    static long[] bonetrousle(long n, long k, int b){
        if(n<T(b) || k<b){return new long[]{-1};}        
        long[] answer=new long[b];
        recursive(n, k, b, answer);
        if(answer[0]==-1){return new long[]{-1};}
        return answer;
    }
    static void recursive(long n, long k, int b, long[] arr){
        if(n<T(b) || k<b){
            arr[0]=-1;
            return;
        }
        if(b==1){
            if(n<=k){
                arr[0]=n;
                return;
            }
            arr[0]=-1;
            return;
        }
        long remainder=n-T(b-1);
        if(k<remainder){
            recursive(n-k, k-1, b-1, arr);
            if(arr[0]==-1){return;}
            arr[b-1]=k;
            return;
        }
        for(int i=0;i<b;){
            arr[i++]=i;
        }
        arr[b-1]=remainder;
        return;
    }

}