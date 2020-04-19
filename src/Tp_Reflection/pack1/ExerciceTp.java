package Tp_Reflection.pack1;

import Tp_Reflection.ReflectionGlobal;

import java.awt.*;
import java.util.Date;
import java.lang.reflect.*;

public class ExerciceTp {
    public static void main(String[] args) {
        ReflectionGlobal r = new ReflectionGlobal();
        System.out.println("Description textuelle -- Date : "+ new Date());
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Information projet\n" +
                "----------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Nom du projet :" + r.showProjectName());

        System.out.println("Java Version : " + System.getProperty("java.version"));
        System.out.println("OS : " + System.getProperty("os.name"));

        
    }
}
