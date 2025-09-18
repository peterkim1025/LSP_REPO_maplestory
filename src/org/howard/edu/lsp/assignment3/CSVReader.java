package org.howard.edu.lsp.assignment3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code CSVReader} class reads product data from a CSV file
 * and converts valid entries into {@link Product} objects.
 * <p>
 * It handles error checking for malformed rows and missing files.
 * </p>
 */
public class CSVReader {
    private final String filePath;
    private int rowsRead = 0;

    /**
     * Constructs a new {@code CSVReader} with the specified input file path.
     *
     * @param filePath the path to the input CSV file containing product data
     */
    public CSVReader(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Reads the CSV file and returns a list of valid {@link Product} objects.
     * <p>
     * Lines with missing or invalid data are skipped. The method also counts
     * the number of rows successfully read (excluding the header).
     * </p>
     *
     * @return a list of valid {@code Product} objects parsed from the file
     */
    public List<Product> readProducts() {
        List<Product> products = new ArrayList<>();
        File inputFile = new File(filePath);

        if (!inputFile.exists()) {
            System.err.println("Error: Input file '" + filePath + "' not found. Try again.");
            return products;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String header = reader.readLine(); // Skip header

            if (header == null) {
                System.out.println("Input file was empty.");
                return products;
            }

            String line;
            while ((line = reader.readLine()) != null) {
                rowsRead++;
                String[] fields = line.split(",");

                if (fields.length != 4) {
                    System.out.println("Skipping malformed line: " + line);
                    continue;
                }

                try {
                    int id = Integer.parseInt(fields[0]);
                    String name = fields[1];
                    BigDecimal price = new BigDecimal(fields[2]);
                    String category = fields[3];

                    Product product = new Product(id, name, price, category);
                    products.add(product);
                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid row: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading input file: " + filePath);
            e.printStackTrace();
        }

        return products;
    }

    /**
     * Returns the number of rows successfully read from the file,
     * not including the header row.
     *
     * @return the number of rows read
     */
    public int getRowsRead() {
        return rowsRead;
    }
}
