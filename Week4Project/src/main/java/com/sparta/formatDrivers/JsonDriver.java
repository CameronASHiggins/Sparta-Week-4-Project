package com.sparta.formatDrivers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.sparta.model.entities.Employee;

public class JsonDriver {

    public String ObjToJson(Employee employee) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(employee);
    }
    public Employee JsonToObj(String s) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(s, Employee.class);
    }
}
//TODO: get employee converter class
// generate object to json - done
// create object mapper - done
// repeat for object to xml - done
// consider json to objct and xml to object - done