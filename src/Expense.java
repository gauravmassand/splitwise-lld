import java.util.List;

public interface Expense {

    void executeExpense(String payingUserId, Double amount, int numOfUsers, List<String> usersInvolved, User payingUser,
                        String[] expenseSplit);
}
