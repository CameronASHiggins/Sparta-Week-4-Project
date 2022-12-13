package FormattingTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sparta.model.entities.Employee;
import com.sparta.model.entities.FileFactory;
import com.sparta.utilities.FileType;
import com.sparta.utilities.JSONFormat;
import com.sparta.utilities.XMLFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileFormatTest {

    @ParameterizedTest
    @CsvSource({"hello.xml","test1.XmL","test5.xml", "hungry.xml", "happy.XML","thanks.xml"})
    @DisplayName("given an xml file name as string, return an xml file type object")
    public void givenXMLExtensionreturnXMLType(String input){
        FileFactory ff = new FileFactory();
        FileType result = ff.storeToSpecifiedFile(input);
        FileType expected = new XMLFormat();

        assertEquals( expected.getClass(), result.getClass() );
    }

    @ParameterizedTest
    @CsvSource({"hello.json","test1.jSoN","test5.JSON", "hungry.jsON", "happy.JSoN","thanks.jsoN"})
    @DisplayName("given an json file name as string, return an json file type object")
    public void givenJSONExtensionreturnJSONType(String input){
        FileFactory ff = new FileFactory();
        FileType result = ff.storeToSpecifiedFile(input);
        FileType expected = new JSONFormat();

        assertEquals( expected.getClass(), result.getClass() );
    }

    @Test
    @DisplayName("given Employee obj Return XML String")
    public void givenEmployeeReturnXMLString() throws JsonProcessingException {

        Employee e = new Employee(4, "1998-01-20","Joe","Grey","M","2020-01-05","Quality Management");
        XMLFormat xmlFormat = new XMLFormat();

        String result = xmlFormat.ObjToXML(e);
        String expected = "<Employee><empNo>4</empNo><birthDate>1998-01-20</birthDate><firstName>Joe</firstName><lastName>Grey</lastName><gender>M</gender><hireDate>2020-01-05</hireDate><department>Quality Management</department></Employee>";

        assertEquals( expected, result );
    }

    @Test
    @DisplayName("given Employee obj Return JSON String")
    public void givenEmployeeReturnJSONString() throws JsonProcessingException {

        Employee e = new Employee(4, "1998-01-20","Joe","Grey","M","2020-01-05","Quality Management");
        JSONFormat jsonFormat = new JSONFormat();

        String result = jsonFormat.ObjToJson(e);
        String expected = "{\"empNo\":4,\"birthDate\":\"1998-01-20\",\"firstName\":\"Joe\",\"lastName\":\"Grey\",\"gender\":\"M\",\"hireDate\":\"2020-01-05\",\"department\":\"Quality Management\"}";
        assertEquals( expected.toString(), result.toString() );
    }

    @Test
    @DisplayName("given a JSON type String Return an EmployeeObject")
    public void givenJSONStringReturnEmployeeObject() throws JsonProcessingException {
        String JSONstring = "{\"empNo\":4,\"birthDate\":\"1998-01-20\",\"firstName\":\"Joe\",\"lastName\":\"Grey\",\"gender\":\"M\",\"hireDate\":\"2020-01-05\",\"department\":\"Quality Management\"}";
        JSONFormat jf = new JSONFormat();

        Employee expected = new Employee(4, "1998-01-20","Joe","Grey","M","2020-01-05","Quality Management");
        Employee result = jf.JsonToObj(JSONstring);

        String expected2 = "Employee{empNo=4, birthDate='1998-01-20', firstName='Joe', lastName='Grey', gender=M, hireDate='2020-01-05', department='Quality Management'}";
        String result2 = expected.toString();

        assertEquals( expected.getClass(), result.getClass() );
        assertEquals( expected2, result2);
    }

    @Test
    @DisplayName("given a XML type String Return an EmployeeObject")
    public void givenXMLStringReturnEmployeeObject() throws JsonProcessingException {
        String XMLstring = "<Employee><empNo>4</empNo><birthDate>1998-01-20</birthDate><firstName>Joe</firstName><lastName>Grey</lastName><gender>M</gender><hireDate>2020-01-05</hireDate><department>Quality Management</department></Employee>";
        XMLFormat xf = new XMLFormat();

        Employee expected = new Employee(4, "1998-01-20","Joe","Grey","M","2020-01-05","Quality Management");
        Employee result = xf.XMLToObj(XMLstring);

        String expected2 = "Employee{empNo=4, birthDate='1998-01-20', firstName='Joe', lastName='Grey', gender=M, hireDate='2020-01-05', department='Quality Management'}";
        String result2 = expected.toString();

        assertEquals( expected.getClass(), result.getClass() );
        assertEquals( expected2, result2);
    }




}
