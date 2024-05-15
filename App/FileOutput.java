import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutput {
    public static void outputFile(MarksSheet sheet, String path) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(sheet.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
