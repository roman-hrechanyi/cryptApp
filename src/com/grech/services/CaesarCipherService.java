package com.grech.services;

import com.grech.constants.Constants;
import com.grech.exceptions.InvalidBruteForceException;

import static com.grech.constants.Constants.EN_ALPHABET;
import static com.grech.constants.Constants.UA_ALPHABET;
import static com.grech.constants.Constants.VALID_TEXT_PATTERN;

public class CaesarCipherService {
    public String encrypt(String text, int key) {
        return shiftSymbol(text, normalizeKey(key, detectAlphabet(text)));
    }

    public String decrypt(String text, int key) {
        return shiftSymbol(text, normalizeKey(-key, detectAlphabet(text)));
    }

    public String bruteForce(String inputText) {
        return bruteForceDecrypt(inputText);
    }

    private String shiftSymbol(String text, int key) {
        char[] textArray = text.toCharArray();
        String alphabet = detectAlphabet(text);
        for (int i = 0; i < textArray.length; ++i) {
            int index = alphabet.indexOf(textArray[i]);
            if (index >= 0) {
                int shiftedIndex = (index + key) % alphabet.length();
                textArray[i] = alphabet.charAt(shiftedIndex);
            }
        }

        return new String(textArray);
    }

    private int normalizeKey(int key, String alphabet) {
        int alphabetLength = alphabet.length();
        return (key % alphabetLength + alphabetLength) % alphabetLength;
    }

    private String bruteForceDecrypt(String inputText) {
        int alphabetLength = detectAlphabet(inputText).length();
        for (int i = 1; i < alphabetLength; i++) {
            String decryptedText = decrypt(inputText, i);
            if (isValidText(decryptedText)) {
                return decryptedText;
            }
        }
        throw new InvalidBruteForceException("Couldn't decrypt");
    }

    private boolean isValidText(String decryptedText) {
        return VALID_TEXT_PATTERN.matcher(decryptedText.toLowerCase()).find();
    }

    public static String detectAlphabet(String text) {
        return Constants.UKRAINIAN_LETTERS_PATTERN.matcher(text).find() ? UA_ALPHABET : EN_ALPHABET;
    }
}
