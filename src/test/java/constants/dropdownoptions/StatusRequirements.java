package constants.dropdownoptions;

import java.util.Arrays;
import java.util.List;

public class StatusRequirements {
    public static List<String> getStatusReq () {
        return Arrays.asList(
                "Valid",
                "Draft",
                "Review",
                "Rework",
                "Finish",
                "Implemented",
                "Not testable",
                "Obsolete"
                );
    }
}
