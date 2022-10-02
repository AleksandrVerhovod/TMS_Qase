package constants.dropdownoptions;

import java.util.Arrays;
import java.util.List;

public class Priority {

    public static List<String> getPriority() {
        return Arrays.asList(
                "Not set",
                "High",
                "Medium",
                "Low");
    }
}
