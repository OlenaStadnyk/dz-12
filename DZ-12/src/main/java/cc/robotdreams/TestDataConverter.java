package cc.robotdreams;

import org.apache.commons.beanutils.Converter;
import com.opencsv.bean.CsvBindByName;

public class TestDataConverter implements Converter {

    @Override
    public Object convert(Class type, Object value) {
        if (type == TestData.class && value instanceof String) {
            String[] values = ((String) value).split(",");
            TestData testData = new TestData();
            testData.hobby1 = values[0]; // Use the direct access to field
            testData.hobby2 = values[1]; // Use the direct access to field
            return testData;
        }
        return null;
    }
}


