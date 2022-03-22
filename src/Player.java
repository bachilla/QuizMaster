/**
 * Player class.
 * <p>
 * This class contains constructors and information pertaining to the Player object.
 * This class also contains getters and setters for the Player object, as well as a toString() method.
 * <p>
 * Each Player object can have up to three parameters.
 * A first name, last name, and current score.
 *
 * @author Austin Bower
 * @edu.uwp.cs.242.course CSCI 242 - Computer Science II
 * @edu.uwp.cs.242.section 001
 * @edu.uwp.cs.242.assignment 2
 * @bugs None known.
 */
public class Player {

    /**
     * String that contains the player's first name.
     * */
    private String firstName;

    /**
     * String that contains the player's last name.
     * */
    private String lastName;
    /**
     * Integer that contains the player's current total score.
     * */
    private int score;

    /**
     * No-arg constructor
     * */
    public Player() {

    }

    /**
     * Two argument constructor that creates Player with both first and last name.
     *
     * @param firstName String that is the first name of the player.
     * @param lastName String that is the last name of the player.
     * */
    public Player(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Three argument constructor that creates Player with both first and last name, as well as a score.
     *
     * @param firstName String that is the first name of the player.
     * @param lastName String that is the last name of the player.
     * @param score Integer value that is the player's score.
     * */
    public Player(String firstName, String lastName, int score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
    }

    /**
     * Returns the first name of the player.
     *
     * @return String that is the first name of the player.
     * */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Returns the last name of the player.
     *
     * @return String that is the last name of the player.
     * */
    public String getLastName() {return this.lastName;}

    /**
     * Returns the current score of the player.
     *
     * @return String that is the first name of the player.
     * */
    public int getScore() {return this.score;}

    /**
     * Sets the first name of the player.
     *
     * @param firstName String that becomes the player's first name.
     * */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets the last name of the player.
     *
     * @param lastName String that becomes the player's last name.
     * */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Sets the current score of the player.
     *
     * @param score Integer value that is the player's current score.
     * */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Returns the Player object as a string.
     *
     * @return String that contains the name of the player.
     * */
    @Override
    public String toString() {
        return String.valueOf(this.firstName);
    }
}