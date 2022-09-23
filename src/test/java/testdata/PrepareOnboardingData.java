package testdata;

import models.OnboardingModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import utils.FakeMessageGenerator;

public class PrepareOnboardingData {

    private static final Logger LOGGER = LogManager.getLogger(PrepareRegistrationData.class.getName());
    public static OnboardingModel getOnboardingWithValidData() {
        LOGGER.debug("Prepare onboarding about you model with valid information");
        return OnboardingModel
                .builder()
                .fullName(FakeMessageGenerator.generateFullName())
                .titleJob(FakeMessageGenerator.generateJob())
                .role("developer")
                .companyName(FakeMessageGenerator.generateCompanyName())
                .companyDescribe("own_product")
                .companyIndustry("retail")
                .workEmail(FakeMessageGenerator.generateWorkEmail())
                .build();
    }

}
