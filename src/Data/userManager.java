package Data;

import java.util.ArrayList;
import java.util.List;

public class userManager {
    private List<user> userList;

    public userManager() {
        this.userList = new ArrayList<>();
    }

    public void addUser(user newUser) {
        userList.add(newUser);
    }

    public void displayAllUsers() {
        for (user user : userList) {
            System.out.println("Full Name: " + user.getFullName());
            System.out.println("Username: " + user.getUsername());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Phone: " + user.getPhone());
            System.out.println("-----------------------------");
        }
    }
}