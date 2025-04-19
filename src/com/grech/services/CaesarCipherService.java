package com.grech.services;

import com.grech.exceptions.InvalidBruteForceException;

import static com.grech.constants.Constants.ALPHABET;
import static com.grech.constants.Constants.VALID_TEXT_PATTERN;

public class CaesarCipherService {
    public String encrypt(String text, int key) {
        return shiftSymbol(text, normalizeKey(key));
    }

    public String decrypt(String text, int key) {
        return shiftSymbol(text, normalizeKey(-key));
    }

    public String bruteForce(String inputText) {
        return bruteForceDecrypt(inputText);
    }

    private String shiftSymbol(String text, int key) {
        char[] textArray = text.toCharArray();

        for (int i = 0; i < textArray.length; ++i) {
            int index = ALPHABET.indexOf(textArray[i]);
            if (index >= 0) {
                int shiftedIndex = (index + key) % ALPHABET.length();
                textArray[i] = ALPHABET.charAt(shiftedIndex);
            }
        }

        return new String(textArray);
    }

    private int normalizeKey(int key) {
        int alphabetLength = ALPHABET.length();
        return (key % alphabetLength + alphabetLength) % alphabetLength;
    }

    private String bruteForceDecrypt(String inputText) {
        for (int i = 1; i < ALPHABET.length(); i++) {
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
}
