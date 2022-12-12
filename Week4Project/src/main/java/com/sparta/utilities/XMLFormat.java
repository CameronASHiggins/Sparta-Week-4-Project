package com.sparta.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sparta.model.entities.Employee;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class XMLFormat implements WriteFile {
    public String ObjToXML(Employee employee) throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        return mapper.writeValueAsString(employee);
    }
    public Employee XMLToObj(String s) throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        return mapper.readValue(s, Employee.class);
    }

    @Override
    public void writeToFile( Employee[] employees , String outFile ){

        try( BufferedWriter bw = new BufferedWriter(new FileWriter( outFile )) ){ // soz

            for( Employee emp : employees ){
                bw.write( ObjToXML(emp) );  // write each employee object as string line to file
            }
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
