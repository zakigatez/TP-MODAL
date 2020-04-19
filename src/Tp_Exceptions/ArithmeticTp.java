package Tp_Exceptions;

public class ArithmeticTp {
    public static void main(String[] args) {
        Integer i,n,k;
        Float r;
        n = 10; k = 4;
        for (i=0; i<n ;i++) {
            try {
                r = Float.valueOf(1 / (k - i));
            } catch (ArithmeticException e) {
                ExceptionExample saveException = new ExceptionExample(e);
            } catch (Exception e) {
                ExceptionExample saveException = new ExceptionExample(e);
            }
        }
    }
}
