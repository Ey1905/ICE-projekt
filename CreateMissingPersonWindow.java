import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

    public class CreateMissingPersonWindow extends JFrame {
        public CreateMissingPersonWindow(ArrayList<MissingPerson> missingPersons, User user) {
            setTitle("Create Missing Person");
            setSize(400, 300);
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setLocationRelativeTo(null);

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(5, 2));

            // Komponenter
            JLabel nameLabel = new JLabel("First Name:");
            JTextField nameField = new JTextField();
            JLabel lastNameLabel = new JLabel("Last Name:");
            JTextField lastNameField = new JTextField();
            JLabel ageLabel = new JLabel("Age:");
            JTextField ageField = new JTextField();
            JLabel genderLabel = new JLabel("Gender:");
            JTextField genderField = new JTextField();
            JLabel heightLabel = new JLabel("Height:");
            JTextField heightField = new JTextField();
            JLabel lastSeenLabel = new JLabel("Last Seen:");
            JTextField lastSeenField = new JTextField();
            JLabel missingSinceLabel = new JLabel("Missing Since:");
            JTextField missingSinceField = new JTextField();
            JLabel descriptionLabel = new JLabel("Description:");
            JTextField descriptionField = new JTextField();
            JButton createButton = new JButton("Create");

            // Tilføj komponenter til panel
            panel.add(nameLabel);
            panel.add(nameField);
            panel.add(lastNameLabel);
            panel.add(lastNameField);
            panel.add(ageLabel);
            panel.add(ageField);
            panel.add(genderLabel);
            panel.add(genderField);
            panel.add(genderField);
            panel.add(heightLabel);
            panel.add(heightField);
            panel.add(lastSeenLabel);
            panel.add(lastSeenField);
            panel.add(missingSinceLabel);
            panel.add(missingSinceField);
            panel.add(descriptionLabel);
            panel.add(descriptionField);
            panel.add(createButton);

            // Håndter knappen, der opretter en person
            createButton.addActionListener(new ActionListener() {
            @Override
        public void actionPerformed(ActionEvent e) {
            String name = nameField.getText();
            String ageText = ageField.getText();
            String description = descriptionField.getText();

            // Valider input
                if (name.isEmpty() || ageText.isEmpty() || description.isEmpty()) {
                    JOptionPane.showMessageDialog(CreateMissingPersonWindow.this, "Please fill all fields");
                    return;
                }

                try {
                    int age = Integer.parseInt(ageText);
                    MissingPerson newPerson = new MissingPerson(name, "", age, 0, "Unknown", "", "", description, "Missing");
                    missingPersons.add(newPerson);  // Tilføj til listen af efterlyste personer
                    JOptionPane.showMessageDialog(CreateMissingPersonWindow.this, "Missing person created successfully.");
                    dispose();  // Luk vinduet
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(CreateMissingPersonWindow.this, "Invalid age format.");
                }
            }
        });

        // Tilføj panel til vinduet
        add(panel);
        setVisible(true);
    }
}