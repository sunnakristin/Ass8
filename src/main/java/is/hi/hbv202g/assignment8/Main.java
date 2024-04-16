package is.hi.hbv202g.assignment8;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Main class
 *
 */
public class Main {
    public static void main(String[] args) throws EmptyAuthorListException, UserOrBookDoesNotExistException {
        boolean adSkoda = true;
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        LibrarySystem.getInstance().addBookWithTitleAndNameOfSingleAuthor("litlar endur", "Sunna");
        LibrarySystem.getInstance().addBookWithTitleAndNameOfSingleAuthor("The road not taken", "Sævar");
        LibrarySystem.getInstance().addStudentUser("Sævar", true);
        LibrarySystem.getInstance().addStudentUser("Sunna", false);

        while (adSkoda) {
            System.out.println("What would you like to do?");
            System.out.println("1. Add book with title and author name");
            System.out.println("2. Add student user");
            System.out.println("3. Add faculty member user");
            System.out.println("4. Borrow book");
            System.err.println("5. Return book");
            System.out.println("6. Exit");
            String input = scanner.nextLine();
            if (input.equals("6")) {
                adSkoda = false;
            }
            if (input.equals("1")) {
                System.out.println("Enter title: ");
                String title = scanner.nextLine();
                System.out.println("Enter author name: ");
                String authorName = scanner.nextLine();
                LibrarySystem.getInstance().addBookWithTitleAndNameOfSingleAuthor(title, authorName);
            }
            if (input.equals("2")) {
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                LibrarySystem.getInstance().addStudentUser(name, false);
            }
            if (input.equals("3")) {
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                System.out.println("Enter department: ");
                String department = scanner.nextLine();
                LibrarySystem.getInstance().addFacultyMemberUser(name, department);
            }
            if (input.equals("4")) {
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                System.out.println("Enter title: ");
                String title = scanner.nextLine();
                LibrarySystem.getInstance().borrowBook(LibrarySystem.getInstance().findUserByName(name),
                        LibrarySystem.getInstance().findBookByTitle(title));
            }
            if (input.equals("5")) {
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                System.out.println("Enter title: ");
                String title = scanner.nextLine();
                LibrarySystem.getInstance().returnBook(LibrarySystem.getInstance().findUserByName(name),
                        LibrarySystem.getInstance().findBookByTitle(title));
            }

        }
        scanner.close();
    }
}
