import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        CommandManager commandManager = new CommandManager();
        userManager.createUsers();
        userManager.createUserBalanceMap();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            commandManager.executeCommand(input);
        }

    }


}
