import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileService {
    public String readFile(Path path) throws IOException {
        return Files.readString(path);
    }

    public void writeFile(Path path, String text) throws IOException {
        Files.writeString(path, text);
    }
}
