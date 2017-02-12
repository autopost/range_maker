package com.example.util;

import com.example.entity.Range;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Contains a set of utility methods
 */
public class Validator {

    private final static Logger logger = LoggerFactory.getLogger(Validator.class.getClass());

    /**
     * Validates given diapason and returns true if it is valid otherwise
     * returns false. Guarantees complexity is not more than O(1).
     *
     * @param range Range object
     * @return true if diapason is ok
     */
    public static boolean isValid(Range range) {
        int min = Integer.parseInt(range.getDiapasonMin());
        int max = Integer.parseInt(range.getDiapasonMax());
        if (min >= max) {
            logger.info("Min value more than Max value!");
            return false;
        }
        String rangeString = range.getRange();
        //means Range is not specified  - use whole diapason
        if (rangeString == null || rangeString.isEmpty()) {
            return true;
        }

        if (isValidRange(rangeString)) {
            int firstValue = Integer.parseInt("" + rangeString.charAt(0));
            int lastValue = Integer.parseInt("" + rangeString.charAt(rangeString.length() - 1));
            if (firstValue <= min || lastValue >= max) {
                return false;
            }
            int previousValue = -1;
            for (int i = 0; i < rangeString.length(); i++) {
                if ("-".equals("" + rangeString.charAt(i)) || ",".equals("" + rangeString.charAt(i))) {
                    //check if the next symbol is not numeric
                    if ("-".equals("" + rangeString.charAt(i + 1)) || ",".equals("" + rangeString.charAt(i + 1))) {
                        return false;
                    }
                    continue;
                }
                if (previousValue >= Integer.parseInt("" + rangeString.charAt(i))) {
                    return false;
                }
                previousValue = Integer.parseInt("" + rangeString.charAt(i));
            }

        } else {
            return false;
        }

        return true;
    }

    /**
     * Validates given range using regular expression
     *
     * @param range String pattern
     * @return true if valid
     */
    public static boolean isValidRange(String range) {
        Pattern p = Pattern.compile("[0-9][0-9,-]*([0-9])");
        Matcher m = p.matcher(range);
        return m.matches();
    }
}
