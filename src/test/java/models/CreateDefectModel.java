package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateDefectModel {
    private String defectTitle;
    private String actualResult;
    private String milestone;
    private String severity;
}
