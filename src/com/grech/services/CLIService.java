package com.grech.services;

import com.grech.constants.CommandType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CLIService {
    public static String[] start() {
        Scanner scanner = new Scanner(System.in);
        List<String> args = new ArrayList<>();
        System.out.println("Welcome to Caesar Cipher CLI");
        System.out.print("Enter command (ENCRYPT/DECRYPT/BRUTE_FORCE): ");
        String command = scanner.nextLine();
        System.out.print("Enter file path: ");
        String filePath = scanner.nextLine();

        args.add(command);
        args.add(filePath);

        if (command.equals(CommandType.ENCRYPT.toString()) || command.equals(CommandType.DECRYPT.toString())) {
            System.out.print("Enter key: ");
            args.add(scanner.nextLine());
        }
        return args.toArray(new String[0]);
    }
}
