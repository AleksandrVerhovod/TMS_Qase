package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestRunsModel {
    private String runTitle;
    private String description;
    private String plan;
    private String environment;
    private String milestone;
    private String defaultAssignee;
    private String testCases;
}
