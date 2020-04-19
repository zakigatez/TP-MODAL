package Tp_Reflection;

import Tp_Exceptions.ExceptionGlobal;

import java.lang.reflect.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.PublicKey;
import java.util.Arrays;

@SuppressWarnings("rawtypes")
public class ReflectionGlobal {
    public String showProjectName(){
        String userDir = System.getProperty("user.dir");
        Path path = Paths.get(userDir);
        String project = String.valueOf(path.getFileName());
        return project;
    }
    public void showClass(Class c) {
        try {
            String classPackage = c.getName();
            System.out.println("Class Name is: " + classPackage);
        } catch (IllegalArgumentException e) {
            ExceptionGlobal saveException = new ExceptionGlobal(e);
        }
    }

    public void showClassNoPackage(Class c) {
        try {
            String classNoPackage = c.getSimpleName();
            System.out.println("Class Name without package is: " + classNoPackage);
        } catch (IllegalArgumentException e) {
            ExceptionGlobal saveException = new ExceptionGlobal(e);
        }

    }

    public void showPackage(Class c) {
        try {
            Package cPackage = c.getPackage();
            System.out.println("Package Name is: " + cPackage);
        } catch (IllegalArgumentException e) {
            ExceptionGlobal saveException = new ExceptionGlobal(e);
        }

    }

    public Method[] getAllMethods(Class c) {
        try {
            Method[] allmethods = c.getMethods();
            System.out.println("Methods are: " + Arrays.toString(allmethods));
            for (Method method : allmethods) {
                System.out.println("method = " + method.getName());
            }
            return allmethods;
        } catch (IllegalArgumentException e) {
            ExceptionGlobal saveException = new ExceptionGlobal(e);
        }
        return null;
    }

    public void showConstructors(Class c) {
        try {
            Constructor[] constructors = c.getConstructors();
            System.out.println("Constructors are: " + Arrays.toString(constructors));
        } catch (IllegalArgumentException e) {
            ExceptionGlobal saveException = new ExceptionGlobal(e);
        }

    }

    public void showSpecificConstructor(Class c, String type) {
        try {
            Constructor[] constructors = c.getConstructors();
            Constructor constructor = c.getConstructor(Integer.TYPE);
            System.out.println("Constructors are: " + Arrays.toString(constructors));
        } catch (IllegalArgumentException | NoSuchMethodException e) {
            ExceptionGlobal saveException = new ExceptionGlobal(e);
        }

    }

    public Method[] getAllDeclaredMethods(Class c) {
        try {
            Method[] declaredMethods = c.getDeclaredMethods();
            System.out.println("Declared Methods are: " + Arrays.toString(declaredMethods));
            for (Method method : declaredMethods) {
                System.out.println("method = " + method.getName());
            }
            return declaredMethods;

        } catch (IllegalArgumentException e) {
            ExceptionGlobal saveException = new ExceptionGlobal(e);
        }
        return null;
    }

    public Method getSpecificMethodsNameParamtere(Class c, String methodName, Type type) {
        try {
            Method oneMethod = c.getMethod(methodName, new Class[]{(Class) type});
            System.out.println("Method is: " + oneMethod);
            return oneMethod;

        } catch (IllegalArgumentException | NoSuchMethodException e) {
            ExceptionGlobal saveException = new ExceptionGlobal(e);
        }
        return null;
    }

    public Method getSpecificMethodsName(Class c, String methodName) {
        try {
            Method oneMethod = c.getMethod(methodName);
            System.out.println("Method is: " + oneMethod);
            return oneMethod;

        } catch (IllegalArgumentException | NoSuchMethodException e) {
            ExceptionGlobal saveException = new ExceptionGlobal(e);
        }
        return null;
    }

    public Class[] getParameterOfMethod(Class c, String methodName) {
        try {
            Method oneMethod = c.getMethod(methodName);
            Class[] parameterTypes = oneMethod.getParameterTypes();
            System.out.println("Parameter types of " + oneMethod.getName() + " are: "
                    + Arrays.toString(parameterTypes));
            return parameterTypes;
        } catch (IllegalArgumentException | NoSuchMethodException e) {
            ExceptionGlobal saveException = new ExceptionGlobal(e);
        }
        return null;
    }

    public Class getReturnTypeOfMethod(Class c, String methodName) {
        try {

            Method oneMethod = c.getMethod(methodName);
            Class returnType = oneMethod.getReturnType();
            System.out.println("Return type is: " + returnType);
            return returnType;

        } catch (IllegalArgumentException | NoSuchMethodException e) {
            ExceptionGlobal saveException = new ExceptionGlobal(e);
        }
        return null;
    }

    public Field[] getAllPublicFields(Class c, Object obj) {
        try {
            Field[] fields = c.getFields();

            System.out.println("Public Fields are: ");
            for (Field oneField : fields) {

                Field field = c.getField(oneField.getName());
                String fieldname = field.getName();
                System.out.println("Fieldname is: " + fieldname);

                Object fieldType = field.getType();
                System.out.println("Type of field " + fieldname + " is: "
                        + fieldType);
            }
        } catch (IllegalArgumentException | NoSuchFieldException e) {
            ExceptionGlobal saveException = new ExceptionGlobal(e);
        }
        return null;
    }


}
