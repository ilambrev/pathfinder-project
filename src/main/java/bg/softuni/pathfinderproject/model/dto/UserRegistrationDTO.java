package bg.softuni.pathfinderproject.model.dto;

import bg.softuni.pathfinderproject.validation.annotation.EmailUniqueValue;
import bg.softuni.pathfinderproject.validation.annotation.PasswordMatching;
import bg.softuni.pathfinderproject.validation.annotation.UsernameUniqueValue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@PasswordMatching(
        password = "password",
        confirmPassword = "confirmPassword",
        message = "Password and Confirm Password must be matched!"
)
public class UserRegistrationDTO {

    @NotNull
    @UsernameUniqueValue
    @Size(min = 2, message = "Username must be at least 2 characters!")
    private String username;

    @NotNull
    @Size(min = 2, message = "Full name must be at least 2 characters!")
    private String fullName;

    @NotNull
    @EmailUniqueValue
    @Email(message = "Please, enter valid email address!")
    private String email;

    @Positive(message = "Age of user must be positive value!")
    private Integer age;

    @NotNull
    @Size(min = 2, message = "Password must be at least 2 characters!")
    private String password;

    @NotNull
    @Size(min = 2)
    private String confirmPassword;

    public UserRegistrationDTO() {

    }

    public String getUsername() {
        return username;
    }

    public UserRegistrationDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserRegistrationDTO setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegistrationDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserRegistrationDTO setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegistrationDTO setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegistrationDTO setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

}