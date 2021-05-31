import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {

    String[] expenseLineSplit;
    List<String> userIds;
    ExpenseFactory expenseFactory;

    ExpenseManager(String[] expenseLineSplit) {
        this.expenseLineSplit = expenseLineSplit;
        expenseFactory = new ExpenseFactory();
    }

    public void executeExpenseCommand() {
        String payingUserID = expenseLineSplit[1];
        Double amountInvolved = Double.valueOf(expenseLineSplit[2]);
        int numOfUsers = Integer.valueOf(expenseLineSplit[3]);
        userIds = getUsersInvolved(numOfUsers);
        User payingUser = getPayingUser(payingUserID);
        String expenseType = expenseLineSplit[3 + userIds.size() + 1];
        Expense expense = expenseFactory.getInstance(expenseType);
        expense.executeExpense(payingUserID, amountInvolved, numOfUsers,userIds, payingUser, expenseLineSplit);
        System.out.println("Expense Recorded");
    }

    private List<String> getUsersInvolved(int numOfUser) {
        List<String> userIdList = new ArrayList<>();
        int startArgs = 4;
        while(numOfUser > 0) {
            userIdList.add(expenseLineSplit[startArgs]);
            startArgs++;
            numOfUser--;
        }
        return userIdList;
    }

    private User getPayingUser(String payingUserId) {
        User payingUser = null;
        List<User> userList = UserManager.getUserList();
        for(User user : userList) {
            if(user.getId().equals(payingUserId)) {
                payingUser = user;
            }
        }
        return payingUser;
    }
}
