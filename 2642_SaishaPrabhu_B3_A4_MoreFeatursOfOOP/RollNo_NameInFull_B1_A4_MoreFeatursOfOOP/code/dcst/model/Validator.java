package dcst.model;

public class Validator {
    /** Throws a custom exception when the roll number is not like CST2301. */
    public static void checkRoll(String roll) throws InvalidDataException {
        if (roll == null || !roll.matches("CST\\d{4}")) {
            throw new InvalidDataException("Invalid roll number: " + roll);
        }
    }
}
