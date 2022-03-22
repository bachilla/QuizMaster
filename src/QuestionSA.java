/**
 * QuestionSA Class.
 * <p>
 * Short answer question class.
 * This class contains constructors and information pertaining to the QuestionSA object.
 * This class also contains getters and setters for the QuestionSA object, as well as a toString() method.
 * <p>
 * Each QuestionSA object can have up to three parameters.
 * A number of points, text containing the question, and an answer to that question.
 *
 * @author Austin Bower
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 2
 * @bugs None known.
 */
public class QuestionSA extends Question {

    /**
     * String that contains the answer for this type of question.
     * */
    private String answer;

    /**
     * No-arg constructor.
     * */
    public QuestionSA() {

    }

    /**
     * Single argument constructor creates a short answer question object with an answer represented with a string.
     *
     * @param answer String that contains the answer to this short answer question.
     * */
    public QuestionSA(String answer) {

        this.answer = answer;
    }

    /**
     * Three argument constructor creates a short answer question object with a number of points,
     * a String that contains the question, and a string representing that answer.
     *
     * @param points Integer number of points this question will earn or cost the player.
     * @param text String that contains the question that will be asked to the player.
     * @param answer String that contains the answer to this short answer question.
     * */
    public QuestionSA(int points, String text, String answer) {
        super(points, text);
        this.answer = answer;
    }

    /**
     * Returns the answer to the short answer question as a string.
     *
     * @return String that is the answer to this type of question.
     * */
    public String getAnswer() {
        return this.answer;
    }

    /**
     * Sets the answer for this short answer question.
     *
     * @param answer String that contains the answer to this question.
     * */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * Returns the the answer to the short answer question as a String.
     *
     * @return String that is the answer to this question.
     * */
    @Override
    public String toString() {

        return String.valueOf(this.answer);
    }

}
