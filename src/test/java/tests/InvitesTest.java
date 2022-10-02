package tests;

import io.qameta.allure.Description;
import models.InventNewUserModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InvitesPage;
import pages.LoginPage;
import pages.services.LoginSite;
import testdata.PrepareInviteNewUser;
import testdata.PrepareLoginData;
import testdata.PrepareRegistrationData;

public class InvitesTest extends BaseTest{
    private static final Logger LOGGER = LogManager.getLogger(InvitesTest.class.getName());
@Test
@Description("The user invite a new member")
    public void inviteNewValidMemberTest() {

    LoginSite loginSite = new LoginSite(getDriver());
    LOGGER.info(String.format("Page %s initialized", LoginSite.class.getName()));
    loginSite.demoLogin();
    LOGGER.info("Demo Login done");
    InvitesPage invitesPage = new InvitesPage(getDriver());
    LOGGER.info(String.format("Page %s initialized", InvitesPage.class.getName()));
    InventNewUserModel inventNewUserModel = PrepareInviteNewUser.getInventNewUserModel();
    LOGGER.info(String.format("Prepared valid data by %s", InventNewUserModel.class.getName()));
    invitesPage.openInvitesPage()
            .clickInviteNewMember()
            .sendInviteNewUserForm(inventNewUserModel);
    LOGGER.info("Check if confirmation message is displayed");
    Assert.assertTrue(invitesPage.isConfirmationMessageInvitedDisplayed(), "No confirmation message on display");
    }

}
