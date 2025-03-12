package org.example;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {
 public static void main(String[] args) {
  String filePath = "src/main/resources/products.csv";

  try {
   List<Product> products = CsvReader.productscsv(filePath);

   System.out.println("Filter and Sort Products:");
   ProductService.filterAndSortProducts(products).forEach(System.out::println);

   System.out.println("\nproduct names in uppercase:");
   System.out.println(ProductService.getProductNamesInUppercase(products));

   System.out.println("\ntotal stock quantity of all products: " + ProductService.getTotalStockQuantity(products));

   System.out.println("\naverage Price of Products: " + ProductService.getAveragePrice(products));

   System.out.println("\nmost expensive Product:");
   Optional<Product> expensiveProduct = ProductService.getMostExpensiveProduct(products);
   expensiveProduct.ifPresent(System.out::println);

   System.out.println("\ngrouped by category pf products:");
   Map<String, List<Product>> groupedByCategory = ProductService.groupByCategory(products);
   groupedByCategory.forEach((category, productList) -> {
    System.out.println(category + ": " + productList);
   });

   System.out.println("\npartitioned by Stock:");
   Map<Boolean, List<Product>> partitionedByStock = ProductService.partitionByStock(products);
   System.out.println("\nin Stock: " + partitionedByStock.get(true));
   System.out.println("\nout of Stock: " + partitionedByStock.get(false));

   System.out.println("\nproduct names in csv: " + ProductService.getProductNamesCommaSeparated(products));

   System.out.println("\nare all products above $10? " + ProductService.allProductsAbovePrice(products, 10));

   System.out.println("\nif any product belongs to the electronics category ? " + ProductService.anyElectronicsProduct(products));
   System.out.println("\ncount of Products in Stock: " + ProductService.countProductsInStock(products));
   System.out.println("\nhighest rated product: " + ProductService.findHighestRatedProduct(products));
  } catch (custom_Exception e) {
   System.err.println("An error occurred while reading the CSV file: " + e.getMessage());
  }
 }
}