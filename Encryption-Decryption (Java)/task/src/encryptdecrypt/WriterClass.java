package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class WriterClass {

    String filePath = "";
    public WriterClass(String filePath){
        this.filePath = filePath;
    }

    public void write(String message){
        File file = new File(filePath);
        try(FileWriter writer = new FileWriter(file)){
            writer.write(message);
        }catch(FileNotFoundException fnf){
            System.out.println("File can't be written");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
