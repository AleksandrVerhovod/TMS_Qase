package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OnboardingModel {
    private String fullName;
    private String titleJob;
    private String role;
    private String companyName;
    private String companyDescribe;
    private String companyIndustry;
    private String workEmail;

}
