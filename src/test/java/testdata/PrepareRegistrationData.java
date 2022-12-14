package testdata;

import models.RegistrationModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import utils.GenerateTestData;

public class PrepareRegistrationData {
    private static final Logger LOGGER = LogManager.getLogger(PrepareRegistrationData.class.getName());
    public static RegistrationModel getRegistrationWithValidData() {
        String password = GenerateTestData.generatePassword();
        LOGGER.debug("Prepare registration model with valid information");
        return RegistrationModel
                .builder()
                .email(GenerateTestData.generateEmail())
                .password(password)
                .confirmPassword(password)
                .build();
    }

    public static RegistrationModel getRegistrationWithoutEmail() {
        String password = GenerateTestData.generatePassword();
        LOGGER.debug("Prepare registration model without email");
        return RegistrationModel
                .builder()
                .email("")
                .password(password)
                .confirmPassword(password)
                .build();
    }

    public static RegistrationModel getRegistrationDataWithoutConfirmPassword() {
        LOGGER.debug("Prepare registration model without confirm password");
        return RegistrationModel
                .builder()
                .email(GenerateTestData.generateEmail())
                .password(GenerateTestData.generatePassword())
                .confirmPassword("")
                .build();
    }

    public static RegistrationModel getRegistrationWithNoEqualsPassAndConfirmPass() {
        LOGGER.debug("Prepare registration model where no equals password and confirm password");
        return RegistrationModel
                .builder()
                .email(GenerateTestData.generateEmail())
                .password(GenerateTestData.generatePassword())
                .confirmPassword(GenerateTestData.generatePassword())
                .build();
    }
}
