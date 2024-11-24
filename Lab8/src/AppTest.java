import org.junit.Assert;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppTest {
  public App app = new App();

  public static int[] parseArrayFromString(String input) {
    String[] tokens = input.split(",\\s*");
    int[] result = new int[tokens.length];
    
    for (int i = 0; i < tokens.length; i++) {
        result[i] = Integer.parseInt(tokens[i]);
    }
    
    return result;
}


  public static int[][] parse2DArray(String input) {
    String[] pairs = input.replaceAll("[\\[\\]]", "").split("\\], \\[");
    
    List<int[]> list = new ArrayList<>();

    for (String pair : pairs) {
        String[] numbers = pair.split(", ");
        int[] row = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            row[i] = Integer.parseInt(numbers[i]);
        }
        list.add(row);
    }

    return list.toArray(new int[list.size()][]);
  }

  @Test
  public void coinTest(){
    try (BufferedReader reader = new BufferedReader(new FileReader("/Users/yujin/Desktop/algorithm/Lab8/src/cointest.txt"))) {
      String line = reader.readLine();
      String[] tokens = line.split(":");
      reader.close();

      int[] coin = parseArrayFromString(tokens[0]);
      int amount = Integer.parseInt(tokens[1]);
      int expected = Integer.parseInt(tokens[2]);

      int n = app.coinChange(coin, amount);

      Assert.assertEquals(expected, n);
    } catch (IOException e) {
        e.printStackTrace();
        Assert.fail("Error");
    }
  }

  @Test
  public void countPrimesTest() {
    try (BufferedReader reader = new BufferedReader(new FileReader("/Users/yujin/Desktop/algorithm/Lab8/src/primetest.txt"))) {
      String line = reader.readLine();
      String[] tokens = line.split(":");
      reader.close();

      int given = Integer.parseInt(tokens[0]);
      int expected = Integer.parseInt(tokens[1]);

      int n = app.countPrimes(given);

      Assert.assertEquals(expected, n);
    } catch (IOException e) {
        e.printStackTrace();
        Assert.fail("Error");
    }
  }

  @Test
    public void assignBikesTest() {
      try (BufferedReader reader = new BufferedReader(new FileReader("/Users/yujin/Desktop/algorithm/Lab8/src/bikestest.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
          String[] tokens = line.split(":");

          int[][] students = parse2DArray(tokens[0]);
          int[][] bikes = parse2DArray(tokens[1]);
          int[] expected = parseArrayFromString(tokens[2]);

          int[] result = app.assignBikes(students, bikes);

          Assert.assertArrayEquals(expected, result);
        }
    } catch (IOException e) {
      e.printStackTrace();
      Assert.fail("Error reading test cases from file: " + e.getMessage());
    }
  }
}
