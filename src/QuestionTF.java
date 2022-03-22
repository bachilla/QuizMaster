/**
 * QuestionTF Class.
 * <p>
 * True/false question class.
 * This class contains constructors and information pertaining to the QuestionTF object.
 * This class also contains getters and setters for the QuestionTF object, as well as a toString() method.
 * <p>
 * Each QuestionTF object can have up to three parameters.
 * A number of points, text containing the question, and an answer to that question.
 *
 * @author Austin Bower
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 2
 * @bugs None known.
 */
public class QuestionTF extends Question {

    /**
     * Boolean that contains the answer for this type of question.
     * */
    private boolean answer;

     /**
      * No-arg constructor.
      * */
    public QuestionTF() {
    }

    /**
     * Single argument constructor creates a true/false Question object with a boolean answer.
     *
     * @param answer Boolean that is the answer to this true/false question.
     * */
    public QuestionTF(boolean answer) {

        this.answer = answer;
    }
    /**
     * Three argument constructor creates a true/false question with points, a String to hold the actual question,
     * and a boolean answer.
     *
     * @param points Integer number of points that the question earns or costs the player.
     * @param text String that contains the true/false question that is asked to the player.
     * @param answer Boolean that is the answer to this true/false question.
     * */
    public QuestionTF(int points, String text, boolean answer) {
        super(points, text);
        this.answer = answer;
    }

    /**
     * Returns the boolean answer of the true/false question.
     *
     * @return Boolean answer to the true/false question.
     * */
    public boolean getAnswer() {
        return this.answer;
    }

    /**
     * Sets the Boolean answer of the true/false question to true or false.
     *
     * @param answer Boolean answer of the true/false question.
     * */
    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    /**
     * Returns the answer to the true/false question as a String.
     *
     * @return String that contains the answer to this true/false question.
     * */
    @Override
    public String toString() {

        return String.valueOf(this.answer);
    }
}
