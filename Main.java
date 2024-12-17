import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.SwingUtilities;


    public class Main {
        public static void main(String[] args) {
            // Ny bruger oprettes
            User user = new User("E.Y", "cimbom1905", "Family", 21);
            Scanner scanner = new Scanner(System.in);

            // For at se om brugeren er logget ind
            boolean isLoggedIn = false;

            // En while løkke til at køre indtil det bliver korrekt
            while (!isLoggedIn) {
                System.out.print("Enter username: ");
                String inputUsername = scanner.nextLine();

                System.out.print("Enter password: ");
                String inputPassword = scanner.nextLine();

                // Hvis brugeren logger ind korrekt, sæt den til true
                if (user.login(inputUsername, inputPassword)) {
                    System.out.println("Login is successful");
                    isLoggedIn = true;
                } else {
                    System.out.println("Login failed. Try again");
                }
            }

            // Arrayliste til at gemme de efterlyste personer
            ArrayList<MissingPerson> missingPersons = new ArrayList<>();

            // Oprettede personer
            missingPersons.add(new MissingPerson("John", "Nielsen", 26, 1.80, "male", "København", "2024-12-01", "Wearing a red jacket", "Missing"));
            missingPersons.add(new MissingPerson("Jane", "Hansen", 25, 1.67, "Female", "Valby", "2024-11-20", "Wearing a blue dress", "Missing"));
            missingPersons.add(new MissingPerson("Mark", "Jensen", 42, 1.78, "Male", "Holbæk", "2024-10-15", "Wearing a black shirt", "Missing"));
            missingPersons.add(new MissingPerson("Lucy", "Pedersen", 36, 1.56, "Female", "Dybbølsbro", "2024-07-02", "Wearing white sneakers", "Missing"));
            missingPersons.add(new MissingPerson("Anna", "Henriksen", 23, 1.65, "Female", "Hvidovre", "2024-08-12", "Wearing a yellow jacket", "Missing"));
            missingPersons.add(new MissingPerson("Kim", "Jørgensen", 59, 1.82, "Male", "Roskilde", "2024-05-22", "Wearing a blue jacket", "Missing"));
            missingPersons.add(new MissingPerson("Tobias", "Frederiksen", 19, 1.79, "Male", "Vanløse", "2024-12-09", "Wearing a black hoodie", "Missing"));
            missingPersons.add(new MissingPerson("Jens", "Kimsen", 44, 1.77, "Male", "Hillerød", "2024-02-14", "Wearing blue pants ", "Missing"));
            missingPersons.add(new MissingPerson("Ole", "Rasmussen", 38, 1.79, "Male", "Lyngby", "2024-19-06", "Wearing a green hat", "Missing"));
            missingPersons.add(new MissingPerson("Sandra", "Andersen", 30, 1.71, "Female", "København", "2024-12-07", "Wearing a black jacket", "Missing"));

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new MainWindow(missingPersons, user);
                }
            });


            // Brugeren kan vælge hvad de vil foretage sig
            boolean options = true;
            while (options) {
                System.out.println(" What would you like to do? ");
                System.out.println("1. Create a missing person ");
                System.out.println("2. Search person ");
                System.out.println("3. Report missing person ");
                System.out.println("4. Exit");
                System.out.print(" Enter your choice: ");

                // Håndter valg fra brugeren
                int choice = 0;
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                } catch (Exception e) {
                    System.out.println("Invalid input. Try again");
                    scanner.nextLine();
                    continue;
                }

                // Udfør valgte handling fra brugeren
                switch (choice) {
                    case 1:
                        createMissingPerson(scanner, user, missingPersons); // Create new person
                        break;
                    case 2:
                        searchPerson(scanner, missingPersons); // Seacrh for missing person
                        break;
                    case 3:
                        reportSeenPerson(scanner, user, missingPersons);
                        break;
                    case 4:
                        System.out.println(" Exiting the program. ");
                        options = false; // Stop programmet
                        break;
                    default:
                        System.out.println("Invalid choice. Try again");
                }
            }
            scanner.close();
        }

        // Metode til at oprette en ny missing person
        public static void createMissingPerson(Scanner scanner, User user, ArrayList<MissingPerson> missingPersons) {
            CreateMissingPerson creator = new CreateMissingPerson(user, scanner); //opret createmissingperson instans, som håndterer oprettelsen
            MissingPerson newPerson = creator.create(); // Opret new missing person
            missingPersons.add(newPerson); // Tilføj personen til listen
        }

        // Metode til at søge efter en savnet person
        public static void searchPerson(Scanner scanner, ArrayList<MissingPerson> missingPersons) {

            // Brugeren vælger
            System.out.println("1. Search by Name ");
            System.out.println("2. Search by City ");
            System.out.println("3. Search by Date ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            String searchName = scanner.nextLine().toLowerCase().trim();
            boolean found = false;

            for (MissingPerson missingPerson : missingPersons) {

                String firstName = missingPerson.getFirstName().toLowerCase().trim();
                String lastName = missingPerson.getLastName().toLowerCase().trim();

                if (firstName.equalsIgnoreCase(searchName) || lastName.equalsIgnoreCase(searchName)) {
                    System.out.println(" Found " + missingPerson);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Person not found");
            }
        }

        // Metode til at rapportere en set efterlyst person
        public static void reportSeenPerson(Scanner scanner, User user, ArrayList<MissingPerson> missingPersons) {
            System.out.println("Enter the first name or last name of the missing person you saw:");
            String searchName = scanner.nextLine().toLowerCase().trim();

            // Find den efterlyste person
            MissingPerson seenPerson = null;
            for (MissingPerson missingPerson : missingPersons) {
                if (missingPerson.getFirstName().toLowerCase().trim().equals(searchName) ||
                        missingPerson.getLastName().toLowerCase().trim().equals(searchName)) {
                    seenPerson = missingPerson;
                    break;
                }
            }

            if (seenPerson != null) {
                System.out.println("Found missing person: " + seenPerson);

                // Indtaster oplysninger
                System.out.println("Enter the location where you saw the person:");
                String reportLocation = scanner.nextLine();

                System.out.println("Enter the date when you saw the person:");
                String reportDate = scanner.nextLine();

                System.out.println("Any additional information:");
                String additionalInfo = scanner.nextLine();

                // Opretter en ny rapport
                ReportMissingPerson report = new ReportMissingPerson(seenPerson, user, reportLocation, reportDate, additionalInfo);
                System.out.println("Report submitted successfully: ");
                System.out.println(report);
            } else {
                System.out.println("No missing person found with that name.");
            }
        }
    }