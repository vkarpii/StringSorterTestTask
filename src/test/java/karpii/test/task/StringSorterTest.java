package karpii.test.task;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringSorterTest {

    private final StringSorter sorter = new StringSorter();

    @Test
    void sortStringsTest() {
        List<String> inputList = List.of("apple", "banana", "grape", "avocado", "cherry");
        List<String> expected = List.of("banana", "cherry", "grape", "avocado", "apple");
        List<String> actual = sorter.sortStrings(inputList, "a");
        assertEquals(expected, actual);
    }

    @Test
    void sortStringsExceptionsTest1() {
        assertThrows(RuntimeException.class, () -> {
            sorter.sortStrings(null, "a");
        });
    }

    @Test
    void sortStringsExceptionTest2() {
        assertThrows(RuntimeException.class, () -> {
            sorter.sortStrings(List.of("apple", "banana"), null);
        });
    }
}