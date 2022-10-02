package tests;

import io.qameta.allure.Description;
import models.CreateDefectModel;
import models.InventNewUserModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DefectsPage;
import pages.InvitesPage;
import pages.services.LoginSite;
import testdata.PrepareCreateDefectData;
import testdata.PrepareRegistrationData;

public class DefectsTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(DefectsTest.class.getName());

    @Test (priority = 1)
    @Description ("The user creates a new defect with valid values for the fields")
    public void createNewDefectTest() {
        LoginSite loginSite = new LoginSite(getDriver());
        LOGGER.info(String.format("Page %s initialized", LoginSite.class.getName()));
        loginSite.demoLogin();
        LOGGER.info("Demo Login done");
        DefectsPage defectsPage = new DefectsPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", DefectsPage.class.getName()));
        CreateDefectModel createDefectModel = PrepareCreateDefectData.getValidDefectData();
        LOGGER.info(String.format("Prepared valid data by %s", PrepareCreateDefectData.class.getName()));
        LOGGER.info("Input information into fields");
        defectsPage.openDefectsPage()
                .clickCreateNewDefectButton()
                .sendCreateDefectForm(createDefectModel)
                .clickCreateDefectButton();
        LOGGER.info("Check if success message is displayed");
        Assert.assertTrue(defectsPage.isSuccessCreateMessageDisplayed(), "No success message");

    }

    @Test (priority = 2)
    @Description("The user creates a new defect and then delete it")
    public void deleteDefectTest() {
        LoginSite loginSite = new LoginSite(getDriver());
        loginSite.demoLogin();
        DefectsPage defectsPage = new DefectsPage(getDriver());
        CreateDefectModel createDefectModel = PrepareCreateDefectData.getValidDefectData();
        defectsPage.openDefectsPage()
                .clickCreateNewDefectButton()
                .sendCreateDefectForm(createDefectModel)
                .clickCreateDefectButton();
        defectsPage.deleteDefect(createDefectModel.getDefectTitle());
        Assert.assertTrue(defectsPage.isSuccessDeleteMessageDisplayed());


    }
}