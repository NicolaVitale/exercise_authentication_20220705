package dataobject;

import enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {

  private final String id;
  private final String name;
  private final String surname;
  private final String birthDate;
  private final String username;
  private final String password;
  private final String dateCreation;
  private final UserRole role;


  public String toString() {
    return '{' + "\t"
        + name + " - " + surname + "\t"
        + '}';
  }

}
