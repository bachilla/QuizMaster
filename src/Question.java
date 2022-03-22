/**
 * Question class.
 * <p>
 * Generic question class.
 * This class contains constructors and information pertaining to the Question object.
 * This class also contains getters and setters for the Question object, as well as a toString() method.
 * <p>
 * Each Question object may inherit one of three subclasses of Question objects.
 * Multiple choice, short answer, or true/false.
 *
 * @author Austin Bower
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 2
 * @bugs None known.
 */
public class Question {

    /**
     * Integer value that is the number of points the question will earn or cost the player,
     * depending on whether or not they answer the question correctly.
     * */
    private int points;

    /**
     * String that is itself the question that the player will be asked.
     * */
    private String text;

    /**
     * No-arg constructor.
     * */
    public Question() {

    }

    /**
     * Two argument constructor that creates a Question with a point value and a string that holds the actual question.
     *
     * @param points Integer value that is the number of points this question will earn or lose.
     * @param text String that contains the question that will be asked to the player.
     * */
    public Question(int points, String text) {
        this.points = points;
        this.text = text;
    }

    /**
     * Returns the number of points that this Question object will earn or cost the player.
     *
     * @return The number of points this question earned or cost the player.*/
    public int getPoints() {
        return this.points;
    }

    /**
     * Returns the string that contains the question to be asked to the player.
     *
     * @return String that is the question being asked to the player.
     * */
    public String getText() {
        return this.text;
    }

    /**
     * Sets the number of points this Question will earn or cost the player.
     *
     * @param points Integer that is the number of points gained or lost by the player.
     * */
    public void setPoints(int points) {
        this.points = points;
    }

    /**
     * Sets the String that contains the question to be asked to the player.
     *
     * @param text String that is the question that will be asked to the player.*/
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Returns the Question object as a string.
     *
     * @return String that is this object converted into a string.
     * */
    @Override
    public String toString() {
        return String.valueOf(this);
    }
}