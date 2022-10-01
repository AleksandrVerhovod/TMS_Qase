package tests;

import models.CreateDefectModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DefectsPage;
import pages.services.LoginSite;
import testdata.PrepareCreateDefectData;

public class DefectsTest extends BaseTest {

    @Test (priority = 1, description = "The user creates a new defect with valid values for the fields")
    public void createNewDefectTest() {
        LoginSite loginSite = new LoginSite(getDriver());
        loginSite.demoLogin();
        DefectsPage defectsPage = new DefectsPage(getDriver());
        CreateDefectModel createDefectModel = PrepareCreateDefectData.getValidDefectData();
        defectsPage.openDefectsPage()
                .clickCreateNewDefectButton()
                .sendCreateDefectForm(createDefectModel)
                .clickCreateDefectButton();
        Assert.assertTrue(defectsPage.isSuccessCreateMessageDisplayed(), "No success message");

    }

    @Test (priority = 2, description = "The user creates a new defect and then delete it")
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