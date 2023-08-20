package cc.robotdreams.automation.utils;

import cc.robotdreams.TestData;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CSVFileReader {
    private static String filePath;

    public CSVFileReader(String filePath) {
        this.filePath = filePath;
    }

    public static List<String[]> readCSV() throws IOException {
        List<String[]> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                data.add(values);
            }
        }

        return data;
    }

    public static Stream<String[]> csvToDataProvider() throws IOException {
        List<String[]> csvData = readCSV();
        return csvData.stream();
    }
}
