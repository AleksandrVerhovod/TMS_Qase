package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateProjectModel {
    private String projectName;
    private String projectCode;
    private String descriptionProject;

}
