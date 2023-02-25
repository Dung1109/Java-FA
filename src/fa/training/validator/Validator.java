package fa.training.validator;

/**
 * @author AnhNN66
 * @version 1.0
 * @created 01-�?�?-2021 10:00:00
 * Validate input
 */
public class Validator {
    private static final String DOUBLE_VALID_REGEX = "^[0-9]+(\\.[0-9]+)?$";

    public static boolean isDouble(String input) {
        return input.matches(DOUBLE_VALID_REGEX);
    }
}
