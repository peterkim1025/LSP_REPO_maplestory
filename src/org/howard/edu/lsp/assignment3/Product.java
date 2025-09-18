package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Represents a product and holds fields and methods for transforming product data.
 * <p>
 * A Product has an ID, name, price, and category. It supports applying
 * transformation rules (e.g. discount for Electronics and category change
 * to Premium Electronics) and converting itself into a CSV row.
 * </p>
 * 
 * @since 1.0
 */
public class Product {
    private final int productId;
    private String name;
    private BigDecimal price;
    private String category;

    /**
     * Constructs a Product with the given attributes.
     * Name is converted to uppercase in this constructor.
     * 
     * @param productId unique integer identifier of the product
     * @param name the name of the product (will be converted to uppercase)
     * @param price the price of the product before any transformations
     * @param category the category of the product
     */
    public Product(int productId, String name, BigDecimal price, String category) {
        this.productId = productId;
        this.name = name.toUpperCase();
        this.price = price;
        this.category = category;
    }

    /**
     * Applies the electronics discount if category is "Electronics" (case-insensitive).
     * <p>
     * Rules:
     * <ul>
     *   <li>Reduce price by 10% (multiply by 0.9) and round to two decimal places (HALF_UP).</li>
     *   <li>If resulting price is &gt; 500.00, change category to "Premium Electronics".</li>
     * </ul>
     * </p>
     */
    public void applyElectronicsDiscount() {
        if (category.equalsIgnoreCase("Electronics")) {
            price = price.multiply(BigDecimal.valueOf(0.9))
                         .setScale(2, RoundingMode.HALF_UP);
            if (price.compareTo(BigDecimal.valueOf(500.00)) > 0) {
                category = "Premium Electronics";
            }
        }
    }

    /**
     * Returns the price of this product.
     * 
     * @return current price (may be transformed)
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Returns a CSV row representation of this product, given a price-range label.
     * The row will be an array of 5 elements: productId, name, price, category, priceRange.
     * 
     * @param priceRange the price-range label ("Low", "Medium", etc.)
     * @return a String[] of length 5 to be used in CSV output
     */
    public String[] toCSVRow(String priceRange) {
        return new String[] {
            String.valueOf(productId),
            name,
            price.toString(),
            category,
            priceRange
        };
    }

    /**
     * Returns the category of this product.
     * 
     * @return the product's category (after any transformations)
     */
    public String getCategory() {
        return category;
    }

    /**
     * Returns the name of this product.
     * 
     * @return the product's name (uppercase)
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the product ID.
     * 
     * @return the product's ID
     */
    public int getProductId() {
        return productId;
    }
}
