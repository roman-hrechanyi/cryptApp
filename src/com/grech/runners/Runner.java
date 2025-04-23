package com.grech.runners;

import com.grech.constants.CommandType;
import com.grech.exceptions.InvalidArgsCountException;
import com.grech.exceptions.InvalidCommandTypeException;
import com.grech.exceptions.InvalidFilePathException;
import com.grech.services.CaesarCipherService;
import com.grech.services.FileService;
import com.grech.utils.ArgsValidator;

import java.nio.file.Path;

import static com.grech.constants.Constants.COMMAND_TYPE_ARG_POSITION;
import static com.grech.constants.Constants.DEFAULT_KEY;
import static com.grech.constants.Constants.FILE_ARG_POSITION;
import static com.grech.constants.Constants.KEY_ARG_POSITION;
import static com.grech.constants.Constants.MAX_ALLOWED_ARGS_COUNT;

public class Runner {
    private final FileService fileService = new FileService();
    private final CaesarCipherService caesarCipherService = new CaesarCipherService();

    public void run(String[] args) {
        if (!ArgsValidator.isValidArgsCount(args)) {
            throw new InvalidArgsCountException("Incorrect number of args");
        }

        if (!ArgsValidator.isValidCommandType(args[COMMAND_TYPE_ARG_POSITION])) {
            throw new InvalidCommandTypeException("Incorrect command!");
        }
        if (!ArgsValidator.isValidFilePath(args[FILE_ARG_POSITION])) {
            throw new InvalidFilePathException("Incorrect filepath");
        }

        CommandType command = CommandType.valueOf(args[COMMAND_TYPE_ARG_POSITION]);

        Path path = Path.of(args[FILE_ARG_POSITION]);

        int key = DEFAULT_KEY;
        if (args.length == MAX_ALLOWED_ARGS_COUNT) {
            key = Integer.parseInt(args[KEY_ARG_POSITION]);
        }

        String inputText = fileService.readFile(path);

        String outputText = switch (command) {
            case CommandType.ENCRYPT -> caesarCipherService.encrypt(inputText, key);
            case CommandType.DECRYPT -> caesarCipherService.decrypt(inputText, key);
            case CommandType.BRUTE_FORCE -> caesarCipherService.bruteForce(inputText);
        };

        Path outputPath = Path.of(path.toString().replace(".txt", "[" + command.toString() + "].txt"));

        fileService.writeFile(outputPath, outputText);
    }
}
