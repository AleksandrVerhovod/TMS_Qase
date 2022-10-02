package constants.dropdownoptions;

import java.util.Arrays;
import java.util.List;

public class Severity {
    public static List<String> getSeverity () {
        return Arrays.asList(
                "Not set",
                "Blocker",
                "Critical",
                "Major",
                "Normal",
                "Minor",
                "Trivial");
    }
}
