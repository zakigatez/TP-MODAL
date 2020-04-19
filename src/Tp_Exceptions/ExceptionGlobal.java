package Tp_Exceptions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class ExceptionGlobal {
    public String eMessage;
    public Date eDate;
    public Integer eLine;
    public String ePackage;
    public String eClass;
    public String eStr;
    public static Integer eNumber = 0;

    public ExceptionGlobal(Exception e){

        this.eMessage = e.toString();
        this.eDate = new Date();
        this.eLine = e.getStackTrace()[0].getLineNumber();
        this.ePackage = e.getStackTrace()[0].getClass().getPackageName();
        this.eClass = e.getStackTrace()[0].getClassName();
        eStr = eNumber + " " + eMessage + " " + eDate + " " + ePackage + " " + eClass + " " + eLine;
        saveFileText();
        eNumber++;
    }
    private void saveFileText(){
        File f = new File("log.txt");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f,true));
            bw.newLine();
            bw.write(eStr);
            bw.close();
        } catch (IOException e1) {
            System.out.println("e1:" + e1.toString());
            System.out.println("e:" + eMessage);
            System.out.println("--------------------------------------------");
            if(e1.getStackTrace()[0].getClassName() != eClass) {
                System.out.println("its working");

                ExceptionGlobal saveException = new ExceptionGlobal(e1);
            }
            else{
                System.exit(0);
            }
        }
    }

}
