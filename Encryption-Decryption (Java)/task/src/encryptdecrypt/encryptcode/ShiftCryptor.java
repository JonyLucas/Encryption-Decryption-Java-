package encryptdecrypt.encryptcode;

class ShiftCryptor implements CryptoAlgorithm{
    @Override
    public String encode(String message, int key) {
        String outputmessage = "";
        int messageSize = message.length();

        for(int i = 0; i < messageSize; i++){
            if(message.charAt(i) >= 'a' && message.charAt(i) <= 'z'){
                char c = (char) (message.charAt(i) + key);
                if(c > 'z'){
                    c = (char) ('a' + (c - 'z'));
                }
                outputmessage += c;
            }else{
                outputmessage += message.charAt(i);
            }
        }

        return  outputmessage;
    }

    @Override
    public String decode(String cyphertext, int key) {
        String outputmessage = "";
        int messageSize = cyphertext.length();

        for(int i = 0; i < messageSize; i++){
            if(cyphertext.charAt(i) >= 'a' && cyphertext.charAt(i) <= 'z'){
                char c = (char) (cyphertext.charAt(i) - key);
                if(c < 'a'){
                    c = (char) ('z' - ('a' - c));
                }
                outputmessage += c;
            }else{
                outputmessage += cyphertext.charAt(i);
            }
        }

        return  outputmessage;
    }
}
