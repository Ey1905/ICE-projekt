import java.util.Scanner;
import java.util.InputMismatchException;

public class CreateMissingPerson{
   private User user;
    private Scanner scanner;

    public CreateMissingPerson(User user, Scanner scanner) {
        this.user = user;
        this.scanner = scanner;
    }

    // Metode til at oprette en efterlyst person
    public MissingPerson create() {

        // Input fra brugeren for missingPerson data
        System.out.println("Enter first name of the missing person: ");
        String firstName = scanner.nextLine();

        System.out.println("Enter last name of the missing person: ");
        String lastName = scanner.nextLine();

        int age = 0;
        while (age <= 0) {
            System.out.println("Enter age of the missing person: ");
            try {
                age = scanner.nextInt();
                if (age <= 0) {
                    System.out.println("Age must be a positive number.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }
        scanner.nextLine();

        System.out.println("Enter gender of the missing person male/female: ");
        String gender = scanner.nextLine();

        double height = 0;
        while (height <= 0) {
            System.out.println("Enter height of the missing person: ");
            try {
                height = scanner.nextDouble();
                if (height <= 0) {
                    System.out.println("Height must be a positive number.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }
        scanner.nextLine();

        System.out.println("Enter the last known location of the missing person: ");
        String lastSeenLocation = scanner.nextLine();

        System.out.println("Enter the date since the person want missing: ");
        String missingSince = scanner.nextLine();

        System.out.println("Enter any additional information: ");
        String additionalInformation = scanner.nextLine();

        // Opretter en ny efterlyst person objekt
        MissingPerson newPerson = new MissingPerson(firstName, lastName, age, height, gender, lastSeenLocation, missingSince, additionalInformation, "Missing");
        System.out.println("A new missing person has been created: " + newPerson);

        // Returnerer den oprettede efterlyst person
        return newPerson;
    }
}