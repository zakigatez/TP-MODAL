package Tp_Exceptions;

import java.io.File;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static Tp_Exceptions.SerializationExample.*;

public class ExerciceTp {
    public static void main(String[] args) throws InterruptedException {
        File studentFile = new File("students.txt");
        ArrayList<Etudiant> students = new ArrayList<Etudiant>();

         String nom;
         String prenom;
         String matricule;
         Niveau niveau;
         Specialite specialite;


        Etudiant student = new Etudiant("Amine", "Taibi" ,"21548", Niveau.M1, Specialite.IL);
        students.add(student);
        student = new Etudiant("Karima", "haddadi" ,"25481", Niveau.M1, Specialite.RSD);
        students.add(student);
        boolean b = saveSerialized(studentFile.getPath(), students);

        int choice;
        Scanner keyboard;
        System.out.println("Welcome To : \n  -------- Exercice sur la gestion des exceptions / fichier texte / Sérialisation. -------- \n\n");
        while(true)
        {
            System.out.println("Click 1 : To Add a Student ");
            System.out.println("Click 2 : To Delete a Student ");
            System.out.println("Click 3 : To List Students");
            System.out.println("Click 4 : To Search For a Student ");
            System.out.println("Click 5 : To Delete All Student ");
            System.out.println("Click 0 : To Exit ");
            keyboard = new Scanner(System.in);
            choice = keyboard.nextInt();

            switch(choice) {
                case 1:
                    System.out.println("\n---- Add a Student :");

                    System.out.println("Enter Nom : ");
                    keyboard = new Scanner(System.in);
                    nom = keyboard.next();

                    System.out.println("Enter Prenom : ");
                    keyboard = new Scanner(System.in);
                    prenom = keyboard.next();

                    System.out.println("Enter Matricule : ");
                    keyboard = new Scanner(System.in);
                    matricule = keyboard.next();

                    System.out.println("Enter Niveau : ");
                    keyboard = new Scanner(System.in);
                    niveau = Niveau.valueOf(Niveau.class, keyboard.next().toUpperCase());

                    System.out.println("Enter Specialite : ");
                    keyboard = new Scanner(System.in);
                    specialite = Specialite.valueOf(Specialite.class, keyboard.next().toUpperCase());

                    student = new Etudiant(nom, prenom ,matricule, niveau, specialite);
                    students.add(student);
                    b = saveSerialized(studentFile.getPath(), students);
                    break;


                case 2:
                    System.out.println("\n---- Delete a Student :");
                    students = (ArrayList<Etudiant>) readSerialized(studentFile.getPath());
                    System.out.println("Enter matricule of thee student : ");
                        keyboard = new Scanner(System.in);
                        matricule = keyboard.next();

                    String finalMatricule = matricule;
                    Etudiant deletedE = students.stream()
                        .filter(e -> e.getMatricule().equals(finalMatricule))
                        .findFirst().get();

                    students.remove(students.indexOf(deletedE));

                    b = saveSerialized(studentFile.getPath(), students);saveSerialized(studentFile.getPath(), students);

                    break;


                case 3:
                    System.out.println("\n---- List of Students :");

                    students = (ArrayList<Etudiant>) readSerialized(studentFile.getPath());
                    for (Etudiant s:students) {
                        System.out.println(s.toString());
                    }
                    break;


                case 4:
                    System.out.println("\n---- Search a Student :");
                    students = (ArrayList<Etudiant>) readSerialized(studentFile.getPath());
                    System.out.println("Enter matricule of thee student : ");
                    keyboard = new Scanner(System.in);
                    matricule = keyboard.next();
                    finalMatricule = matricule;
                    Etudiant searchedStudent = students.stream()
                            .filter(e -> e.getMatricule().equals(finalMatricule))
                            .findFirst().get();
                    System.out.println(searchedStudent.toString());


                    break;


                case 5:
                    System.out.println("\n---- Delete All Students :");
                    studentFile.delete();

                    System.out.println("Deleting");
                    // Delay
                    TimeUnit.SECONDS.sleep(1);
                    System.out.print(".");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.print(".");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(".");

                    System.out.println("All Students Are Deleted successfully");
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter A valid choice please");
            }

        }


    }
}
