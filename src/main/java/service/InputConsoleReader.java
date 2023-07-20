package service;

import exceptions.UserDataException;
import model.User;

public interface InputConsoleReader {

    User readUserData() throws UserDataException;
}
