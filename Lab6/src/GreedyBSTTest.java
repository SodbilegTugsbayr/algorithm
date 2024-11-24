import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GreedyBSTTest {
    private int[] parseArrayFromString(String line) {
        String[] parts = line.trim().split(",\\s*");
        int[] array = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            array[i] = Integer.parseInt(parts[i]);
        }
        return array;
    }

    @Test
    public void testMinSearchCost() {
        GreedyBST g = new GreedyBST();
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/yujin/Desktop/algorithm/Lab6/src/test.txt"))) {
            String line = reader.readLine();
            String[] tokens = line.split(":");
            reader.close();
        
            int[] keys = parseArrayFromString(tokens[0]);
            int[] freq = parseArrayFromString(tokens[1]);
            int expected = Integer.parseInt(tokens[2]);
        
            assertEquals(expected, g.minSearchCost(keys, freq));
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail("Error");
        }
    }
}
