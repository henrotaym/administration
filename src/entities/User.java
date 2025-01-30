package entities;

import java.util.Optional;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Optional<Integer> id;

    public User(
        String firstName,
        String lastName,
        String email,
        String password,
        Optional<Integer> id
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public Optional<Integer> getId() {
        return this.id;
    }

    public String getPassword() {
        return this.password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
