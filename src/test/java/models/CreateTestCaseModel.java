package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateTestCaseModel {
    private String title;
    private String status;
    private String description;
    private String suite;
    private String severity;
    private String priority;
    private String type;
    private String layer;
    private String isFlaky;
    private String milestone;
    private String behavior;
    private String automationStatus;
    private String preCondition;
    private String postConditions;
    private String steps;
    private String action;
    private String inputData;
    private String expectedResult;

}
