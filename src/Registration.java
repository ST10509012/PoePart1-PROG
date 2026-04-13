import java.util.regex.Pattern;

/**
 * Registration Class
 * Handles the validation and storage of new user accounts.
 * REFERENCE: Oracle. (n.d.). Class Pattern. Oracle Help Center.
 * <a href="https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html">...</a>
 */

public class Registration {

    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity(String password) {
        // Regex for: 8+ chars, 1 Cap, 1 Number, 1 Special .
        String regex = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=!]).{8,}$";
        return Pattern.compile(regex).matcher(password).matches();
    }



    public boolean checkCellPhoneNumber(String cellPhone) {
        // Logic adapted from Oracle Java Documentation (Oracle, n.d.).
        String regex = "^(\\+27)[0-9]{9,10}$";
        return Pattern.compile(regex).matcher(cellPhone).matches();
    }

    public String registerUser(String user, String pass, String cell) {
        if (!checkUserName(user)) return "Username incorrectly formatted.";
        if (!checkPasswordComplexity(pass)) return "Password complexity failed.";
        if (!checkCellPhoneNumber(cell)) return "Cell number incorrectly formatted.";

        return "Registration Successful";
    }
}
