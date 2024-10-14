import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class UserService {
    private List<User> users = new ArrayList<>();


    public void createUser(User user) {
        users.add(user);
        System.out.println("User created: " + user);
    }

    public List<User> getAllUsers() {
        return users;
    }

    public Optional<User> getUserByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    }

    public boolean updateUser(String username, User updatedUser) {
        Optional<User> userOpt = getUserByUsername(username);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            user.setUsername(updatedUser.getUsername());
            user.setPassword(updatedUser.getPassword());
            user.setActive(updatedUser.isActive());
            System.out.println("User updated: " + user);
            return true;
        }
        return false;
    }

    public boolean deleteUser(String username) {
        Optional<User> userOpt = getUserByUsername(username);
        if (userOpt.isPresent()) {
            users.remove(userOpt.get());
            System.out.println("User deleted: " + username);
            return true;
        }
        return false;
    }

    public static boolean isValidPassword(String password) {
        String passwordPattern = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\W).{8,}$";
        return Pattern.compile(passwordPattern).matcher(password).matches();
    }
}
