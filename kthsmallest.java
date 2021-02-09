public class Solution {
    public int kthsmallest(final int[] A, int B) {
        int smallest=Integer.MAX_VALUE, result;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(B);
        
        for (int i=0;i<B;i++){
            if(A[i]<smallest){smallest=A[i];}
            heap.add(flip(A[i]));
        }
        
        result=flip(heap.peek());
        
        for (int i=B;i<A.length;i++){
            if(A[i]<result){
                heap.poll();
                heap.add(flip(A[i]));
                result=flip(heap.peek());
                if(A[i]<smallest){smallest=A[i];}    
            }
        }
        
        return result;
    }
    
    private int flip(int a){
        return Integer.MAX_VALUE-a;
    }
}

