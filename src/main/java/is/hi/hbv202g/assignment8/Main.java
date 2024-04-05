package is.hi.hbv202g.assignment8;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Main {
    public static void main(String[] args) throws EmptyAuthorListException, UserOrBookDoesNotExistException {
        boolean adSkoda = true;
        LibrarySystem librarySystem = new LibrarySystem();
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        librarySystem.addBookWithTitleAndNameOfSingleAuthor("litlar endur", "Sunna");
        librarySystem.addBookWithTitleAndNameOfSingleAuthor("The road not taken", "Sævar");

        while(adSkoda){
            System.out.println("What would you like to do?");
            System.out.println("1. Add book with title and author name");
            System.out.println("2. Add student user");
            System.out.println("3. Add faculty member user");
            System.out.println("4. Borrow book");
            System.err.println("5. Return book");
            System.out.println("6. Hætta að skoða");
            String input = scanner.nextLine();
            if(input.equals("6")){
                adSkoda = false;
            }
            if(input.equals("1")){
                System.out.println("Enter title: ");
                String title = scanner.nextLine();
                System.out.println("Enter author name: ");
                String authorName = scanner.nextLine();
                librarySystem.addBookWithTitleAndNameOfSingleAuthor(title, authorName);
            }
            if(input.equals("2")){
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                librarySystem.addStudentUser(name, false);
            }
            if(input.equals("3")){
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                System.out.println("Enter department: ");
                String department = scanner.nextLine();
                librarySystem.addFacultyMemberUser(name, department);
            }
            if(input.equals("4")){
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                System.out.println("Enter title: ");
                String title = scanner.nextLine();
                librarySystem.borrowBook(librarySystem.findUserByName(name), librarySystem.findBookByTitle(title));
            }
            if(input.equals("5")){
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                System.out.println("Enter title: ");
                String title = scanner.nextLine();
                librarySystem.returnBook(librarySystem.findUserByName(name), librarySystem.findBookByTitle(title));
            }

        }
        
    }
}
