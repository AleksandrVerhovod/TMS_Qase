package testdata;


import models.InventNewUserModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import utils.GenerateTestData;

public class PrepareInviteNewUser {
    private static final Logger LOGGER = LogManager.getLogger(PrepareInviteNewUser.class.getName());

    public static InventNewUserModel getInventNewUserModel () {
        LOGGER.info("Generate new user valid data");
        return InventNewUserModel
                .builder()
                .email(GenerateTestData.generateEmail())
                .name(GenerateTestData.generateFullName())
                .roleTitle(GenerateTestData.generateRoleTitle())
                .role(GenerateTestData.getRoleUser())
                .build();

    }


}
