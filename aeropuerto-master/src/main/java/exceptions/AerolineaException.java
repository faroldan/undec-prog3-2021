package exceptions;

public class AerolineaException extends Throwable {
    public AerolineaException() {
        super("\nSe detectó una excepción no tratada");
    }

    public AerolineaException(String msg) {
        super("\n"+msg);
    }

}
