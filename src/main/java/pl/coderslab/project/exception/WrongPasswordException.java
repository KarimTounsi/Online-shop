package pl.coderslab.project.exception;

import pl.coderslab.project.user.entity.User;

public class WrongPasswordException extends Exception {

    private static final String DEFAULT_MESSAGE = "Podane hasło jest nie prawidłowe";

    public WrongPasswordException() {
        super(DEFAULT_MESSAGE);
    }

    public WrongPasswordException(User user) {
        super(String.format("%s podaj ponownie prawidłowe dotychczasowe hasło. ", user.getUsername()));
    }

}
