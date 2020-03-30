package model.exceptions;

public class MinusPriceException extends Exception {

    public MinusPriceException() {

    }

    public MinusPriceException(String msg) {
        super(msg);
    }
}
