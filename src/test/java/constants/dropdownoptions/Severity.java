package constants.dropdownoptions;

import java.util.Arrays;
import java.util.List;

public class Severity {
    public static List<String> getSeverity () {
        return Arrays.asList(
                "Not Set",
                "Blocker",
                "Critical",
                "Major",
                "Normal",
                "Minor",
                "Trivial",
                "Release 1.1");
    }
}
