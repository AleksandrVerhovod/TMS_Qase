package testdata;

import constants.Credentials;
import models.LoginModel;
import utils.FakeMessageGenerator;

public class PrepareLoginData {

    public static LoginModel getValidLogin() {
        return LoginModel
                .builder()
                .email(Credentials.EMAIL_VALID)
                .password(Credentials.PASSWORD_VALID)
                .build();
    }

    public static LoginModel getFakeEmailLogin() {
        return LoginModel
                .builder()
                .email(FakeMessageGenerator.generateEmail())
                .password(Credentials.PASSWORD_VALID)
                .build();
    }

    public static LoginModel getFakePasswordLogin() {
        return LoginModel
                .builder()
                .email(Credentials.EMAIL_VALID)
                .password(FakeMessageGenerator.generatePassword())
                .build();
    }

    public static LoginModel getLoginWithEmptyFieldsLogin() {
        return LoginModel
                .builder()
                .email("")
                .password("")
                .build();
    }
}
