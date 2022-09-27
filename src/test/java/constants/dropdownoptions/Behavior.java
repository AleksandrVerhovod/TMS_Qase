package constants.dropdownoptions;

import java.util.Arrays;
import java.util.List;

public class Behavior {
    public static List<String> getBehavior () {
        return Arrays.asList(
                "Not set",
                "Positive",
                "Destructive",
                "Negative");
    }
}
