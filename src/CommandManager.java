public class CommandManager {

    ShowManager showManager;
    ExpenseManager expenseManager;

    public void executeCommand(String inputCommand) {
        String[] commandSplit = inputCommand.split(" ");
        String command = commandSplit[0];
        switch (command) {
            case "SHOW" :
                showManager = new ShowManager(commandSplit);
                showManager.executeShowCommand();
                break;
            case "EXPENSE" :
                expenseManager = new ExpenseManager(commandSplit);
                expenseManager.executeExpenseCommand();
                break;
            case "EXIT" :
                System.exit(1);
        }
    }
}
