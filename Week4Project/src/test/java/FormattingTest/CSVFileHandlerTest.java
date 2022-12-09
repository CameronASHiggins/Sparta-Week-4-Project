package FormattingTest;

import com.sparta.CSVFileHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class CSVFileHandlerTest {

    CSVFileHandler csvFileHandler = new CSVFileHandler();
    @Test
    @DisplayName("Given the Employees CSV, assert the first line matches column by column")
    void givenEmployeeCSV_return_FirstLine(){
        // set up
        String file = "src/main/java/com/sparta/employees01.csv";
        csvFileHandler.setFileName(file);

        String result = null;
        try {
            result = csvFileHandler.readCSV();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String firstLine = result.split("\n")[0];

        // run function
        String[] output = csvFileHandler.getFields(firstLine);

        // assert
        Assertions.assertEquals(String.valueOf(10083), output[0]);
        Assertions.assertEquals("1959-07-23", output[1]);
        Assertions.assertEquals("Vishv", output[2]);
        Assertions.assertEquals("Zockler", output[3]);
        Assertions.assertEquals("M", output[4]);
        Assertions.assertEquals("1987-03-31", output[5]);
    }

    @Test
    void readCSV() {
        String file = "src/main/java/com/sparta/employees01.csv";
        csvFileHandler.setFileName(file);
        try {
            String result = csvFileHandler.readCSV();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        System.out.println(result);

    }

    @Test
    void writeCSV(){
        String inFile = "src/main/java/com/sparta/employees01.csv";
        String outFile = "src/main/java/com/sparta/output-employees01.csv";
        csvFileHandler.setFileName(inFile);
        try {
            CSVFileHandler.writeCSV(csvFileHandler.readCSV(), outFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}