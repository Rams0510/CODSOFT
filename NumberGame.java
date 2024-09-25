//Task-1(NUMBER GAME)
import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int maxAttempts = 10;  
        int rounds = 0;       
        int score = 0;        
        System.out.println("Welcome to the Number Guessing Game!");

        while (true) {
            int numberToGuess = random.nextInt(100) + 1; 
            int attempts = 0;  
            boolean hasWon = false;

            System.out.println("\nRound " + (rounds + 1) + ":");
            System.out.println("I'm thinking of a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess the number.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess == numberToGuess) {
                    System.out.println("**Congratulations! You guessed the number.**");
                    hasWon = true;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!hasWon) {
                System.out.println("Sorry! BetterLuck next round. The correct number was " + numberToGuess);
            }
            if (hasWon) {
                score += (maxAttempts - attempts) + 1;  
            }
	   rounds++;
            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = sc.next();
            if (playAgain.equalsIgnoreCase("no")) {
                break;
            }
        }
        System.out.println("\nGame Over!");
        System.out.println("Total rounds played: " + rounds);
        System.out.println("Your final score: " + score);
        System.out.println("Thanks for playing!");
        sc.close();
    }
}
