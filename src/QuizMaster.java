import edu.uwp.cs.csci242.assignments.a02.quizmaster.FileInOut;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

/**
 * QuizMaster class.
 * <p>
 * This class creates a trivia based quiz game by reading a .txt file. The quiz can be up to 3 questions long.
 * If a value is entered not between 1 and 3 (inclusive), user will be prompted again.
 * Each question is worth a certain number of points and if you get the answer wrong you will LOSE that many points.
 * The player may elect to skip any question by entering "skip" as their answer. They will not gain nor lose points.
 * The quiz game is NOT case sensitive!
 * <p>
 * It works by creating a FileInOut object and then reading from that object's input file.
 * As the file gets read, each line is stored as some information pertaining to the quiz game.
 * A template is provided that explains the parameter each line of the .txt file gets saved to.
 * (See TEMPLATE.txt)
 * <p>
 * The template can be used to create your own quiz!! Simply edit the custom_quiz.txt according
 * to the TEMPLATE.txt format. Then enter "custom_quiz.txt" when asked for the file to read from.
 *
 * @author Austin Bower
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 2
 * @bugs None known.
 */
public class QuizMaster {

    /**
     * 'Question Database' that contains all Question objects in the quiz.
     */
    private static ArrayList<Question> questionsDb = new ArrayList<>();

    /**
     * Player object that contains the player's name and score.
     */
    private static Player player = new Player();

    /**
     * FileInOut object that contains the filename being read from.
     */
    private static FileInOut fIo = new FileInOut();

    /**
     *  Question object that contains the multiple choice question.
     *  */
    private static QuestionMC questionMC = new QuestionMC();

    /**
     * Question object that contains the short answer question.
     * */
    private static QuestionSA questionSA = new QuestionSA();

    /**
     * Question object that contains the true/false question.
     * */
    private static QuestionTF questionTF = new QuestionTF();

    /**
     * Main method creates two scanners, then introduceQuiz helper method is called, which asks the user for the name
     * of the .txt file to read from using a system.in scanner, and goes on to call the readPlayer method,
     * which then welcomes the user to the quiz game.
     * <p>
     * Next, readQuestionsDb is called using a file scanner. Each line of the text file is then saved to the appropriate
     * variable.
     * <p>
     * Finally, the play method  administers the quiz. The player may enter "skip" to skip the question.
     * They will not gain or lose points if they do so.
     * Scanners are closed at the end of the method.
     *
     * @throws Exception Object that is caught by other methods that may produce errors.
     * */
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        introduceQuiz(scanner); // note: this method calls 'readPlayer' method.

        Scanner fScanner = new Scanner(new File(fIo.getInFilename()));
        readQuestionsDb(fScanner); // fills the database with questions, points, and answers according to TEMPLATE.txt.

        play(scanner); // administers the quiz game to the player.

