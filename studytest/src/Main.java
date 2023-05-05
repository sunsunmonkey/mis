import jdk.jfr.StackTrace;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File a = new File("studytest\\src\\hello.txt");
        System.out.println(a.getAbsolutePath());
        FileReader fr =new FileReader(a);
        int data =  fr.read();
        while (data != -1){
           System.out.println((char)data);
           data =  fr.read();
       }
           fr.close();
    }

}

