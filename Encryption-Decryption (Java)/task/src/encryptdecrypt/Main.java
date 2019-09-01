package encryptdecrypt;

import encryptdecrypt.encryptcode.CryptoContext;

import java.util.List;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // Arguments
        List<String> argList = Arrays.asList(args);

        int index = argList.indexOf("-alg");
        String algorithm = index >= 0 ? args[index+1] : null;

        index = argList.indexOf("-mode");
        String mode = index >= 0 ? args[index+1] : null;

        // Get the Key
        int key = 0;
        try{
            int keyIndex = argList.indexOf("-key");
            key = Integer.parseInt(args[keyIndex+1]);
        }catch (NumberFormatException nfe){
            key = 0;
        }

        // Input argList (message/cyphertext)
        String message = "";
        if(argList.indexOf("-data") >= 0){
            int dataIndex = argList.indexOf("-data");
            message = args[dataIndex+1];
        }else if(argList.indexOf("-in") >= 0){
            int fileIndex = argList.indexOf("-in");
            ReaderClass reader = new ReaderClass(args[fileIndex+1]);
            message = reader.read();
        }else{
            ReaderClass reader = new ReaderClass();
            message = reader.read();
        }

        // Encrypt/Decrypt message
        CryptoContext context = new CryptoContext();
        context.setAlgorithm(algorithm);
        String result = context.invoke(mode, message, key);

        // Output File
        int outputIndex = argList.indexOf("-out");
        if(outputIndex >= 0){
            WriterClass writer = new WriterClass(args[outputIndex+1]);
            writer.write(result);
        }else{
            System.out.println(result);
        }

    }

}
