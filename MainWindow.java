import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.border.BevelBorder;


       public class MainWindow extends JFrame {
           private ArrayList<MissingPerson> missingPerson;
           private User user;

       public MainWindow(ArrayList<MissingPerson> missingPerson, User user) {
           this.missingPerson = missingPerson;
           this.user = user;

        // Opsætning af vinduet
           setTitle("Missing Person Tracker! ");
           setSize(500, 400);
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           setLocationRelativeTo(null); // Centrerer vinduet på skærmen
           setLayout(new BorderLayout());

        // Velkomst
           JLabel welcomeLabel = new JLabel("Welcome to Missing Person Tracker! ");
           welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
           add(welcomeLabel, BorderLayout.NORTH); // Toppen af vinduet

        // Knapper til at report eller søge for missing person
           JPanel buttonPanel = new JPanel();
           buttonPanel.setLayout(new FlowLayout());

           JButton reportButton = new JButton("Report Missing Person");
           JButton searchButton = new JButton("Search Missing Person");
           JButton createButton = new JButton("Create Missing Person");

        // Report knap, action
           reportButton.addActionListener(new ActionListener() {
             @Override
       public void actionPerformed(ActionEvent e) {
           new ReportMissingPersonWindow(missingPerson, user);
            }
        });

        // Search button action
           searchButton.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
           new SearchMissingPersonWindow(missingPerson);
            }
        });

        // Create button action
           createButton.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
           new CreateMissingPersonWindow(missingPerson, user);  // Open create missing person window
            }
        });

        // Add buttons to panel
           buttonPanel.add(searchButton);
           buttonPanel.add(createButton);
           buttonPanel.add(reportButton);
           add(buttonPanel, BorderLayout.CENTER);

        // knappernes styling
           searchButton.setBackground(new Color(30, 144, 255));
           searchButton.setForeground(Color.WHITE);
           createButton.setBackground(new Color(34, 139, 34));
           createButton.setForeground(Color.WHITE);
           reportButton.setBackground(new Color(100, 0, 0));
           reportButton.setForeground(Color.WHITE);

           searchButton.setOpaque(true);
           createButton.setOpaque(true);

           searchButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
           createButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
           reportButton.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

           searchButton.setFocusPainted(false);
           createButton.setFocusPainted(false);

           setVisible(true); // Gør at vinduet bliver tydeligt
    }
}