package bg.softuni.pathfinderproject.validation.validator;

import bg.softuni.pathfinderproject.service.UserService;
import bg.softuni.pathfinderproject.validation.annotation.EmailUniqueValue;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailUniqueValueValidator implements ConstraintValidator<EmailUniqueValue, String> {

    private final UserService userService;

    @Autowired
    public EmailUniqueValueValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null) {
            return true;
        }

        return this.userService.checkForNonExistingEmail(value);
    }

}