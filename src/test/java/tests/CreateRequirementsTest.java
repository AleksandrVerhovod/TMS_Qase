package tests;

import models.CreateRequirementsModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateRequirementsPage;
import pages.services.LoginSite;
import testdata.PrepareCreateRequirementsData;

public class CreateRequirementsTest extends BaseTest {

    @Test (description = "The user creates a new requirement with valid values for the fields")
    public void createRequirementsValidDataTest () {
        LoginSite loginSite = new LoginSite(getDriver());
        loginSite.demoLogin();
        CreateRequirementsPage createRequirementsPage = new CreateRequirementsPage(getDriver());
        CreateRequirementsModel createRequirementsModel = PrepareCreateRequirementsData.getCreateRequirementsValidData();
        createRequirementsPage.openCreateReqPage()
                .clickCreateReqButton()
                .fillNewRequirement(createRequirementsModel);
        Assert.assertTrue(createRequirementsPage.getTitleRequirements(createRequirementsModel.getTitle()));



    }
}
