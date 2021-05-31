import java.util.List;
import java.util.Map;

public class EqualExpense implements Expense {

    @Override
    public void executeExpense(String payingUserId, Double amount,int numOfUsers, List<String> usersInvolved,User payingUser,
                               String[] expenseSplit) {
        Map<User, Map<User,Double>> userBalanceMap= UserManager.getUserBalanceMap();
        Double individualBalanceAmount = amount/numOfUsers;
        updateUserBalanceMap(userBalanceMap, payingUser,individualBalanceAmount);
    }

    private void updateUserBalanceMap(Map<User,Map<User,Double>> userBalanceMap, User payingUser,Double balance) {
        Map<User,Double> userOweMap = userBalanceMap.get(payingUser);
        for(Map.Entry<User,Double> userOweEntry : userOweMap.entrySet()) {
            User user = userOweEntry.getKey();
            Double userBalance = userOweEntry.getValue();
            userOweMap.put(user, userBalance + balance);
        }
        userBalanceMap.put(payingUser, userOweMap);
    }
}
