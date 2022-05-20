package utils;

public class Str {

    // check number
    public static boolean isNumeric(String s) {
        return s!=null && s.matches("^[+-]?\\d+(\\.\\d+)?");
    }
    // check number non-negative
    public static boolean isNonNegNum(String s) {
        return s!=null && s.matches("\\d+(\\.\\d+)?");
    }
    // check non-negative num can be transport to double
    public static boolean isNonNegDouble(String s) {
        if (!isNonNegNum(s))
            return false;
        try {
            Double.valueOf(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // check integer
    public static boolean isInt(String s) {
        return s!=null && s.matches("^[+-]?[\\d]+$");
    }
    // check non-negative integer
    public static boolean isNonNegInt(String s) {
        return s!=null && s.matches("[\\d]+$");
    }
    // check non-negative integer that can be transport to dataType int
    public static boolean isNonNegInteger(String s) {
        if (!isNonNegInt(s))
            return false;
        try {
            Integer.valueOf(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    // check positive integer that can be transport to dataType int
    public static boolean isPosInt(String s) {
        if (!isNonNegInt(s))
            return false;
        try {
            return Integer.parseInt(s)>0;
        } catch (Exception e) {
            return false;
        }
    }
}
