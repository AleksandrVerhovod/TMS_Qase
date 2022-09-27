package constants.dropdownoptions;

import java.util.Arrays;
import java.util.List;

public class Status {

    public static List<String> getStatus () {
        return Arrays.asList(
                "Actual",
                "Draft",
                "Deprecated");
    }
}
