import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws Exception {
        String filePath = "sample.txt";
        Path path = Paths.get(filePath);
        Path directory = path.getParent();
        MarksSheet sheet = GradesParser.parse(filePath);
        FileOutput.outputFile(sheet, "output.txt");
    }
}
