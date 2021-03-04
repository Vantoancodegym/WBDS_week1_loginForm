package service;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private static List<User> users=new ArrayList<>();
    static {
        users.add(new User("toan","123456"));
        users.add(new User("toan1","123456"));
        users.add(new User("toan2","123456"));
        users.add(new User("toan3","123456"));
        users.add(new User("toan4","123456"));
        users.add(new User("toan5","123456"));
        users.add(new User("toan6","123456"));

    }
    public User checkLogin(User user){
        for (User u: users) {
            if(u.getAccount().equals(user.getAccount())
                    && u.getPassword().equals(user.getPassword())){
                return u;
            }
        }
        return null;
    }
}
