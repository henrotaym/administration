package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.User;
import factories.entities.user.ResultSetUserFactory;

public class UserRepository {
    private Connection connection;

    public UserRepository(Connection connection) {
        this.connection = connection;
    }

    public List<User> findAll() throws Exception {
        List<User> users = new ArrayList<User>();

        PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM users");
        ResultSet resultSet = statement.executeQuery();

         while (resultSet.next()) {
            User user = new ResultSetUserFactory(resultSet).createUser();
            users.add(user);
        }

        return users;
    }

    public User findById(Integer id) throws Exception {
        PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM users WHERE id = ?");
        statement.setInt(1, id);

        ResultSet resultSet = statement.executeQuery();
        resultSet.next();

        return new ResultSetUserFactory(resultSet).createUser();
    }

    public Boolean save(User user) throws Exception {
        return user.getId().isEmpty()
            ? this.store(user)
            : this.update(user);
    }

    private Boolean store(User user) throws Exception {
        PreparedStatement statement = this.connection.prepareStatement("INSERT INTO users (last_name, first_name, email, password) VALUES (?, ?, ?, ?)");

        statement.setString(1, user.getLastName());
        statement.setString(2, user.getFirstName());
        statement.setString(3, user.getEmail());
        statement.setString(4, user.getPassword());

        return statement.executeUpdate() > 0;
    }

    private Boolean update(User user) throws Exception {
        // TODO
        return true;
    }

    public Boolean destroy(User user) throws Exception {
        // TODO
        return true;
    }
}
