package pl.coderslab.project.exception;

public class WrongSecondPasswordException extends Exception {

    private static final String DEFAULT_MESSAGE = "Hasła się nie zgadzają, Wpisz ponownie takie same hasła";

    public WrongSecondPasswordException() {
        super(DEFAULT_MESSAGE);
    }


}
