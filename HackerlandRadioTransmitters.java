/*
I just want to appreciate that my non-working algorithm required ~110 lines of code, including an extra function, and use of ArrayList, TreeSet, and Iterator.
The working algorithm, though described in great verbosity below, requires only ~30 lines of code.

New algorithm:

Part 1:
Given array of house locations x and transmitter distance k,
sort x from lowest to highest
iterate over x, considering the previous, current, and next houses:
{
Check the distance between the previous and current house and between the current and next house.
Add houses to groups (where each house is within k of its neighbor) or to a list of lone houses out of range from any others.
}
For each group, get the number of transmitters required to cover it from Part 2. Return the total for all groups + the number of lone houses.

Part 2:
Given an ordered set of house locations, and transmitter distance k
If there are 3 or fewer locations in this group, the answer is always 1.
Place the first transmitter:
{
Create a window of width 2k+1, positioned all the way at the left, and start sliding it right, stopping when the trailing edge hits the first house. Slide it back left until the middle intersects a house, then leave it there.
}
Place subsequent transmitters:
{
Thereafter, create a new window with its left edge positioned against the right edge of the previous window. Slide it right until the trailing edge hits the first uncovered house, then slide it left until the center intersects a house and leave it there.
When all houses are covered by a window, you're done. The number of windows placed is the number of transmitters required.
}
Return the total number of transmitters placed.

Create a window of width 2k+1, positioned all the way at the left, and start sliding it right, stopping when the trailing edge hits the first house. Slide it back left until the middle intersects a house, then leave it there.
Thereafter, create a new window with its left edge positioned against the right edge of the previous window. Slide it right until the trailing edge hits the first uncovered house, then slide it left until the center intersects a house and leave it there.
When all houses are covered by a window, you're done. The number of windows placed is the number of transmitters required. (edited) 

This time, I'm going to record my process:
Now, I could probably replace Parts 1 and 2 with the new algorithm, but I think it might be more work over the whole thing, so for now I'll only replace part 2. The extra cost of leaving (my current implementation of) part 1 in is O(n) so as long as our algorithm isn't faster than that it's not a HUGE cost.
Before implementing it, I'll start breaking down... what do I actually need to do? Sliding the window over intervening space and waiting for collisions and alignments is an artifact of visualizing the problem physically; I COULD simulate all that but it's almost certainly inefficient. At the very least, the 'window' can't actually be centered between houses so I may as well have its center skip from one house location to the next.
Heck, it might be better to just immediately jump to (leftmost uncovered house)+k and see if there's a house there, but hmm. I can't actually check 'is a house at location X' when the locations are in an array like this. I could make a hash map to track house locations, but... having to repeatedly check potentially empty locations one at a time seems inefficient, so let's put a pin in that and come back to it if I can't solve this in an array-friendly way.
My old implementation already works with an array while tracking a current location as well as previous and next locations. Can I do what I need to without tracking any more? (edited) 

Some of the houses I'll pass as I keep traversing right are probably already covered by the last transmitter I placed. I can store its location in a variable and, as I traverse the array, check whether the current house is covered or not by checking if x[i]<=lastTransmitter+k. (Or I could store that equation in a variable and save the CPU cycles spent recalculating it.) Only when I encounter an uncovered house do I need to think about the next window. (And if I hit the end of the array without finding any more uncovered houses, I'm done!)
At this point, I think I'll change my earlier decision and stop bothering to track 'groups' vs 'lone houses'. It doesn't sound like placing 'windows' is much more work than grouping houses, so grouping them first is probably a waste.
So, when I do find an uncovered house, what do I actually need to do?
I don't even need to THINK until I find a house that's more than k away from the first uncovered house. I may not even need the 'previous house' variable, I might be able to put x[i-1] in the logic when I do need to back up. (And if I hit the end of the array first, I don't care where exactly the last transmitter goes, I only need to know that I need one more. The problem specified I have to answer how many, not where.)
The first time I hit a house that's more than k away from the first uncovered house, it's time to place the next transmitter. I can increment my count of transmitters placed and set lastTransmitter to x[i-1]. I don't need to check that the houses I've walked past are individually covered because mathematically, they have to be. But what about the current house? If it's a lone house my math might get weird. I could put in a bunch of extra logic for that case but it's probably easier to just throw in an i-- so the loop will iterate over it again and treat it as the next uncovered house. Am I allowed to type x[i---1]? We'll find out.

Repeatedly following this algorithm seems like it should do the job. I'm pretty sure the edge case of the last house is already handled by the logic described so far. But what about placing the first transmitter? The state I start in is 'The first house is the first uncovered house I've found, I'm looking for where to place the next transmitter'; as long as I make sure the right variables are set appropriately when the loop starts, it shouldn't even matter that there's no 'last transmitter placed'. If it does I can set it to a big negative value or something.
Also, I think I forgot to describe up there that 'after placing a transmitter I don't need to think until I find an uncovered house', but that's another state I can be in.
*/
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HackerlandRadioTransmitters {

    public static void main(String[] args) {
        int n,k;
        System.out.println(hackerlandRadioTransmitters(new int[]{1,2,3,4,5}, 1));
        System.out.println(hackerlandRadioTransmitters(new int[]{7, 2, 4, 6, 5, 9, 12, 11}, 2));
        
        File input06=new File("HackerlandRadioTransmitters-input06-output-620.txt");
        try{
            Scanner scanner=new Scanner(input06);
            String[] nk=scanner.nextLine().split(" ");
            n=Integer.parseInt(nk[0]);
            k=Integer.parseInt(nk[1]);
            int[] x = new int[n];
            String[] xItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            scanner.close();
            for (int i = 0; i < n; i++) {
                x[i] = Integer.parseInt(xItems[i]);
            }
            System.out.println(hackerlandRadioTransmitters(x, k));
        }
        catch(Exception e){
            System.out.println("Error reading file.");
        }
        System.out.println(hackerlandRadioTransmitters(new int[]{1,81,161,171,251,321,322}, 80));
    }

    static int hackerlandRadioTransmitters(int[] x, int k){
        if (x.length==1){return 1;}
        Arrays.sort(x);
        //System.out.println("Array: "+Arrays.toString(x)+" Range: "+k);
        int total=0, last=x[0], next=last+k;
        boolean placing=true;

        for (int i=1;i<x.length;i++){
            if (placing) {
                if(x[i]<next){
                    
                } else if(x[i]>next){
                    total++;
                    last=x[i-- - 1];
                    next=last+k+1;
                    placing=false;
                } else { //(x[i]==next)
                    total++;
                    last=x[i];
                    next=last+k+1;
                    placing=false;
                }
            }
            else {
                if(x[i]<next){

                } else { //(x[i]>=next)
                    placing=true;
                    last=x[i];
                    next=last+k;
                }
            }
        }
        if(placing){total++;}
        return total;        
    }

}