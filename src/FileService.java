import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileService {
    public String readFile(Path path){
        try {
            return (Files.exists(path)) ? Files.readString(path) : "";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeFile(Path path, String text){
        try {
            Files.writeString(path, text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
