public class CaesarCipherService {
    public static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz.,«»\"':!? ";

    public String encrypt(String text, int key) {
        return shiftSymbol(text, normalizeKey(key));
    }

    public String decrypt(String text, int key) {
        return shiftSymbol(text, normalizeKey(-key));
    }

    private String shiftSymbol(String text, int key) {
        char[] textArray = text.toCharArray();

        for(int i = 0; i < textArray.length; ++i) {
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
}
