package bg.softuni.pathfinderproject.validation.validator;

import bg.softuni.pathfinderproject.service.UserService;
import bg.softuni.pathfinderproject.validation.annotation.UsernameUniqueValue;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UsernameUniqueValueValidator implements ConstraintValidator<UsernameUniqueValue, String> {

    private final UserService userService;

    @Autowired
    public UsernameUniqueValueValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null) {
            return true;
        }

        return this.userService.checkForNonExistingUsername(value);
    }

}