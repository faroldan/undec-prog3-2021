package exceptions;

public class AvionException extends Exception {

    private static final long serialVersionUID = 1L;

    public AvionException() {
        super("\nLos atributos no pueden ser nulos");
    }

    public AvionException(String msg) {
        super("\n"+msg);
    }
}
