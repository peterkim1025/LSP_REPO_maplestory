package org.howard.edu.lsp.assignment3;

import java.util.List;

/**
 * Main driver class to execute the ETL pipeline.
 * <p>
 * It reads from input CSV, transforms the data, writes to output CSV,
 * and prints a summary. Behaves equivalently to your Assignment 2 program,
 * but using object-oriented decomposition.
 * </p>
 * 
 * @since 1.0
 */
public class ETLDriver {

    /**
     * Main entry point. Reads from data/products.csv, transforms, writes to
     * data/transformed_products.csv, handles missing or empty file cases.
     * 
     * @param args command-line arguments (ignored)
     */
    public static void main(String[] args) {
        String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";

        CSVReader reader = new CSVReader(inputPath);
        List<Product> products = reader.readProducts();

        int rowsRead = reader.getRowsRead();
        int rowsTransformed = products.size();

        if (rowsRead == 0 && products.isEmpty()) {
            // Either file missing or empty or only header
            // Still write header-only output to maintain behavior
            CSVWriter writer = new CSVWriter(outputPath);
            // Create rows with only header
            List<String[]> headerOnly = new java.util.ArrayList<>();
            headerOnly.add(new String[] { "ProductID", "Name", "Price", "Category", "PriceRange" });
            writer.write(headerOnly);
            System.out.println("Input file was empty.");
            (new ProductTransformer()).printSummary(rowsRead, rowsTransformed, outputPath);
            return;
        }

        ProductTransformer transformer = new ProductTransformer();
        List<String[]> transformedRows = transformer.transform(products);

        CSVWriter writer = new CSVWriter(outputPath);
        writer.write(transformedRows);

        transformer.printSummary(rowsRead, rowsTransformed, outputPath);
    }
}
