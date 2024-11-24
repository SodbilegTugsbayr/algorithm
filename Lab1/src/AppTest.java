import org.junit.Assert;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AppTest {

    private int[] parseArrayFromString(String line) {
        String[] parts = line.trim().split(",\\s*");
        int[] array = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            array[i] = Integer.parseInt(parts[i]);
        }
        return array;
    }

    @Test
    public void testInsertionSort() {
        App app = new App();

        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/yujin/Desktop/algorithm/Lab1/src/sortTestCase.txt"))) {
            String line = reader.readLine();
            String[] tokens = line.split(":");
            int[] unsortedArray = parseArrayFromString(tokens[0]);

            int[] expectedSortedArray = parseArrayFromString(tokens[1]);

            int[] sortedArray = app.insertionSort(unsortedArray);

            reader.close();
            Assert.assertArrayEquals(expectedSortedArray, sortedArray);

        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("Error");
        }
    }

    @Test
    public void testMergeSort() {
        App app = new App();

        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/yujin/Desktop/algorithm/Lab1/src/sortTestCase.txt"))) {
            String line = reader.readLine();
            String[] tokens = line.split(":");
            int[] unsortedArray = parseArrayFromString(tokens[0]);

            int[] expectedSortedArray = parseArrayFromString(tokens[1]);

            app.mergeSort(unsortedArray, 0, unsortedArray.length-1);

            reader.close();
            Assert.assertArrayEquals(expectedSortedArray, unsortedArray);

        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("Error");
        }
    }

    @Test
    public void testBinarySearch() {
        App app = new App();

        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/yujin/Desktop/algorithm/Lab1/src/binarySearchTestCase.txt"))) {
            String line = reader.readLine();

            String[] tokens = line.split(":");

            int[] arr = parseArrayFromString(tokens[0]);

            int key = Integer.parseInt(tokens[1]);

            int expetedIndex = Integer.parseInt(tokens[2]);

            int index = app.binarySearch(arr, 0, arr.length-1, key);

            reader.close();
            Assert.assertEquals(expetedIndex, index);

        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("Error");
        }
    }

    @Test
    public void testFindMax() {
        App app = new App();

        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/yujin/Desktop/algorithm/Lab1/src/findMaxTestCase.txt"))) {
            String line = reader.readLine();

            String[] tokens = line.split(":");

            int[] arr = parseArrayFromString(tokens[0]);

            int expectedMax = Integer.parseInt(tokens[1]);


            int max = app.findMax(arr, 0, arr.length-1);

            reader.close();
            Assert.assertEquals(expectedMax, max);

        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("Error");
        }
    }
}
