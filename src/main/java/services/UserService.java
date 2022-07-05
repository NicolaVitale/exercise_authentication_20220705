package services;

import dataobject.User;
import enums.UserRole;
import exception.InsertException;
import repository.Repository;

public class UserService {

  private final Repository userRepository;

  public UserService(Repository userRepository) {
    this.userRepository = userRepository;
  }

  public void insertUser(String name, String surname, String birthdate,
      String username, String password, String dataCreation, UserRole role)
      throws InsertException {
    User user = new User(userRepository.generateRandomId(),
        name,
        surname,
        birthdate,
        username,
        password,
        dataCreation,
        role);

    userRepository.insertUser(user, user.getId());
  }

}
