package exceptions;

public class AeropuertoException extends Throwable {
    public AeropuertoException() {
        super("\nLos atributos no pueden ser nulos");
    }

    public AeropuertoException(String msg) {
        super("\n"+msg);
    }
    }

