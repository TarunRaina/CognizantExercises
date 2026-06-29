import java.util.Arrays;

class Product implements Comparable<Product> {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product(ID: " + productId + ", Name: " + productName + ", Category: " + category + ")";
    }

    // lets Arrays.sort() know how Product objects should be compared
    @Override
    public int compareTo(Product other) {
        return Integer.compare(this.productId, other.productId);
    }
}

class SearchAlgorithms {

    public static Product linearSearch(Product[] products, int targetId) {

        // just go through each product till we find a match
        for (Product product : products) {
            if (product.getProductId() == targetId) {
                return product;
            }
        }

        return null;
    }

    public static Product binarySearch(Product[] sortedProducts, int targetId) {

        int low = 0;
        int high = sortedProducts.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;
            Product current = sortedProducts[mid];

            if (current.getProductId() == targetId) {
                return current;
            }

            if (current.getProductId() < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }
}

public class Main {

    public static void main(String[] args) {

        Product[] productArray = {
                new Product(505, "Wireless Mouse", "Electronics"),
                new Product(102, "Running Shoes", "Footwear"),
                new Product(750, "Coffee Maker", "Home Appliances"),
                new Product(301, "Notebook", "Stationery"),
                new Product(210, "Backpack", "Accessories"),
                new Product(450, "Smartphone", "Electronics")
        }; // didnt wanna spend time thinking of sample data lol

        Product[] sortedArray = productArray.clone();

        // keep the original array as it is
        Arrays.sort(sortedArray);

        System.out.println("Sorted Products");
        for (Product product : sortedArray) {
            System.out.println("  " + product);
        }

        int targetId = 210;

        System.out.println("\nLinear Search");

        long start = System.nanoTime();
        Product linearResult = SearchAlgorithms.linearSearch(productArray, targetId);
        long end = System.nanoTime();

        System.out.println("Found: " + linearResult);
        System.out.printf("Time: %.3f ms%n", (end - start) / 1_000_000.0);

        System.out.println("\nBinary Search");

        start = System.nanoTime();
        Product binaryResult = SearchAlgorithms.binarySearch(sortedArray, targetId);
        end = System.nanoTime();

        System.out.println("Found: " + binaryResult);
        System.out.printf("Time: %.3f ms%n", (end - start) / 1_000_000.0);
    }
}