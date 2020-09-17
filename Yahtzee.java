import java.util.Random;
import java.util.Scanner;

public class Yahtzee {
    public static void main(final String[] args) {
        Random rand=new Random();
        Hand dice = new Hand();
        String[] inputArray;
        int[] choices;
        Scanner scanner = new Scanner(System.in);
        String input;
        dice.rollAll(rand);

        System.out.println("Enter space-delimited list of die indices (1-5) to reroll or \"q\" to quit.\nYour initial rolls are:");
        dice.printAll();

        while(true){
            input = scanner.nextLine();
            if(input.equals("q")){break;}
            inputArray=input.split(" ");
            choices = new int[inputArray.length];
            for (int i=0;i<inputArray.length;i++){
                choices[i]=Integer.parseInt(inputArray[i])-1;
            }

            dice.rerollChoices(rand, choices);
            System.out.print("New result: ");
            dice.printAll();

        }
     
        scanner.close();
    }
}

//I know, I know. In production I'd have every class as it's own .java file, but it's easier to write demonstration-of-knowledge tests this way.
//I thought about giving every die a pointer to a Random, but that seems redundant.
//If you have a million dice, do you have a million pointers all pointing to the same place??? What use case would need multiple Randoms?

class Die{
    private short sides;
    private int value;

    public Die(){
        this.sides=6;
    }

    public Die(int sides){
        this.sides=(short) sides;
    }

//Thought about having this return the new value but decided that would complicate rerolling code.
    public void roll(Random rand){
        value = rand.nextInt(sides)+1;
    }

    public int getValue(){
        return value;
    }
}

class Hand{
    private Die[] dice;

    public Hand(){
        dice=new Die[5];
        initAll(6);
    }

    public Hand(int size){
        dice=new Die[size];
        initAll(6);
    }

    private void initAll(int sides){
    //foreach doesn't work here because it won't let me touch the array of pointers itself
        for (int i=0;i<dice.length;i++){
            dice[i]=new Die(sides);
        }        
    }

    public void rollAll(Random rand){
        for (Die i : dice){
            i.roll(rand);
        }
    }

    public void printAll(){
        for (Die i : dice){
            System.out.print(i.getValue()+" ");
        }
        System.out.print("\n");
    }

    public void rerollOne(Random rand, int whichDie){
        if (whichDie>dice.length){return;}
        dice[whichDie].roll(rand);
    }

    public void rerollChoices(Random rand, int[] choices){
        for (int i : choices){
            dice[i].roll(rand);
        }
    }

}