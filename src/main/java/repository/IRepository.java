package repository;

import dataobject.User;
import exception.InsertException;
import java.util.Collection;

public interface IRepository<T> {

  String generateRandomId();
  //void userDefault();
  void insertUser(User user, String id) throws InsertException;
  public Collection<User> findAll();

}
