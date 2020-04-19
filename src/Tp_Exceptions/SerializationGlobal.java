package Tp_Exceptions;

import java.io.*;
import java.util.ArrayList;

public class SerializationGlobal {

    public static boolean saveSerialized(String path, ArrayList objs){
        try {
            FileOutputStream fs = new FileOutputStream(path);
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(objs);
            os.close();
            fs.close();
        } catch (IOException e) {
            ExceptionGlobal saveException = new ExceptionGlobal(e);
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
            ExceptionGlobal saveException = new ExceptionGlobal(e1);
        }
        return null;
    }

}
