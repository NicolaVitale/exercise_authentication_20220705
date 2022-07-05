package repository;

import dataobject.User;
import enums.UserRole;
import exception.InsertException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.RandomStringUtils;

public class Repository implements IRepository<User> {

  private Map<String, User> databaseUser;
  private static final int ID_LENGTH = 10;

  public Repository() {
    databaseUser = new HashMap<>();
  }

  /*public void userDefault() {
    User user = new User(generateRandomId(),
        "Emanuele",
        "Vitale",
        "17/01/2015",
        "Ema17",
        "password",
        "05/07/2022", UserRole.ADMIN);
  }*/

  public String generateRandomId() {
    String randomString = RandomStringUtils.randomAlphanumeric(ID_LENGTH);
    while (databaseUser.containsKey(randomString)) {
      randomString = RandomStringUtils.randomAlphanumeric(ID_LENGTH);
    }
    return randomString;
  }

  public void insertUser(User user, String id) throws InsertException {
    if (!databaseUser.containsKey(id)) {
      databaseUser.put(id, user);
    } else {
      throw new InsertException("%s with already exists", user.getId());
    }
  }

  public Collection<User> findAll() {
    return databaseUser.values();
  }

}
