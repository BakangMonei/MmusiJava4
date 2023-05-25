package files;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainClasss extends JFrame {
    private JTextArea resultArea;

    public MainClasss() {
        setTitle("File Search");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create result area
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);

        // Add result area to the frame
        add(scrollPane, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        searchFile();
    }

    private void searchFile() {
        String filePath = "path/to/your/file.txt";
        int[] selectedColumns = {0, 2}; // Specify the column indices you want to select (zero-based)

        StringBuilder outputBuilder = new StringBuilder(); // StringBuilder to store the output

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            outputBuilder.append(createTableHeader(selectedColumns));
            outputBuilder.append("---------------------\n");

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // Assuming comma (",") is the field separator
                if (parts.length > 0) {
                    outputBuilder.append(createTableRow(parts, selectedColumns));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Set the contents of the StringBuilder to the resultArea
        resultArea.setText(outputBuilder.toString());
    }

    private String createTableHeader(int[] selectedColumns) {
        StringBuilder headerBuilder = new StringBuilder();
        headerBuilder.append("Row\t");
        for (int columnIndex : selectedColumns) {
            headerBuilder.append("Column ").append(columnIndex + 1).append("\t");
        }
        headerBuilder.append("\n");
        return headerBuilder.toString();
    }

    private String createTableRow(String[] parts, int[] selectedColumns) {
        StringBuilder rowBuilder = new StringBuilder();
        rowBuilder.append(parts[0]).append("\t");
        for (int columnIndex : selectedColumns) {
            if (columnIndex >= 0 && columnIndex < parts.length) {
                rowBuilder.append(parts[columnIndex].trim()).append("\t");
            }
        }
        rowBuilder.append("\n");
        return rowBuilder.toString();
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
