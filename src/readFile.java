import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Class readFile - Reads a file full of text onto a stringBuilder
 * 
 * @author https://mkyong.com/java/how-to-read-file-from-java-bufferedreader-example/
 */
public class readFile {

    public static String readFiles(String path) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");

            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sb.toString();
    }

    public static int parseInt(String number) {
        try {
            return Integer.parseInt(number);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
