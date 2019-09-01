package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReaderClass {

    private boolean fileInput;
    private String filepath;

    public ReaderClass(){
        fileInput = false;
    }

    public ReaderClass(String filepath){
        fileInput = true;
        this.filepath = filepath;
    }

    public String read(){
        if(fileInput){
            return  readFile();
        }else{
            return readStandard();
        }
    }

    private String readFile(){
        File file = new File(filepath);
        try(Scanner scanner = new Scanner(file)){
            String message = "";
            while (scanner.hasNext()){
                message += scanner.nextLine();
            }
            return message;

        }catch (FileNotFoundException fnf){
            System.out.println("File not found");
            return "";
        }
    }

    private String readStandard(){
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();
        scanner.close();
        return message;
    }

}
