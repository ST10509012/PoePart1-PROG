/**
 * Login Class
 * Handles registration and login logic for users.
 */
import java.util.regex.Pattern;

public class Login {
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    // --- Validation Methods ---

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        boolean hasCap = !password.equals(password.toLowerCase());
        boolean hasNum = password.matches(".*\\d.*");
        boolean hasSpec = password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
        return password.length() >= 8 && hasCap && hasNum && hasSpec;
    }

    /**
     * Validates South African international code (+27) and length requirements.
     */
    public boolean checkCellPhoneNumber(String cellNumber) {
        // Regex: Starts with +27, followed by 9-10 digits.
        String regex = "^(\\+27)[0-9]{9,10}$";
        return Pattern.compile(regex).matcher(cellNumber).matches();
    }

    // --- Registration & Login Methods ---

    public String registerUser(String username, String password, String cell, String first, String last) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber(cell)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        // If all conditions are met
        this.username = username;
        this.password = password;
        this.firstName = first;
        this.lastName = last;

        return "Username successfully captured.\nPassword successfully captured.\nCell phone number successfully added.";
    }

    public boolean loginUser(String enteredUser, String enteredPass) {
        // Checks if the entered details match what was saved in the Registration .
        return enteredUser.equals(this.username) && enteredPass.equals(this.password);
    }

    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            return "Welcome " + firstName + " ," + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

}