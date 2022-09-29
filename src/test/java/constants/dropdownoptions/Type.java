package constants.dropdownoptions;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Type {

    public static List<String> getType () {
        return Arrays.asList(
                "Other",
                "Functional",
                "Smoke",
                "Regression",
                "Security",
                "Usability",
                "Performance",
                "Acceptance",
                "Compatibility",
                "Integration",
                "Exploratory");
    }

}
