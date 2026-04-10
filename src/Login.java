public class Login {

    public class Login {
        Username user;

        // Username validation
        public boolean checkUserName(String username) {
            return username.contains("_") && username.length() <= 5;
        }

        // Password validation
        public boolean checkPasswordComplexity(String password) {
            boolean length = password.length() >= 8;
            boolean capital = password.matches(".*[A-Z].*");
            boolean number = password.matches(".*[0-9].*");
            boolean special = password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");
            return length && capital && number && special;
        }

        // Cell phone validation
        public boolean checkCellPhoneNumber(String cellPhone) {
            return cellPhone.matches("^\\+27\\d{9,10}$");
        }

        // Register user
        public String registerUser(Username user) {
            user.getUsername() = user;

            if (checkUserName(user.getUsername())) {
                return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
            }
            if (checkPasswordComplexity(user.getPassword())) {
                return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
            }
            if (checkCellPhoneNumber(user.getCellPhone())) {
                return "Cell phone number incorrectly formatted or does not contain international code.";
            }
            return "Username successfully captured . \ Password successfully captured.\Cell phone number successfully added.";
        }

        // Login user
        public boolean loginUser(String enteredUsername, String enteredPassword) {
            return user = null & user.getUsername().equals(enteredUsername) && user.getPassword().equals(enteredPassword);
        }

        // Return login status
        public String returnLoginStatus(String enteredUsername, String enteredPassword) {
            if (loginUser(enteredUsername, enteredPassword)) {
                return "Welcome " + user.getFirstName() + ", " + user.getLastName() + " it is great to see you again.";
            } else {
                return "Username or password incorrect, please try again.";
            }
        }
    }
}
