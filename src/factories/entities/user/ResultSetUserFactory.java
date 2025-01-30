package factories.entities.user;

import java.sql.ResultSet;
import java.util.Optional;

import entities.User;
import interfaces.factories.UserFactory;

public class ResultSetUserFactory implements UserFactory {
    private ResultSet resultSet;

    public ResultSetUserFactory(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    @Override
    public User createUser() throws Exception {
        String firstName = this.resultSet.getString("first_name");
        String lastName = this.resultSet.getString("last_name");
        String email = this.resultSet.getString("email");
        String password = this.resultSet.getString("password");
        Integer id = this.resultSet.getInt("id");
        
        return new User(firstName, lastName, email, password, Optional.of(id));
    }
    
}
