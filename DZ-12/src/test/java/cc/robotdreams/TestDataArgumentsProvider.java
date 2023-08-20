package cc.robotdreams;

import cc.robotdreams.automation.utils.CSVFileReader;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.List;
import java.util.stream.Stream;

public class TestDataArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        String csvPath = "src/main/resources/DZ-12/testdata.csv";
        CSVFileReader csvFileReader = new CSVFileReader(csvPath);

        List<String[]> csvData = csvFileReader.readCSV();

        return csvData.stream().map(data -> {
            String hobby1 = data[0];
            String hobby2 = data[1];
            TestData testData = new TestData(hobby1, hobby2);
            return Arguments.of(testData);
        });
    }

}

