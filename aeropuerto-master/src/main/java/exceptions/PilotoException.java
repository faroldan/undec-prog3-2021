package exceptions;

public class PilotoException extends Throwable {
    public PilotoException() {
        super("\nLos atributos no pueden ser nulos");
    }

    public PilotoException(String msg) {
        super("\n"+msg);
    }
}
