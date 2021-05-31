import java.util.List;

public class ShowManager {

    String[] commandShowSplit ;
    User user;
    ShowExpense showExpense;

    ShowManager(String[] commandShowSplit) {
        this.commandShowSplit = commandShowSplit;
    }

    public void executeShowCommand() {
        if(commandShowSplit.length > 1) {
            String userId = commandShowSplit[1];
            List<User> userList = UserManager.getUserList();
            for(User user : userList) {
                if(user.getId().equals(userId)) {
                    this.user = user;
                }
            }
            executeUserShowBalance(user);
        } else {
            executeShowAll();
        }

    }

    private void executeUserShowBalance(User user) {
        showExpense = new ShowExpense(user);
        showExpense.displayUserBalance();
    }

    private void executeShowAll() {
       showExpense = new ShowExpense();
       showExpense.displayAllBalance();
    }
}
