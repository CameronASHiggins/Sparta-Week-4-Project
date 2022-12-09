package serealising;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import com.sparta.Employee;

public class XMLDriver {
    public String ObjToXML(Employee employee) throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        return mapper.writeValueAsString(employee);
    }
    public Employee XMLToObj(String s) throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        return mapper.readValue(s, Employee.class);
    }
}
