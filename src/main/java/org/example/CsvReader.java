package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CsvReader {

    public static List<Product> productscsv(String filePath) throws filenotfound {
        List<Product> readData = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
          br.readLine();
            while ((line = br.readLine()) != null) {
                if ( line.isEmpty()) {

                    continue;
                }

                String[] values = line.split(",");
                if (values.length < 5) {
                    throw new filenotfound("invalid format: " + line);
                }

                Optional<Double> rating = (values.length > 5 && !values[5].isEmpty()) ? Optional.of(Double.parseDouble(values[5])) : Optional.empty();

                readData.add(new Product(Integer.parseInt(values[0]), values[1], values[2], Double.parseDouble(values[3]), values[4].isEmpty() ? 0.0 : Double.parseDouble(values[4]), Optional.of(rating.orElse(3.0))));
            }
        } catch (Exception e) {
            throw new filenotfound("file not found" + e);
        }
        return readData;
    }
}