void main() {
    Scanner scanner = new Scanner(System.in);
    Login auth = new Login();

    // --- Registration ---
    System.out.println("--- REGISTRATION ---");
    System.out.println(" Enter your First Name: ");
    String fName = scanner.nextLine();
    System.out.println(" Enter your Last Name: ");
    String lName = scanner.nextLine();
    System.out.println(" Enter your Username" + "(ensure that the password contains at least eight characters, a capital letter, a number, and a spec):");
    String username = scanner.nextLine();
    System.out.println(" Enter your Password" + "(ensure that your username contains an underscore and is no more than five characters in length):");
    String password = scanner.nextLine();
    System.out.println(" Enter your Cell Phone Number" + "(ensure that your number starts [+27] ");
    String cell = scanner.nextLine();

    String regMessage = auth.registerUser(username, password, cell, fName, lName);
    System.out.println(regMessage);

    // --- Login (Only if registration was successful) ---
    if (regMessage.contains("successfully captured")) {
        System.out.println("\n--- Login ---");
        System.out.println("Username: ");
        String loginUser = scanner.nextLine();
        System.out.println("Password: ");
        String loginPass = scanner.nextLine();

        boolean success = auth.loginUser(loginUser, loginPass);
        System.out.println(auth.returnLoginStatus(success));
    }
}
