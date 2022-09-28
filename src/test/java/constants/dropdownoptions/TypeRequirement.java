package constants.dropdownoptions;

import java.util.Arrays;
import java.util.List;

public class TypeRequirement {

    public static List<String> getTypeReq () {
        return Arrays.asList(
                "Epic",
                "User story",
                "Feature");
    }
}
