import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizAppWithTimer{
    static String[] questions = {
        "Which data type is used to create a variable that should store text?",
        "How do you create a variable with the numeric value 5?",
        "Which operator is used to add together two values?",
        "Which method can be used to return a string in upper case letters?",
        "Which operator can be used to compare two values?"
    };

    static String[][] options = {
        {"1. String", "2. Txt", "3. myString", "4. string"},
        {"1. num x=5", "2. int x=5", "3. x=5", "4. float x=5"},
        {"1. The * Sign", "2. The || Sign", "3. The & Sign", "4. The + Sign"},
        {"1. tuc()", "2. upperCase()", "3. toUpperCase()", "4. touppercase()"},
        {"1. <>", "2. ><", "3. ==", "4. ="}
    };

    static String[] correctAnswers = {"1", "2", "4", "3", "3"}; // Correct answers as strings
    static int score = 0;
    static int timeLimit = 10; // Time limit in seconds
    static Timer timer;
    static boolean timeUp = false;

    // Timer logic to count down
    private static void startTimer() {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timeUp = true;
            }
        }, timeLimit * 1000); // Convert seconds to milliseconds
    }
    // Method to get user answer with a timer check
    private static String getUserAnswer(Scanner scanner) {
        String answer = "";
        while (!timeUp && answer.isEmpty()) {
            if (scanner.hasNext()) {
                answer = scanner.next();
            }
        }
        return answer;
    }

    // Display final score
    private static void displayResult() {
        System.out.println("Quiz completed!");
        System.out.println("Your final score is: " + score + " out of " + questions.length);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < questions.length; i++) {
            // Display question
            System.out.println("Question " + (i + 1) + ": " + questions[i]);
            for (int j = 0; j < options[i].length; j++) {
                System.out.println(options[i][j]);
            }

            // Start timer
            timeUp = false;
            startTimer();

            // Get user answer
            String answer = getUserAnswer(scanner);

            // Stop the timer
            timer.cancel();

            // Check answer
            if (timeUp) {
                System.out.println("Time's up! Moving to the next question.");
            } else if (answer.equals(correctAnswers[i])) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is: " + correctAnswers[i]);
            }

            System.out.println(); // For spacing between questions
        }

        // Display final score
        displayResult();
        scanner.close();
    }
}
