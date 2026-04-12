import java.util.regex.Pattern;

public class Login {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String cellphoneNumber;


    // Validation for Username
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Validation for Password Complexity
    public boolean checkPasswordComplexity(String password) {
        boolean hasCap = !password.equals(password.toLowerCase());
        boolean hasNum = password.matches(".*\\d.*");
        boolean hasSpec = password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
        return password.length() >= 8 && hasCap && hasNum && hasSpec;
    }

    /**
     * Regex developed with the assistance of Gemini 3 Flash (Google AI).
     * Criteria: +27 (SA Code) followed by a number (max 10 digits).
     * Reference: OpenAI. (2024). ChatGPT (Dec 2023 version) [Large language model]. <a href="https://chat.openai.com/">...</a>
     */
    public boolean checkCellPhoneNumber(String cellNumber) {
        // Regex: Starts with +27, followed by 9 to 10 digits.
        String regex = "^(\\+27)[0-9]{9,10}$";
        return Pattern.compile(regex).matcher(cellNumber).matches();
    }

    // Registration Process
    public String registerUser(String username, String password, String cellPhone, String first, String last) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        } else if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        } else if (!checkCellPhoneNumber(cellPhone)) {
            return "Phone Number incorrectly formatted or does not contain international code.";
        } else {
            this.username = username;
            this.password = password;
            this.firstName = first;
            this.lastName = last;
            return "Username successfully captured.\nPassword successfully captured.\nCell phone successfully added.";
        }
    }

    // Login Verification
    public boolean loginUser(String enteredUser, String enteredPass) {
        return enteredUser.equals(this.username) && enteredPass.equals(this.password);
    }

    // Login Status Messaging
    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            return "Welcome " + firstName + " ," + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}