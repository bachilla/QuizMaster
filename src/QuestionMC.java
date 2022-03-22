import java.util.ArrayList;

/**
 * QuestionMC Class.
 * <p>
 * Multiple choice question class.
 * This class contains constructors and information pertaining to the QuestionMC object.
 * This class also contains getters and setters for the QuestionMC object, as well as a toString() method.
 * <p>
 * Each QuestionMC object can have up to three parameters.
 * A number of points, text containing the question, and an answer to that question.
 *
 * @author Austin Bower
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 2
 * @bugs None known.
 */
public class QuestionMC extends Question {

    /**
     * String that contains the answer for this type of question.
     * */
    private char answer;

    /**
     * ArrayList that contains the choices available to the player for the multiple choice question.
     * */
    private ArrayList<String> choices = new ArrayList<>();

    /**
     * No-arg constructor.
     * */
    public QuestionMC() {

    }

    /**
     * Constructor creates a multiple choice question with an answer assigned as a char.
     *
     * @param answer Char that is the correct answer to the multiple choice question.
     * */
    public QuestionMC(char answer) {

        this.answer = answer;
    }

    /**
     * Creates a multiple choice question object with a number of points, a String that contains the question,
     * and a char representing the answer to the question.
     *
     * @param points Integer number of points this question will earn or cost the player.
     * @param text String that contains the question that will be asked to the player.
     * @param answer Char that contains the answer to this multiple choice question.
     * */
    public QuestionMC(int points, String text, char answer) {
        super(points, text);
        this.answer = answer;
    }

    /**
     * Returns the answer to the multiple choice question.
     *
     * @return Char that is the answer to the multiple choice question.
     * */
    public char getAnswer() {
        return this.answer;
    }

    /**
     * Sets the answer to the multiple choice question.
     *
     * @param answer Char that is the correct answer to this multiple choice question.
     * */
    public void setAnswer(char answer) {
        this.answer = answer;
    }

    /**
     * Returns the possible choices that the player will be able to choose from for the multiple choice question.
     *
     * @return ArrayList that contains the possible answers to the multiple choice question.
     * */
    public ArrayList<String> getChoices() {
        return this.choices;
    }

    /**
     * Sets the possible choices that the player will be able to choose from for the multiple choice question.
     *
     * @param choices ArrayList that contains the choices that the player will have to pick to from.
     * */
    public void setChoices(ArrayList<String> choices) {
        this.choices = choices;
    }

    /**
     * Returns the multiple choice question object as a string.
     *
     * @return String that is the answer to this multiple choice question.
     * */
    @Override
    public String toString() {
        return String.valueOf(this.answer);
    }
}