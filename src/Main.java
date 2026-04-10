//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    public class Main {
        public static void main(String[] args) {
            // Create a user
            Username user = new Username(System.in);

            // Create login system
            Login login = new Login();

            // Register user
            System.out.println(login.registerUser(user));

            // Attempt login with correct details
            System.out.println(login.returnLoginStatus("kyl_1", "Ch&&sec@ke99!"));

            // Attempt login with incorrect details
            System.out.println(login.returnLoginStatus("wrong", "password"));
        }
    }

}

