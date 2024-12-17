import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ReportMissingPersonWindow extends JFrame {

    private ArrayList<ReportMissingPerson> reports;  // Liste over rapporter

    public ReportMissingPersonWindow(ArrayList<MissingPerson> missingPersons, User user) {
        setTitle("Report Missing Person");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel og layout
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        // Labels og inputfelter
        JLabel nameLabel = new JLabel("Missing Person Name:");
        JTextField nameField = new JTextField();
        JLabel lastNameLabel = new JLabel("Missing Person Last Name:");
        JTextField lastNameField = new JTextField();
        JLabel locationLabel = new JLabel("Location Seen:");
        JTextField locationField = new JTextField();
        JLabel dateLabel = new JLabel("Date Seen:");
        JTextField dateField = new JTextField();
        JLabel infoLabel = new JLabel("Additional Info:");
        JTextArea infoField = new JTextArea(3, 20);
        JScrollPane scrollPane = new JScrollPane(infoField);

        JButton reportButton = new JButton("Submit Report");

        // Tilføj komponenter til panelet
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(lastNameLabel);
        panel.add(lastNameField);
        panel.add(locationLabel);
        panel.add(locationField);
        panel.add(dateLabel);
        panel.add(dateField);
        panel.add(infoLabel);
        panel.add(scrollPane);
        panel.add(reportButton);

        // ActionListener for rapportering
        reportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String lastName = lastNameField.getText();
                String location = locationField.getText();
                String date = dateField.getText();
                String additionalInfo = infoField.getText();

                // Validering af input
                if (name.isEmpty() || lastName.isEmpty() || location.isEmpty() || date.isEmpty()) {
                    JOptionPane.showMessageDialog(ReportMissingPersonWindow.this, "Please fill all required fields.");
                    return;
                }

                // Find den missing person fra listen baseret på navn og efternavn
                MissingPerson foundPerson = null;
                for (MissingPerson person : missingPersons) {
                    if (person.getFirstName().equalsIgnoreCase(name) && person.getLastName().equalsIgnoreCase(lastName)) {
                        foundPerson = person;
                        break;
                    }
                }

                if (foundPerson == null) {
                    JOptionPane.showMessageDialog(ReportMissingPersonWindow.this, "Person not found in the list.");
                    return;
                }

                // Opret rapporten
                ReportMissingPerson report = new ReportMissingPerson(foundPerson, user, location, date, additionalInfo);

                // Tilføj rapporten til listen (kan være en ArrayList)
                if (reports == null) {
                    reports = new ArrayList<>();
                }
                reports.add(report);

                // Bekræftelse
                JOptionPane.showMessageDialog(ReportMissingPersonWindow.this, "Report submitted successfully.");

                // Luk vinduet
                dispose();
            }
        });

        // Tilføj panel til vinduet
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Opret en bruger og missing persons liste som eksempel
        User user = new User("JohnDoe", "password123", "Family", 30);
        ArrayList<MissingPerson> missingPersons = new ArrayList<>();
        missingPersons.add(new MissingPerson("Jane", "Frederiksen", 25, 1.65, "Female", "Copenhagen", "2024-12-01", "Wearing a blue jacket", "Missing"));

        // Opret rapporteringsvindue
        new ReportMissingPersonWindow(missingPersons, user);
    }
}
