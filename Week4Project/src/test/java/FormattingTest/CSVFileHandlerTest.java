package FormattingTest;

import com.sparta.CSVFileHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CSVFileHandlerTest {

    @Test
    @DisplayName("Given the Employees CSV, assert the first line matches column by column")
    void givenEmployeeCSV_return_FirstLine(){
        // set up
        String file = "src/main/java/com/sparta/employees01.csv";
        String result = CSVFileHandler.readCSV(file);
        String firstLine = result.split("\n")[0];

        // run function
        String[] output = CSVFileHandler.getFields(firstLine);

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
        String result = CSVFileHandler.readCSV(file);
//        System.out.println(result);

    }

    @Test
    void writeCSV(){
        String inFile = "src/main/java/com/sparta/employees01.csv";
        String outFile = "src/main/java/com/sparta/output-employees01.csv";
        CSVFileHandler.writeCSV(CSVFileHandler.readCSV(inFile), outFile);

    }

}