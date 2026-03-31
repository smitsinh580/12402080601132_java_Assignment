// Abstract class
abstract class Cipher {
    String text;

    // Constructor
    Cipher(String text) {
        this.text = text;
    }

    // Abstract methods
    abstract String encrypt();
    abstract String decrypt();
}

// Derived class (Caesar Cipher)
class CaesarCipher extends Cipher {
    int shift;

    CaesarCipher(String text, int shift) {
        super(text);
        this.shift = shift;
    }

    // Encrypt method (override)
    @Override
    String encrypt() {
        String result = "";
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                ch = (char) ((ch - base + shift) % 26 + base);
            }
            result += ch;
        }
        return result;
    }

    // Decrypt method (override)
    @Override
    String decrypt() {
        String result = "";
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                ch = (char) ((ch - base - shift + 26) % 26 + base);
            }
            result += ch;
        }
        return result;
    }
}

// Main class
public class Program6 {
    public static void main(String[] args) {

        String message = "HelloWorld";
        int shift = 3;

        CaesarCipher obj = new CaesarCipher(message, shift);

        String encrypted = obj.encrypt();
        System.out.println("Original Text: " + message);
        System.out.println("Encrypted Text: " + encrypted);

        // Decrypt using new object
        CaesarCipher obj2 = new CaesarCipher(encrypted, shift);
        String decrypted = obj2.decrypt();
        System.out.println("Decrypted Text: " + decrypted);
    }
}
