package pages;

import elements.Email;
import elements.Checkbox;
import constants.Urls;
import io.qameta.allure.Step;
import models.OnboardingModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OnboardingPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(OnboardingPage.class.getName());

    @FindBy(xpath = "//div[@class='onboarding-left-column']//span[text()='1']")
    private WebElement NUMBER_ABOUT_YOU;

    @FindBy(css = "#fullName")
    private WebElement FULL_NAME_INPUT;

    @FindBy(css = "#jobTitle")
    private WebElement JOB_TITLE_INPUT;

    @FindBy(css = "#companyName")
    private WebElement COMPANY_NAME;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement BUTTON_SAVE;


    public OnboardingPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        LOGGER.debug(String.format("Attempt to find number: %s", NUMBER_ABOUT_YOU));
        return NUMBER_ABOUT_YOU.isDisplayed();
    }

    @Step("Open onboarding page")
    public OnboardingPage openOnboardingPage() {
        LOGGER.debug(String.format("Attempt to open URL: %s", Urls.QASE_LOGIN_PAGE.concat(Urls.ONBOARDING_PAGE)));
        driver.get(Urls.QASE_LOGIN_PAGE.concat(Urls.ONBOARDING_PAGE));
        return this;
    }

    @Step("Fill onboarding form by valid random data")
    public ProjectsListPage sendOnboardingValidData(OnboardingModel onboardingModel) {
        FULL_NAME_INPUT.sendKeys(onboardingModel.getFullName());
        LOGGER.debug(String.format("Input email: %s", onboardingModel.getFullName()));
        JOB_TITLE_INPUT.sendKeys(onboardingModel.getTitleJob());
        LOGGER.debug(String.format("Input Title job: %s", onboardingModel.getTitleJob()));
        new Checkbox(driver, "Role").selectRoleCheckbox(onboardingModel.getRole());
        LOGGER.debug(String.format("Select checkbox Role: %s", onboardingModel.getRole()));
        LOGGER.debug(String.format("Attempt to click button: %s", BUTTON_SAVE));
        BUTTON_SAVE.click();
        COMPANY_NAME.sendKeys(onboardingModel.getFullName());
        LOGGER.debug(String.format("Input Company Name: %s", onboardingModel.getFullName()));
        new Checkbox(driver, "CompanyDescribe").selectDescribesCheckbox(onboardingModel.getCompanyDescribe());
        LOGGER.debug(String.format("Select checkbox Company Describe: %s", onboardingModel.getCompanyDescribe()));
        new Checkbox(driver, "CompanyIndustry").selectIndustryCheckbox(onboardingModel.getCompanyIndustry());
        LOGGER.debug(String.format("Select checkbox CompanyIndustry: %s", onboardingModel.getCompanyIndustry()));
        LOGGER.debug(String.format("Attempt to click button: %s", BUTTON_SAVE));
        BUTTON_SAVE.click();
        new Email(driver).sendEmailField(onboardingModel.getWorkEmail());
        LOGGER.debug(String.format("Input Work Email: %s", onboardingModel.getWorkEmail()));
        LOGGER.debug(String.format("Attempt to click button: %s", BUTTON_SAVE));
        BUTTON_SAVE.click();
        return new ProjectsListPage(driver);

    }
}
