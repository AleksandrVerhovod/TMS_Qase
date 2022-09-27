package constants.dropdownoptions;

import java.util.Arrays;
import java.util.List;

public class AutomationStatus {
    public static List<String> getAutomationStatus () {
        return Arrays.asList(
                "Not automated",
                "To be automated",
                "Automated");
    }
}
