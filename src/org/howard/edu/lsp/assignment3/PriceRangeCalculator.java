package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/**
 * Provides utility to calculate a price-range classification based on numeric price.
 * <p>
 * Categories:
 * <ul>
 *   <li>price ≤ 10.00 → "Low"</li>
 *   <li>10.00 < price ≤ 100.00 → "Medium"</li>
 *   <li>100.00 < price ≤ 500.00 → "High"</li>
 *   <li>price > 500.00 → "Premium"</li>
 * </ul>
 * </p>
 * 
 * @since 1.0
 */
public class PriceRangeCalculator {

    private PriceRangeCalculator() {
        // private constructor to prevent instantiation
    }

    /**
     * Returns the price range label for a given price.
     * 
     * @param price the price to classify (must be non-null)
     * @return one of "Low", "Medium", "High", or "Premium"
     */
    public static String getPriceRange(BigDecimal price) {
        if (price.compareTo(BigDecimal.valueOf(10.00)) <= 0) {
            return "Low";
        } else if (price.compareTo(BigDecimal.valueOf(100.00)) <= 0) {
            return "Medium";
        } else if (price.compareTo(BigDecimal.valueOf(500.00)) <= 0) {
            return "High";
        } else {
            return "Premium";
        }
    }
}
