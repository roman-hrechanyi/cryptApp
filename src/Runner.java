import java.nio.file.Path;

public class Runner {
    private final FileService fileService = new FileService();
    private final CaesarCipherService caesarCipherService = new CaesarCipherService();

    public void run(String[] args) {
        CommandType command = CommandType.valueOf(args[0]);
        Path path = Path.of(args[1]);
        int key = args.length == 3 ? Integer.parseInt(args[2]) : 0;
        String inputText = fileService.readFile(path);
        String outputText = switch (command) {
            case ENCRYPT -> caesarCipherService.encrypt(inputText, key);
            case DECRYPT -> caesarCipherService.decrypt(inputText, key);
            default -> throw new IllegalArgumentException();
        };
        Path outputPath = Path.of(path.toString().replace(".txt", "[" + command.toString() + "].txt"));
        fileService.writeFile(outputPath, outputText);
    }
}
