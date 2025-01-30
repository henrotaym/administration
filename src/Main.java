import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Optional;

import entities.User;
import repositories.UserRepository;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://database:3306/app", "user", "password");
            UserRepository userRepository = new UserRepository(connection);
            List<User> users = userRepository.findAll();
            User user = userRepository.findById(1);
            System.out.println(users.get(1).getEmail());
            System.out.println(user.getLastName());

            User userToInsert = new User("mathieu", "henrotay", "test@trustup.be", "trust", Optional.empty());

            System.out.println(userRepository.save(userToInsert));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}