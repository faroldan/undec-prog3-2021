package exceptions;

public class VuelosException extends Exception {


    private static final long serialVersionUID = 1L;

    public VuelosException() {
        super("\nLos atributos no pueden ser nulos");
    }

    public VuelosException(String msg) {
        super("\n"+msg);
    }

}
