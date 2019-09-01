package encryptdecrypt.encryptcode;

interface CryptoAlgorithm {
    String encode(String message, int key);
    String decode(String cyphertext, int key);
}
