public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int kthsmallest(final int[] A, int B) {
        int smallest;
        AiflQueue queue=new AiflQueue(B);
        for (int i=0;i<B;i++){
            queue.prefill(A[i]);
        }
        queue.sort();
        for (int i=B;i<A.length;i++){
            if (A[i]<queue.smallest()){queue.unshift(A[i]);}
            else if (A[i]<queue.biggest()){queue.insert(A[i]);}
        }
        return queue.biggest();
    }
}

//Arbitrary-insertion, fixed-length queue
class AiflQueue{
    int size;
    LinkedList<Integer> queue;
    public AiflQueue(int size){
        this.size=size;
        queue=new LinkedList<Integer>();
    }
    public void prefill(int e){
        queue.add(e);
    }
    
    public void sort(){
        queue.sort(null);
    }
    
    public void unshift(int e){
        queue.removeLast();
        queue.addFirst(e);
    }
    
    public void insert(int e){
        for (int i=0;i<size;i++){
            if (queue.get(i)>e){
                queue.removeLast();
                queue.add(i,e);
                return;
            }
        }
    }
    
    public int smallest(){
        return queue.getFirst();
    }
    
    public int biggest(){
        return queue.getLast();
    }
}
