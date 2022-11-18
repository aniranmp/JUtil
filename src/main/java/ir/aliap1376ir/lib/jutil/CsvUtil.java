package ir.aliap1376ir.lib.jutil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvUtil {

    public static final String COMMA_DELIMITER = ",";

    public static List<List<String>> readCSV(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
       return readCSV(fileReader);
    }

    public static List<List<String>> readCSV(File file) throws IOException {
        FileReader fileReader = new FileReader(file);
       return readCSV(fileReader);
    }

    private static List<List<String>> readCSV(FileReader fileReader) throws IOException {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(fileReader)) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                records.add(Arrays.asList(values));
            }
        }
        return records;
    }
}
