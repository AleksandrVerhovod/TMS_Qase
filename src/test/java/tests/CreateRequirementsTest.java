package tests;

import io.qameta.allure.Description;
import models.CreateRequirementsModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CreateRequirementsPage;
import pages.services.LoginSite;
import testdata.PrepareCreateRequirementsData;
import testdata.PrepareCreateTestCase;
import testdata.PrepareRegistrationData;

public class CreateRequirementsTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(CreateRequirementsTest.class.getName());
    @Test
    @Description("The user creates a new requirement with valid values for the fields")
    public void createRequirementsValidDataTest () {
        LoginSite loginSite = new LoginSite(getDriver());
        LOGGER.info(String.format("Page %s initialized", LoginSite.class.getName()));
        loginSite.demoLogin();
        LOGGER.info("Demo Login done");
        CreateRequirementsPage createRequirementsPage = new CreateRequirementsPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", CreateRequirementsPage.class.getName()));
        CreateRequirementsModel createRequirementsModel = PrepareCreateRequirementsData.getCreateRequirementsValidData();
        LOGGER.info(String.format("Prepared valid data by %s", PrepareCreateRequirementsData.class.getName()));
        createRequirementsPage.openCreateReqPage()
                .clickCreateReqButton()
                .fillNewRequirement(createRequirementsModel);
        LOGGER.info("Check if title of the new requirement is displayed");
        Assert.assertTrue(createRequirementsPage.getTitleRequirements(createRequirementsModel.getTitle()));

    }
}
