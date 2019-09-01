package encryptdecrypt.encryptcode;

class UnicodeCrypto implements CryptoAlgorithm {

    /***
     * --- Stage 3 ---
     *
     * In this stage, you need to support decryption in your program. The decryption is simply the inverse of encryption,
     * following the same steps but reversing the order in which the keys are applied.
     *
     * Then write a program that reads three lines from the standard input: a target operation (enc - encryption, dec - decryption),
     * a message or a cyphertext, and a key to encrypt/decrypt messages. All non-letter characters must be encrypted as well as regular letters.
     * We recommend you to get an integer representation of each character (according to the Unicode table) to shift it.
     *
     * Decompose your program using methods to make it easy to understand and edit later. One method should encrypt a message
     * and another one should decrypt it according to a key.
     */

    @Override
    public String encode(String message, int key){
        int size = message.length();
        char[] messageArray = message.toCharArray();
        String cyphertext = "";

        for(int i = 0; i < size; i++){
            cyphertext += (char) (messageArray[i] + key);
        }

        return  cyphertext;
    }

    @Override
    public String decode(String cyphertext, int key) {
        int size = cyphertext.length();
        char[] messageArray = cyphertext.toCharArray();
        String message = "";

        for (int i = 0; i < size; i++) {
            message += (char) (messageArray[i] - key);
        }

        return message;
    }

}
