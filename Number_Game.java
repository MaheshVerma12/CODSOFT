import java.util.Scanner;
import java.util.Random;
public class Number_Game
{
    public static void main(String [] args)
    { char again;
       int range, random_number, guess;
       int correct=0, count=0; 
       do {
        Scanner inp= new Scanner(System.in);
        System.out.println("Enter the range in which you want the random numbers to form ");
        range=inp.nextInt();
        Random num = new Random();
        random_number=1+num.nextInt(range);
        System.out.println("You have five attempts to guess");
        for(int i=0;i<=4;i++)
        {
            guess=inp.nextInt();
            if(guess==random_number)
            {
                System.out.println("Congratulations, you are right!");
                correct++;
                break;
            }
            else if(guess<random_number)
            {
                System.out.println("The guessed number is less than the generated number");
            }
            else
            {
                System.out.println("The guessed number is greater than the randim number");
            }
        }
        System.out.println("Do you want to play the game again?(y/n)");
        again=inp.next().charAt(0);
        count++;

       }while(again=='y');
       System.out.println("Your score is = "+correct+"out of"+count);

        
    }
}