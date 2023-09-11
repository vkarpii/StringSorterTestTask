package karpii.test.task;

import java.util.*;

import static java.util.Objects.isNull;


/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 * <p>
 * <p>
 * Implement in single class.
 */
public class StringSorter {
    /**
     * The StringSorter class defines the contract for sorting strings based on
     * alphabetical order while skipping words that start with a specific prefix.
     * <p>
     * Example:
     * Input: ["apple", "banana", "grape", "avocado", "cherry"], Exception prefix: "a"
     * Output: ["banana", "cherry", "grape", "avocado", "apple"]
     * <p>
     * Here, "banana", "cherry", and "grape" are sorted in alphabetical order
     * whereas "avocado" and "apple" (that start with 'a') are sorted in reverse alphabetical order
     * at the end of the list.
     */
    public List<String> sortStrings(List<String> unsortedStrings, String exceptionChar) {
        inputValidation(unsortedStrings, exceptionChar);

        List<String> modifiedList = new ArrayList<>(unsortedStrings);

        modifiedList.sort((a, b) -> {
            if (a.startsWith(exceptionChar) && b.startsWith(exceptionChar)) {
                return b.compareTo(a);
            } else if (a.startsWith(exceptionChar)) {
                return 1;
            } else if (b.startsWith(exceptionChar)) {
                return -1;
            } else {
                return a.compareTo(b);
            }
        });

        return modifiedList;
    }

    private void inputValidation(List<String> unsortedStrings, String exceptionChar) {
        if (isNull(unsortedStrings)) {
            throw new RuntimeException("List don`t created! (You pass NULL to unsortedStrings)");
        }
        if (exceptionChar.isBlank()) {
            throw new RuntimeException("You pass NULL or NOTHING to exceptionChar");
        }
    }
}