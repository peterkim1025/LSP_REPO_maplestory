package org.howard.edu.lsp.assignment3;

import java.util.ArrayList;
import java.util.List;

/**
 * Coordinates transforming a list of {@link Product} instances into CSV rows
 * according to business rules, and summarizing the transformation.
 * 
 * @since 1.0
 */
public class ProductTransformer {

    /**
     * Transforms each product in the list by applying electronics discount
     * where applicable, computing a price-range label, and returning
     * a list of CSV rows (including header).
     * 
     * @param products list of {@link Product} objects, possibly empty
     * @return list of String[] rows ready for writing, first row is header
     */
    public List<String[]> transform(List<Product> products) {
        List<String[]> result = new ArrayList<>();
        result.add(new String[] { "ProductID", "Name", "Price", "Category", "PriceRange" });

        for (Product p : products) {
            p.applyElectronicsDiscount();
            String priceRange = PriceRangeCalculator.getPriceRange(p.getPrice());
            result.add(p.toCSVRow(priceRange));
        }

        return result;
    }

    /**
     * Prints summary lines to standard output about how many rows
     * were read vs transformed vs skipped, and where output was written.
     * 
     * @param rowsRead    number of data input rows read (excluding header)
     * @param rowsTransformed number of rows that produced valid output
     * @param outputPath  path to the output file where CSV was written
     */
    public void printSummary(int rowsRead, int rowsTransformed, String outputPath) {
        int rowsSkipped = rowsRead - rowsTransformed;
        System.out.println("ETL Process Summary:");
        System.out.println("Rows read: " + rowsRead);
        System.out.println("Rows transformed: " + rowsTransformed);
        System.out.println("Rows skipped: " + rowsSkipped);
        System.out.println("Output written to: " + outputPath);
    }
}
