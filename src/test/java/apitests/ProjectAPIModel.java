package apitests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectAPIModel {

    private boolean status;
    private String total;
    private String count;
    private String title;
    private String code;
    private String description;
    private String access;
    private String group;


}
