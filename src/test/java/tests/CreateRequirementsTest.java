package tests;

import models.CreateRequirementsModel;
import org.testng.annotations.Test;
import pages.CreateRequirementsPage;
import pages.services.LoginSite;
import testdata.PrepareCreateRequirementsData;

public class CreateRequirementsTest extends BaseTest {

    @Test
    public void createRequirementsValidDataTest () {
        LoginSite loginSite = new LoginSite(driver);
        loginSite.demoLogin();
        CreateRequirementsPage createRequirementsPage = new CreateRequirementsPage(driver);
        CreateRequirementsModel createRequirementsModel = PrepareCreateRequirementsData.getCreateRequirementsValidData();
        createRequirementsPage.openCreateReqPage()
                .clickCreateReqButton()
                .fillNewRequirement(createRequirementsModel);



    }
}
