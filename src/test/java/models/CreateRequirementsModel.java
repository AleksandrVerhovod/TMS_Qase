package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateRequirementsModel {
    private String title;
    private String description;
    private String parent;
    private String status;
    private String type;
}
