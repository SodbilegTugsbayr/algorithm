import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
  public static void main(String[] args){
    try (BufferedReader reader = new BufferedReader(new FileReader("src/sortTestCase.txt"))) {
      String line = reader.readLine();
      System.out.println("Unshsan mur: " + line);
  
    } catch (IOException e) {
        e.printStackTrace();
    }
  }
}
