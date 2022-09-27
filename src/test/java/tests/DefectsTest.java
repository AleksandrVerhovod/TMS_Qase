package tests;

import models.CreateDefectModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DefectsPage;
import pages.services.LoginSite;
import testdata.PrepareCreateDefectData;

public class DefectsTest extends BaseTest {

    @Test
    public void createNewDefectTest() {
        LoginSite loginSite = new LoginSite(driver);
        loginSite.demoLogin();
        DefectsPage defectsPage = new DefectsPage(driver);
        CreateDefectModel createDefectModel = PrepareCreateDefectData.getValidDefectData();
        defectsPage.openDefectsPage()
                .clickCreateNewDefectButton()
                .sendCreateDefectForm(createDefectModel)
                .clickCreateDefectButton();
        Assert.assertTrue(defectsPage.isSuccessCreateMessageDisplayed(), "No success message");

    }

    @Test
    public void deleteDefectTest() {
        LoginSite loginSite = new LoginSite(driver);
        loginSite.demoLogin();
        DefectsPage defectsPage = new DefectsPage(driver);
        CreateDefectModel createDefectModel = PrepareCreateDefectData.getValidDefectData();
        defectsPage.openDefectsPage()
                .clickCreateNewDefectButton()
                .sendCreateDefectForm(createDefectModel)
                .clickCreateDefectButton();
        defectsPage.deleteDefect(createDefectModel.getDefectTitle());
        Assert.assertTrue(defectsPage.isSuccessDeleteMessageDisplayed());


    }
}