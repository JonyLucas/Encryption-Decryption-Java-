package encryptdecrypt.encryptcode;

public class ShiftAlphabetCrypto implements CryptoAlgorithm {

    @Override
    public String decode(String cyphertext, int key) {
        return null;
    }

    /**
     * --- Stage 2 ---
     * Write a program that reads an English message and an integer number (key) from the standard input and shifts each letter
     * by the specified number according to its order in the alphabet. If you reach the end of the alphabet, start back at the beginning (a follows z).
     */

    @Override
    public String encode(String text, int key){
        String outputText = "";
        int textSize = text.length();

        for(int i = 0; i < textSize; i++){
            if(text.charAt(i) >= 'a' && text.charAt(i) <= 'z'){
                char c = (char) (text.charAt(i) + key);
                if(c > 'z'){
                    c = (char) ('a' + (c - 'z') - 1);
                }
                outputText += c;
            }else{
                outputText += text.charAt(i);
            }
        }

        return  outputText;
    }
}
