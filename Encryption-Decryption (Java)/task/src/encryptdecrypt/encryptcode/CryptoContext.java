package encryptdecrypt.encryptcode;

/***
 * Implements the strategy pattern
 */
public class CryptoContext {

    CryptoAlgorithm algorithm;

    public void setAlgorithm(String type){
        if(type.equals("unicode")){
            this.algorithm = new UnicodeCrypto();
        }else if(type.equals("shift")){
            this.algorithm = new ShiftCryptor();
        }
    }

    public String invoke(String operation, String message, int key) {
        if (algorithm != null) {
            if (operation.equals("enc"))
                return algorithm.encode(message, key);
            else if (operation.equals("dec"))
                return algorithm.decode(message, key);
            else
                return null;
        } else {
            return null;
        }
    }

}
