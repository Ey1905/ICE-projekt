import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SearchMissingPersonWindow extends JFrame {

    public SearchMissingPersonWindow(ArrayList<MissingPerson> missingPersons) {
        setTitle("Search Missing Person");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,3));  // 2 rows, 2 columns

        // Komponenter
        JLabel searchLabel = new JLabel(" Name of missing person:");
        JTextField searchField = new JTextField();
        JButton searchButton = new JButton("Search");
        JTextArea resultArea = new JTextArea(5, 20);  // Vis resultater i et tekstområde
        resultArea.setEditable(false);

        // Tilføj komponenter til panel
        panel.add(searchLabel);
        panel.add(searchField);
        panel.add(searchButton);
        panel.add(new JScrollPane(resultArea));

        // Håndter klik på knappen for at søge
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchName = searchField.getText().toLowerCase().trim();
                boolean found = false;
                resultArea.setText("");  // Ryd resultatfeltet før søgning

                for (MissingPerson person : missingPersons) {
                    String fullName = (person.getFirstName() + " " + person.getLastName()).toLowerCase();
                    if (fullName.contains(searchName)) {
                        resultArea.append(person.toString() + "\n");
                        found = true;
                    }
                }

                if (!found) {
                    resultArea.append("Person not found.");
                }
            }
        });

        // Tilføj panel til vinduet
        add(panel);
        setVisible(true);
    }
}
