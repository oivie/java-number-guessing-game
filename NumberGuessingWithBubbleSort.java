import java.util.Random;
import java.util.Scanner;

public class NumberGuessingWithBubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int arraySize = 10;
        int[] numbers = new int[arraySize];

        System.out.println("Welcome to the Number Position Guessing Game!");

        // Generate random numbers and populate the array
        for (int i = 0; i < arraySize; i++) {
            numbers[i] = random.nextInt(100);
        }

        // Sort the array using the bubble sort algorithm
        bubbleSort(numbers);

        System.out.println("I have sorted an array of numbers between 0 and 100.");
        System.out.print("Enter your guess for the position of a specific number: ");
        int positionGuess = scanner.nextInt();

        // Get the number at the guessed position
        int targetNumber = numbers[positionGuess];

        System.out.println("Now try to guess the number at position " + positionGuess + ".");

        int attempts = 0;
        int numberGuess;

        // Game loop - keep prompting for guesses until the correct number is guessed
        do {
            System.out.print("Enter your guess: ");
            numberGuess = scanner.nextInt();
            attempts++;

            if (numberGuess < targetNumber) {
                System.out.println("Too low! Try again.");
            } else if (numberGuess > targetNumber) {
                System.out.println("Too high! Try again.");
            } else {
                System.out.println("Congratulations! You guessed the number " + targetNumber + " at position " + positionGuess + " in " + attempts + " attempts.");
            }
        } while (numberGuess != targetNumber);

        scanner.close();
    }

    // Bubble Sort Algorithm
    private static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap elements
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
