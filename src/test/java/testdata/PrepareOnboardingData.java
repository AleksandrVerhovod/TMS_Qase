package testdata;

import models.OnboardingModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import utils.GenerateTestData;

public class PrepareOnboardingData {

    private static final Logger LOGGER = LogManager.getLogger(PrepareRegistrationData.class.getName());
    public static OnboardingModel getOnboardingWithValidData() {
        LOGGER.debug("Prepare onboarding about you model with valid information");
        return OnboardingModel
                .builder()
                .fullName(GenerateTestData.generateFullName())
                .titleJob(GenerateTestData.generateJob())
                .role("developer")
                .companyName(GenerateTestData.generateCompanyName())
                .companyDescribe("own_product")
                .companyIndustry("retail")
                .workEmail(GenerateTestData.generateWorkEmail())
                .build();
    }

}
