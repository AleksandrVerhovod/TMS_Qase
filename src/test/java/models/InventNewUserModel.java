package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InventNewUserModel {
    private String email;
    private String name;
    private String roleTitle;
    private String role;
}
