package org.example;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Main {
 public static void main(String[] args) {
  String filePath = "src/main/resources/products.csv";

  try {
   List<Product> products = CsvReader.productscsv(filePath);

     System.out.println("filter and sort products more than $100:");
    ProductService.filterAndSortProducts(products).forEach(System.out::println);

   System.out.println("\nproduct names in uppercase:");
   System.out.println(ProductService.productNamesInUppercase(products));

   System.out.println("\ntotal stock quantity of all products: " + ProductService.totalStockQuantity(products));

   System.out.println("\naverage price of products: " + ProductService.averagePrice(products));

   System.out.println("\nmost expensive product:");
   Optional<Product> expensiveProduct = ProductService.mostExpensiveProduct(products);
   expensiveProduct.ifPresent(System.out::println);

   System.out.println("\ngrouped by category of products:");
   Map<String, List<Product>> groupedByCategory = ProductService.groupByCategory(products);
   groupedByCategory.forEach((category, productList) -> {
    System.out.println(category + ": " + productList);
   });

   System.out.println("\npartitioned by Stock:");
   Map<Boolean, List<Product>> partitionedByStock = ProductService.partitionByStock(products);
   System.out.println("\nin Stock: " + partitionedByStock.get(true));
   System.out.println("\nout of stock: " + partitionedByStock.get(false));

   System.out.println("\nproduct names in csv: " + ProductService.pnamesCommaSeparated(products));

   System.out.println("\nare all products above $10: " + ProductService.abovePrice(products, 10));

   System.out.println("\nproduct in electronics category : " + ProductService.electronicsProduct(products));
   System.out.println("\ncount of products in Stock: " + ProductService.countProductsInStock(products));
   System.out.println("\nhighest rated product: " + ProductService.highestRatedProduct(products));
  }
  catch (filenotfound e) {
   System.err.println(" error while reading the csv file: " + e.getMessage());
  }

 }
}