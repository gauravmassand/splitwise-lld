import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserManager {

    static List<User> userList;
    static Map<User, Map<User,Double>>  userBalanceMap;

    UserManager() {
        userList = new ArrayList<>();
        userBalanceMap = new HashMap<>();
    }

    public List<User> createUsers() {
        User user1 = new User("u1","User1");
        User user2 = new User("u2","User2");
        User user3 = new User("u3","User3");
        User user4 = new User("u4","User4");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        return userList;
    }

    public void createUserBalanceMap() {
        for(User currentUser : userList) {
            Map<User,Double> userOweMap = getUserOweMap(currentUser);
            userBalanceMap.put(currentUser,userOweMap);
        }
    }

    private Map<User,Double> getUserOweMap(User currentUser) {
        Map<User,Double> userOweMap = new HashMap<>();
        for(User user: userList) {
            if(!user.equals(currentUser)) {
                userOweMap.put(user, 0.0);
            }
        }
        return userOweMap;
    }

    public static Map<User, Map<User,Double>> getUserBalanceMap() {
        return userBalanceMap;
    }

    public static List<User> getUserList() {
        return userList;
    }
}
