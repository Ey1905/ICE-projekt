import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

    public class LoginWindow extends JFrame {
        private User user;

    public LoginWindow(User user) {
        // Sæt brugeren
        this.user = user;

        // Opsætning af login vinduet
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel og layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        JLabel errorLabel = new JLabel("");

        // Tilføj komponenter til panelet
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(errorLabel);

        // Håndterer login-knappen
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputUsername = usernameField.getText();
                String inputPassword = new String(passwordField.getPassword());

                if (user.login(inputUsername, inputPassword)) {
                    //  MissingPersons liste
                    ArrayList<MissingPerson> missingPerson = new ArrayList<>();
                    missingPerson.add(new MissingPerson("John" , "Nielsen" , 26 , 1.80 , "male" , "København" , "2024-12-01" , "Wearing a red jacket" , "Missing"));
                    missingPerson.add(new MissingPerson("Jane", "Hansen", 25, 1.67, "Female", "Valby", "2024-11-20", "Wearing a blue dress", "Missing"));
                    missingPerson.add(new MissingPerson("Mark", "Jensen", 42, 1.78, "Male", "Holbæk", "2024-10-15", "Wearing a black shirt", "Missing"));
                    missingPerson.add(new MissingPerson("Lucy", "Pedersen", 36, 1.56, "Female", "Dybbølsbro", "2024-07-02", "Wearing white sneakers", "Missing"));
                    missingPerson.add(new MissingPerson("Anna", "Henriksen", 23, 1.65, "Female", "Hvidovre", "2024-08-12", "Wearing a yellow jacket", "Missing"));
                    missingPerson.add(new MissingPerson("Kim", "Jørgensen", 59, 1.82, "Male", "Roskilde", "2024-05-22", "Wearing a blue jacket", "Missing"));
                    missingPerson.add(new MissingPerson("Tobias", "Frederiksen", 19, 1.79, "Male", "Vanløse", "2024-12-09", "Wearing a black hoodie", "Missing"));
                    missingPerson.add(new MissingPerson("Jens", "Kimsen", 44, 1.77, "Male", "Hillerød", "2024-02-14", "Wearing blue pants ", "Missing"));
                    missingPerson.add(new MissingPerson("Ole", "Rasmussen", 38, 1.79, "Male", "Lyngby", "2024-19-06", "Wearing a green hat", "Missing"));
                    missingPerson.add(new MissingPerson("Sandra", "Andersen", 30, 1.71, "Female", "København", "2024-12-07", "Wearing a black jacket", "Missing"));


                    // Opret MainWindow og send missingPersons og user som argumenter
                    new MainWindow(missingPerson, user);

                    dispose();  // Luk login-vinduet
                } else {
                    errorLabel.setText("Login failed. Try again.");
                }
            }
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Brugeren skal initialiseres her
        User user = new User("E.Y", "cimbom1905", "Family", 21);

        new LoginWindow(user);
    }
}