        scanner.close();
        fScanner.close();
    }

    /**
     * Returns the string representation of this Question object.
     *
     * @return String value of the object.
     * @param question Question object that this method returns as a string.
     * */
    private static String getAnswer(Question question) {
        return String.valueOf(question.toString());
    }

    /**
     * Reads the player name from the text file, and saves it to the Player object's name.
     *
     * @param fileIn Scanner that this method uses to read the first and last name from the input file.
     * */
    private static void readPlayer(Scanner fileIn) {
        try {
            player.setFirstName(fileIn.nextLine());
            player.setLastName(fileIn.nextLine());

            if ((player.getFirstName() != null) && (player.getLastName() != null)) {
                fileIn.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Reads the multiple choice question and prompts the user for an answer.
     * Then tells them if they were right or wrong and adjusts the Player's score.
     *
     * @param fileIn Scanner that this method uses to read the player's answer.
     * @param points Number of points associated with this question.
     * */
    private static void readQuestionMC(Scanner fileIn, int points) {
        System.out.println(questionMC.getText());
        for (String s : questionMC.getChoices()) {
            System.out.println(s);
        }
        try {
            String answerMC = String.valueOf(fileIn.nextLine());
            char c = answerMC.toUpperCase().charAt(0);
            for (int i = 0; i < 1; i++) {
                if (answerMC.toUpperCase().equals("SKIP")) {
                    System.out.println("You have elected to skip the question.");
                    break;

                } else if (String.valueOf(c).equals(getAnswer(questionMC))) {
                    player.setScore(player.getScore() + points);
                    System.out.println("Correct! You get " + points + " points.");
                    System.out.println("Your current score is: " + player.getScore());

                } else if (!String.valueOf(c).equals(getAnswer(questionMC))) {
                    player.setScore(player.getScore() - points);
                    System.out.println("Incorrect, the answer was " + "'" + getAnswer(questionMC).toUpperCase() + "'."
                            + " You lose " + questionMC.getPoints() + " points.");
                    System.out.println("Your current score is: " + player.getScore());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /**
     * Reads the short answer question and prompts the user for an answer.
     * Then tells them if they were right or wrong and adjusts the Player's score.
     *
     * @param fileIn Scanner that this method uses to read the player's answer.
     * @param points Number of points associated with this question.
     * */
    private static void readQuestionSA(Scanner fileIn, int points) {
        System.out.println(questionSA.getText());
        try {
            String answerSA = String.valueOf(fileIn.nextLine());
            for (int i = 0; i < 1; i++) {
                if (answerSA.toUpperCase().equals("SKIP")) {
                    System.out.println("You have elected to skip the question.");
                    break;
                } else if (answerSA.toLowerCase().equals(getAnswer(questionSA).toLowerCase())) {
                    player.setScore(player.getScore() + points);
                    System.out.println("Correct! You get " + points + " points.");
                    System.out.println("Your current score is: " + player.getScore());

                } else if (!answerSA.toLowerCase().equals(getAnswer(questionSA).toLowerCase())) {
                    player.setScore(player.getScore() - points);
                    System.out.println("Incorrect, the answer was " + "'"
                            + (getAnswer(questionSA)).toUpperCase()
                            + "'." + " You lose " + points + " points.");
                    System.out.println("Your current score is: " + player.getScore());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Reads the true/false question and prompts the user for an answer.
     * Then tells them if they were right or wrong and adjusts the Player's score.
     *
     * @param fileIn Scanner that this method uses to read the player's answer.
     * @param points Number of points associated with this question.
     * */
    private static void readQuestionTF(Scanner fileIn, int points) {
        System.out.println(questionTF.getText());
        try {
            String answerTF = String.valueOf(fileIn.nextLine());
            for (int i = 0; i < 1; i++) {
                if (answerTF.toUpperCase().equals("SKIP")) {
                    System.out.println("You have elected to skip the question.");
                    break;
                } else if (answerTF.toLowerCase().equals(getAnswer(questionTF))) {
                    player.setScore(player.getScore() + points);
                    System.out.println("Correct! You get " + points + " points.");
                    System.out.println("Your current score is: " + player.getScore());

                } else if (!answerTF.toLowerCase().equals(getAnswer(questionTF))) {
                    player.setScore(player.getScore() - points);
                    System.out.println("Incorrect, the answer was " + "'" + getAnswer(questionTF).toUpperCase() + "'."
                            + " You lose " + points + " points.");
                    System.out.println("Your current score is: " + player.getScore());
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Reads line-by-line the entirety of the text file and creates the 'Question Database'.
     * After the database is created, it is 'shuffled' so that a random type of question is displayed each time.
     *
     * @param fileIn Scanner that this method uses to read the entire .txt file.
     * */
    private static void readQuestionsDb(Scanner fileIn) {
        ArrayList<String> choices = new ArrayList<>();
        try {
            player.setFirstName(fileIn.nextLine());
            player.setLastName(fileIn.nextLine());
            String numQuestions = fileIn.nextLine();
            do {

                if (fileIn.hasNextLine() && fileIn.nextLine().contains("MC 10")) {
                    questionMC.setPoints(10);
                    questionMC.setText(fileIn.nextLine());
                    String numChoices = fileIn.nextLine();
                    int e = numChoices.charAt(0);
                    choices.add(fileIn.nextLine());
                    choices.add(fileIn.nextLine());
                    choices.add(fileIn.nextLine());
                    choices.add(fileIn.nextLine());
                    choices.add(fileIn.nextLine());
                    choices.add(fileIn.nextLine());

                    questionMC.setChoices(choices);

                    String mcAnswer = fileIn.nextLine();
                    char answer = mcAnswer.charAt(0);
                    questionMC.setAnswer(answer);
                }
                if (fileIn.hasNextLine() && fileIn.nextLine().contains("SA 20")) {
                    questionSA.setPoints(20);
                    questionSA.setText(fileIn.nextLine());
                    questionSA.setAnswer(fileIn.nextLine());
                }
                if (fileIn.hasNextLine() && fileIn.nextLine().contains("TF 5")) {
                    questionTF.setPoints(5);
                    questionTF.setText(fileIn.nextLine());
                    questionTF.setAnswer(fileIn.nextBoolean());
                }
            } while (fileIn.hasNextLine() && !fileIn.nextLine().contains("XXX"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        questionsDb.add(questionMC);
        questionsDb.add(questionSA);
        questionsDb.add(questionTF);
        Collections.shuffle(questionsDb); // shuffle so order of questions is not always the same
    }

    /**
     * Administers the quiz by first asking the player how many questions they would like (up to 3).
     * After a number of desired questions is chosen, a local array is created containing that number of questions
     * from the 'Database'.
     * <p>
     * Random type of question will be read to the player until number the player enters is reached.
     * The same question will never be asked twice during the same run of the program.
     *
     * @param kbdIn Scanner this method uses to accept the number of questions entered by the player.
     * */
    private static void play(Scanner kbdIn) {
        int n = 0; //number of questions desired by player.
        do {

            System.out.println("How many questions would you like (out of 3)?");
            try {
                n = Integer.parseInt(kbdIn.nextLine());
            } catch (Exception ex) {
                System.out.println("Error: Please enter an integer...");
            }
        }
        while (n < 1 || n > 3);

            // use a local array to store the correct number of questions, n.
            Question[] qArray = new Question[n];
            for (int i = 0; i < qArray.length; i++) {
                qArray[i] = questionsDb.get(i);
            }

            int e = 1; // the question number, increments each time a question is displayed.
        for (Question question : qArray) { // decide which "read" method should be called based on the type of question.
            System.out.println("\nQuestion " + e++);
            if (question.getText().equals(questionMC.getText())) {
                readQuestionMC(kbdIn, questionMC.getPoints());
            }
            if (question.getText().equals(questionSA.getText())) {
                readQuestionSA(kbdIn, questionSA.getPoints());
            }
            if (question.getText().equals(questionTF.getText())) {
                readQuestionTF(kbdIn, questionTF.getPoints());
            }
        }

        System.out.println("\nYour final score was " + player.getScore() + "!" + " Thanks for playing!");
    }

    /**
     * Static helper method that introduces the quiz game to the player.
     * I included this so that the main method wouldn't have to directly print any text.
     *
     * @param fileIn Scanner this method uses to accept the name of the file to be read from, entered by the player.
     * */
    private static void introduceQuiz(Scanner fileIn) {
        System.out.println("***** QuizMaster *****");
        System.out.println("Please enter the name of the file containing the data:");


        String iFilename = String.valueOf(fileIn.nextLine());

        fIo.setInFilename(iFilename);
        fIo.setOutFilename(fIo.getOutFilename());

        try {
            fileIn = new Scanner(new File(fIo.getInFilename()));
            readPlayer(fileIn);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Welcome to QuizMaster, " + player.toString() + "!");
        fileIn.close();
    }

}

