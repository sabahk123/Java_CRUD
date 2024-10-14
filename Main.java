import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        int choice;
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Enter your choice: ");
            System.out.println("1. Create User 2. Delete User 3. Update User 4. Display Users 5. Exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    String username, password;
                    boolean active;
                    
                    System.out.println("Enter the username: ");
                    username = scanner.next();
                    
                    while (true) {
                        System.out.println("Enter the password (min 8 chars, 1 uppercase, 1 lowercase, 1 symbol): ");
                        password = scanner.next();
                        if (UserService.isValidPassword(password)) {
                            break;
                        } else {
                            System.out.println("Invalid password! Please try again.");
                        }
                    }
                    
                    System.out.println("Is the user active? Enter true or false: ");
                    active = scanner.nextBoolean();
                    
                    userService.createUser(new User(username, password, active));
                    break;
                    
                case 2:
                    System.out.println("Enter the username to delete: ");
                    String deleteUsername = scanner.next();
                    userService.deleteUser(deleteUsername);
                    break;
                    
                case 3:
                    String updateUsername, newPassword;
                    boolean isActive;
                    
                    System.out.println("Enter the username to update: ");
                    updateUsername = scanner.next();
                    
                    while (true) {
                        System.out.println("Enter the new password (min 8 chars, 1 uppercase, 1 lowercase, 1 symbol): ");
                        newPassword = scanner.next();
                        if (UserService.isValidPassword(newPassword)) {
                            break;
                        } else {
                            System.out.println("Invalid password! Please try again.");
                        }
                    }
                    
                    System.out.println("Is the user active? Enter true or false: ");
                    isActive = scanner.nextBoolean();
                    
                    userService.updateUser(updateUsername, new User(updateUsername, newPassword, isActive));
                    break;
                    
                case 4:
                    System.out.println("Displaying all user details: ");
                    System.out.println(userService.getAllUsers());
                    break;
                    
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }
}
