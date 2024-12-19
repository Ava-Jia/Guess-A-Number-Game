import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessANumber {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    static int score = 0;
    public static void main(String[] args) {
        System.out.println("Welcome to the Number Guessing Game!");
        playGame();
    }

    private static void playGame(){

        int userGuess = 0;
        int computerGuess = random.nextInt(10) + 1;

        while(true){
            System.out.print("Guess a number between 1 and 10: ");

            try{
                if(scanner.hasNextInt()){
                    userGuess = scanner.nextInt();
                    scanner.nextLine();

                    if (userGuess >= 1 && userGuess <= 10) {
                        break;
                    } else {
                        System.out.println("Invalid input. Please enter a number between 1 and 10.");
                    }

                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next();
                }
            }catch(InputMismatchException e){
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();
            }
        }

        System.out.println("Computer's guess: " + computerGuess);

        if (userGuess == computerGuess) {
            System.out.println("Congratulations! You guessed the correct number.");
            score++;
        } else {
            System.out.println("Sorry, the correct number was " + computerGuess + ".");
        }

        System.out.println("Do you want to play again? (y/n)");
        String playAgain = scanner.next();
        if (playAgain.equalsIgnoreCase("y")) {
            playGame();
        } else {
            System.out.println("Thanks for playing!");
            System.out.println("Your score: " + score);
        }

    }

}
