package tests;

import models.InventNewUserModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InvitesPage;
import pages.services.LoginSite;
import testdata.PrepareInviteNewUser;

public class InvitesTest extends BaseTest{

@Test (description = "The user invite a new member")
    public void inviteNewValidMemberTest() {
    LoginSite loginSite = new LoginSite(getDriver());
    loginSite.demoLogin();
    InvitesPage invitesPage = new InvitesPage(getDriver());
    InventNewUserModel inventNewUserModel = PrepareInviteNewUser.getInventNewUserModel();
    invitesPage.openInvitesPage()
            .clickInviteNewMember()
            .sendInviteNewUserForm(inventNewUserModel);
    Assert.assertTrue(invitesPage.isConfirmationMessageInvitedDisplayed(), "No confirmation message on display");




}

}
