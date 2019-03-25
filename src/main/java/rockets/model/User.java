package rockets.model;

import java.util.Objects;

import static org.apache.commons.lang3.Validate.notBlank;

public class User extends Entity {

    //new
    private String firstName;

    private String lastName;

    private String email;

    private String password;

    public String getFirstName() {
        return firstName;
    }

    // ext.2. Add nonBlank constraint
    public void setFirstName(String firstName) {
        notBlank(firstName, "firstname cannot be null or empty");
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    // ext.3. Add nonBlank constraint
    public void setLastName(String lastName) {
        notBlank(lastName, "lastname cannot be null or empty");
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        notBlank(email, "email cannot be null or empty");
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    // ext.1. Add nonBlank constraint;
    //     2. Add constraint to test if the password is valid or not.
    //https://stackoverflow.com/questions/3802192/regexp-java-for-password-validation
    public void setPassword(String password) {
        notBlank(password, "password cannot be null or empty");
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        if (password.matches(pattern)){
                this.password = password;
        }
        else{
            throw new IllegalArgumentException("Invalid password");
        }

    }

    // match the given password against user's password and return the result
    public boolean isPasswordMatch(String password) {
        return this.password.equals(password.trim());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
