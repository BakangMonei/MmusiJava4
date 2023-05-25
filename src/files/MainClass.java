package files;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainClass extends JFrame {
    private JTextField keywordField;
    private JTextArea resultArea;

    public MainClass() {
        setTitle("File Search");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create input components
        keywordField = new JTextField();
        JButton searchButton = new JButton("Search");

        // Create result area
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        // Add components to the frame
        add(keywordField, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(searchButton, BorderLayout.SOUTH);

        // Add ActionListener to the search button
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchFile();
            }
        });

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void searchFile() {
        String filePath = "/Users/mac/Desktop/humanRMS/src/files/File.txt";
        String keyword = keywordField.getText().trim();

        resultArea.setText(""); // Clear previous results

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // Assuming comma (",") is the field separator
                if (parts.length > 0) {
                    String firstField = parts[0].trim();
                    if (firstField.equals(keyword)) {
                        int field1 = Integer.parseInt(parts[0].trim());
                        int field2 = Integer.parseInt(parts[1].trim());

                        int multiplicationResult = NumberMultiplier.multiply(field1, field2);

                        resultArea.append("Field 1: " + field1 + "\n");
                        resultArea.append("Field 2: " + field2 + "\n");
                        resultArea.append("Multiplication Result: " + multiplicationResult + "\n");
                        resultArea.append("---------------------\n"); // Add a separator line between search results
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainClass();
            }
        });
    }
}

class NumberMultiplier {
    public static int multiply(int field1, int field2) {
        return field1 * field2;
    }
}
