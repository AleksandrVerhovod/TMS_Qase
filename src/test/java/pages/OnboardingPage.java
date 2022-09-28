package pages;

import elements.Email;
import elements.Radiobutton;
import constants.Urls;
import models.OnboardingModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OnboardingPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class.getName());
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
        LOGGER.debug(String.format("Find Submit button on the Registration Page: %s", NUMBER_ABOUT_YOU));
        return NUMBER_ABOUT_YOU.isDisplayed();
    }

    public OnboardingPage openOnboardingPage() {
        LOGGER.debug(String.format("Attempt to open URL: %s", Urls.QASE_LOGIN_PAGE.concat(Urls.ONBOARDING_PAGE)));
        driver.get(Urls.QASE_LOGIN_PAGE.concat(Urls.ONBOARDING_PAGE));
        return this;
    }

    public ProjectsListPage sendOnboardingValidData(OnboardingModel onboardingModel) {
        FULL_NAME_INPUT.sendKeys(onboardingModel.getFullName());
        JOB_TITLE_INPUT.sendKeys(onboardingModel.getTitleJob());
        new Radiobutton(driver, "Role").selectRoleRadiobutton(onboardingModel.getRole());
        BUTTON_SAVE.click();
        COMPANY_NAME.sendKeys(onboardingModel.getFullName());
        new Radiobutton(driver, "CompanyDescribe").selectDescribesRadiobutton(onboardingModel.getCompanyDescribe());
        new Radiobutton(driver, "CompanyIndustry").selectIndustryRadiobutton(onboardingModel.getCompanyIndustry());
        BUTTON_SAVE.click();
        new Email(driver).sendEmailField(onboardingModel.getWorkEmail());
        BUTTON_SAVE.click();
        return new ProjectsListPage(driver);

    }


}
