import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExactExpense implements Expense{

    @Override
    public void executeExpense(String payingUserId, Double amount, int numOfUsers, List<String> usersInvolved,User payingUser,
                               String[] expenseSplit) {
        Map<User, Map<User,Double>> userBalanceMap= UserManager.getUserBalanceMap();
        List<Double> balanceList = getBalanceList(numOfUsers, expenseSplit);
        updateExpenseBalance(payingUser, usersInvolved, balanceList, userBalanceMap);
    }


    List<Double> getBalanceList(int numOfUsers, String[] expenseSplit) {
        List<Double> balanceList = new ArrayList<>();
        for(int i =1;i<=numOfUsers;i++) {
            balanceList.add(Double.valueOf(expenseSplit[3 + numOfUsers + 1 +i]));
        }
        return balanceList;
    }

    private void updateExpenseBalance(User payingUser, List<String> usersInvolved, List<Double> balances,
                                      Map<User, Map<User,Double>> userBalanceMap) {
        Map<User,Double> userOweMap = userBalanceMap.get(payingUser);
        for(Map.Entry<User, Double> userOweEntry : userOweMap.entrySet()) {
            User oweUser = userOweEntry.getKey();
            Double balance = userOweEntry.getValue();
            if(checkIfUserInvolved(usersInvolved, oweUser.getId())) {
                int indexOfUser = usersInvolved.indexOf(oweUser.getId());
                Double amountOwed = balances.get(indexOfUser);
                userOweMap.put(oweUser, balance + amountOwed);
            }
        }
        userBalanceMap.put(payingUser, userOweMap);
    }

    private boolean checkIfUserInvolved(List<String> usersInvolved, String userId) {
        return usersInvolved.contains(userId);
    }
}
