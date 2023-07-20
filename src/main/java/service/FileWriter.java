package service;

import model.User;

import java.io.IOException;

public interface FileWriter {
    void writeUserData(User user) throws IOException;

}
