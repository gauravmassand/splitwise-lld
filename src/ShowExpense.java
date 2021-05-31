import java.util.Map;

public class ShowExpense {

    User user;

    ShowExpense(User user) {
        this.user = user;
    }

    ShowExpense() {
        //empty Constructor
    }

    public void displayAllBalance() {
        Map<User, Map<User,Double>> userBalanceMap = UserManager.getUserBalanceMap();
        for(Map.Entry<User,Map<User,Double>> mapEntry : userBalanceMap.entrySet()) {
            User user = mapEntry.getKey();
            Map<User, Double> oweBalanceMap = mapEntry.getValue();
            for (Map.Entry<User, Double> oweMapEntry : oweBalanceMap.entrySet()) {
                User balanceUser = oweMapEntry.getKey();
                Double balance = oweMapEntry.getValue();
                System.out.println(user.getId() + " owes " + balanceUser.getId() + " " + balance);
            }
        }
    }

    public void displayUserBalance() {
        Map<User,Double> userBalanceMap = UserManager.getUserBalanceMap().get(user);
        for(Map.Entry<User, Double> userBalanceEntry : userBalanceMap.entrySet()) {
            User balanceUser = userBalanceEntry.getKey();
            Double balance = userBalanceEntry.getValue();
            System.out.println("User " + user.getId() + " owes " + balanceUser.getId() + " " + balance);
        }
    }

}
