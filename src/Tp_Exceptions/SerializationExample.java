package Tp_Exceptions;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SerializationExample {

    public static boolean saveSerialized(String path, ArrayList objs){
        try {
            FileOutputStream fs = new FileOutputStream(path);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(objs);
            os.close();
            fs.close();
        } catch (IOException e) {
            ExceptionExample saveException = new ExceptionExample(e);
            return false;
        }
        return true;
    }

    public static Object readSerialized(String path){
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);

                Object readed_obj = ois.readObject();
                ois.close();
                fis.close();
                return readed_obj;
        } catch (EOFException e){
            System.out.println("Fin du fichier");
        } catch (IOException | ClassNotFoundException e1) {
            ExceptionExample saveException = new ExceptionExample(e1);
        }
        return null;
    }

}
