package testdata;

import models.RegistrationModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import utils.FakeMessageGenerator;

public class PrepareRegistrationData {
    private static final Logger LOGGER = LogManager.getLogger(PrepareRegistrationData.class.getName());
    public static RegistrationModel getRegistrationWithValidData() {
        String password = FakeMessageGenerator.generatePassword();
        LOGGER.debug("Prepare registration model with valid information");
        return RegistrationModel
                .builder()
                .email(FakeMessageGenerator.generateEmail())
                .password(password)
                .confirmPassword(password)
                .build();
    }

    public static RegistrationModel getRegistrationWithoutEmail() {
        String password = FakeMessageGenerator.generatePassword();
        LOGGER.debug("Prepare registration model without email");
        return RegistrationModel
                .builder()
                .password(password)
                .confirmPassword(password)
                .build();
    }

    public static RegistrationModel getRegistrationDataWithoutConfirmPassword() {
        LOGGER.debug("Prepare registration model without confirm password");
        return RegistrationModel
                .builder()
                .email(FakeMessageGenerator.generateEmail())
                .password(FakeMessageGenerator.generatePassword())
                .build();
    }

    public static RegistrationModel getRegistrationWithNoEqualsPassAndConfirmPass() {
        LOGGER.debug("Prepare registration model where no equals password and confirm password");
        return RegistrationModel
                .builder()
                .email(FakeMessageGenerator.generateEmail())
                .password(FakeMessageGenerator.generatePassword())
                .confirmPassword(FakeMessageGenerator.generatePassword())
                .build();
    }
}
