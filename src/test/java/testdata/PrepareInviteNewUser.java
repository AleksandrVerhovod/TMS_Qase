package testdata;


import models.InventNewUserModel;
import utils.GenerateTestData;

public class PrepareInviteNewUser {

    public static InventNewUserModel getInventNewUserModel () {
        return InventNewUserModel
                .builder()
                .email(GenerateTestData.generateEmail())
                .name(GenerateTestData.generateFullName())
                .roleTitle(GenerateTestData.generateRoleTitle())
                .role(GenerateTestData.getRoleUser())
                .build();

    }


}
