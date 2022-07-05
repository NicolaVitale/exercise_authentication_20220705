package utils;

import dataobject.User;
import enums.UserRole;
import exception.InsertException;
import java.util.Collection;
import java.util.Scanner;
import repository.Repository;
import services.UserService;

public class AuthenticationApp {

  private static final Repository userRepository = new Repository();


  public static void main(String[] args) {

    User user = new User("01",
        "Emanuele",
        "Vitale",
        "17/01/2015",
        "Ema17",
        "password",
        "05/07/2022", UserRole.ADMIN);

    System.out.println(user.toString());

    Scanner scanner = new Scanner(System.in);
    UserService userService = new UserService(userRepository);
    boolean stop = false;
    while (!stop) {
      try {
        insertUserFromScanner(scanner, userService);
        findAllUser();
      } catch (InsertException e) {
        System.out.println(e.getMessage());
      } finally {
        stop = stopMain(scanner);
      }
    }
  }

  private static void insertUserFromScanner(Scanner scanner, UserService userService)
      throws InsertException {

    System.out.print("\nInsert name: ");
    String name = scanner.nextLine();

    System.out.print("\nInsert surname: ");
    String surname = scanner.nextLine();

    System.out.print("\nInsert birthdate: ");
    String birthdate = scanner.nextLine();

    System.out.print("\nInsert username: ");
    String username = scanner.nextLine();

    System.out.print("\nInsert password: ");
    String password = scanner.nextLine();

    System.out.print("\nInsert date creation this user: ");
    String dateCreation = scanner.nextLine();

    System.out.print("\nInsert role, A for admin or S per standard user: ");
    UserRole role = UserRole.valueOf(scanner.nextLine());

    userService.insertUser(name, surname, birthdate, username, password, dateCreation, role);
  }

  private static void findAllUser() {
    Collection<User> allUser = userRepository.findAll();
    System.out.println(allUser.toString());
  }

  private static boolean stopMain(Scanner scanner) {
    System.out.print("\nDo you want to stop? (y/n) ");
    String choice = scanner.nextLine();
    return choice.equalsIgnoreCase("y");
  }
}
