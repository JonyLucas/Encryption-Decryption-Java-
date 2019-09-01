package encryptdecrypt.encryptcode;

public class Stage1Crypto {
    /***
     * --- Stage 1 ---
     * For the first stage, you need to manually encrypt the message "we found a treasure!" and print the ciphertext (in lower case).
     *
     * To encrypt the message, replace each letter with the letter that is in the corresponding position from the end of the English alphabet
     * (a→z, b→y, c→x, ... x→c, y →b, z→a). Do not replace spaces or the exclamation mark.
     *
     */
    static public String encodeString(String s){
        char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] invAlphabet = {'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r', 'q', 'p', 'o', 'n', 'm', 'l', 'k', 'j', 'i', 'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a'};

        String outputString = "";
        char[] charArray = s.toCharArray();

        boolean specialChar = false;

        for(int i = 0; i < charArray.length; i++){
            specialChar = true;
            for(int j = 0; j < alphabet.length; j++){
                if(alphabet[j] == charArray[i]){
                    outputString = outputString + invAlphabet[j];
                    specialChar = false;
                }
            }

            if(specialChar)
                outputString = outputString + charArray[i];
        }

        return outputString;

    }
}
