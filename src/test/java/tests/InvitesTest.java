package tests;

import models.InventNewUserModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InvitesPage;
import pages.services.LoginSite;
import testdata.PrepareInviteNewUser;

public class InvitesTest extends BaseTest{

@Test
    public void inviteNewValidMemberTest() {
    LoginSite loginSite = new LoginSite(driver);
    loginSite.demoLogin();
    InvitesPage invitesPage = new InvitesPage(driver);
    InventNewUserModel inventNewUserModel = PrepareInviteNewUser.getInventNewUserModel();
    invitesPage.openInvitesPage()
            .clickInviteNewMember()
            .sendInviteNewUserForm(inventNewUserModel);
    Assert.assertTrue(invitesPage.isConfirmationMessageInvitedDisplayed(), "No confirmation message on display");




}

}
