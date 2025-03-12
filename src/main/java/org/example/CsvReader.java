package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CsvReader {

    public static List<Product> productscsv(String filePath) throws custom_Exception {
        List<Product> readData = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                if (line.isEmpty()) {
                    continue;
                }
                String[] values = line.split(",");
                if (values.length < 5) {
                    throw new custom_Exception("invalid format: " + line);
                }

                Optional<Double> rating = (values.length > 5 && !values[5].isEmpty()) ? Optional.of(Double.parseDouble(values[5])) : Optional.empty();

                readData.add(new Product(Integer.parseInt(values[0]), values[1], values[2], Double.parseDouble(values[3]), values[4].isEmpty() ? 0.0 : Double.parseDouble(values[4]), rating));
            }
        } catch (Exception e) {
            throw new custom_Exception("file not found" + e);
        }
        return readData;
    }
}