import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class readFile { // https://mkyong.com/java/how-to-read-file-from-java-bufferedreader-example/

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

    public static int parseInt(String number) { // stackOverflow
        try {
            return Integer.parseInt(number);

        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }
}