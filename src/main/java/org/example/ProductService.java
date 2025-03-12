package org.example;

import java.util.List;

import java.util.*;
import java.util.stream.Collectors;
public class ProductService {

        //list of products that cost more than $100 and sort them in ascending order of price.
        public static List<Product> filterAndSortProducts(List<Product> products) {
            return products.stream()
                    .filter(p -> p.getPrice() > 100)
                    .sorted(Comparator.comparingDouble(Product::getPrice))
                    .collect(Collectors.toList());
        }

        // product names in uppercase
        public static List<String> productNamesInUppercase(List<Product> products) {
            return products.stream()
                    .map(p ->  p.getName().toUpperCase())
                    .collect(Collectors.toList());
        }

        //  total stock quantity
        public static Double totalStockQuantity(List<Product> products) {
            return products.stream()
                    .map(p -> Optional.ofNullable(p.getStock_quantity()).orElse(0.0)) // Handle null values
                    .mapToDouble(Double::doubleValue)
                    .sum();
        }

        //   average price of all products
        public static double averagePrice(List<Product> products) {
            return products.stream()
                    .collect(Collectors.averagingDouble(Product::getPrice));
        }

        //  the most expensive product
        public static Optional<Product> mostExpensiveProduct(List<Product> products) {
            return products.stream()
                    .max(Comparator.comparingDouble(Product::getPrice));
        }

        // Group products by category
        public static Map<String, List<Product>> groupByCategory(List<Product> products) {
            return products.stream()
                    .collect(Collectors.groupingBy(Product::getCategory));
        }
    // find the product with the highest rating safely
    public static Optional<Product> highestRatedProduct(List<Product> products) {
        return products.stream()
                .filter(p -> p.getRating().isPresent())
                .max(Comparator.comparing(p -> p.getRating().get()));
    }

        //  partition products into in stock and out stock
        public static Map<Boolean, List<Product>> partitionByStock(List<Product> products) {
            return products.stream()
                    .collect(Collectors.partitioningBy(p -> Optional.ofNullable(p.getStock_quantity()).orElse(3.0) > 0));
        }

    public static long countProductsInStock(List<Product> products) {
        return products.stream()
                .filter(p -> Optional.ofNullable(p.getStock_quantity()).orElse(0.0) > 0) // Handles null safely
                .count();
    }

        //   comma-separated list of product names
        public static String pnamesCommaSeparated(List<Product> products) {
            return products.stream()
                    .map(Product::getName)
                    .collect(Collectors.joining(", "));
        }

        //  all products cost more than $10
        public static boolean abovePrice(List<Product> products, double price) {
            return products.stream().allMatch(p -> p.getPrice() > price);
        }

        //  any product belongs to "Electronics"
        public static boolean electronicsProduct(List<Product> products) {
            return products.stream().anyMatch(p -> p.getCategory().equalsIgnoreCase("Electronics"));
        }
    }

