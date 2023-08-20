package cc.robotdreams;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvToBean;

public class TestData extends CsvToBean {
    @CsvBindByName
    String hobby1;

    @CsvBindByName
    String hobby2;

    public TestData(String hobby1, String hobby2) {
        this.hobby1 = hobby1;
        this.hobby2 = hobby2;
    }

    public TestData() {

    }

    public String getHobby1() {
        return hobby1;
    }

    public String getHobby2() {
        return hobby2;
    }

    public void setHobby1(String hobby1) {

    }

    public void setHobby2(String hobby2) {

    }
}
