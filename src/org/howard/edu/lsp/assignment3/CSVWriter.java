package org.howard.edu.lsp.assignment3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * The {@code CSVWriter} class writes a list of CSV-formatted string arrays
 * to a specified output file.
 * <p>
 * Each string array is written as a single line in the CSV file.
 * </p>
 */
public class CSVWriter {
    private final String filePath;

    /**
     * Constructs a new {@code CSVWriter} with the specified output file path.
     *
     * @param filePath the path where the output CSV will be saved
     */
    public CSVWriter(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Writes the given list of string arrays (rows) to the output CSV file.
     * <p>
     * Each array represents one row, and its elements are joined with commas.
     * </p>
     *
     * @param rows a list of string arrays, where each array represents a CSV row
     */
    public void write(List<String[]> rows) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] row : rows) {
                writer.write(String.join(",", row));
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to output file: " + filePath);
            e.printStackTrace();
        }
    }
}
