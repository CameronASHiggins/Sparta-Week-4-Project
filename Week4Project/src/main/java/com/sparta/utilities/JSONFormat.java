package com.sparta.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.model.entities.Employee;

import java.io.*;

public class JSONFormat implements WriteFile{

    public String ObjToJson(Employee employee) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(employee);
    }
    public Employee JsonToObj(String s) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(s, Employee.class);
    }

    @Override
    public void writeToFile( Employee[] employees , String outFile ){
        //JSONFormat format = new JSONFormat();

        try( BufferedWriter bw = new BufferedWriter(new FileWriter( outFile )) ){ // soz

            for( Employee emp : employees ){
                bw.write( ObjToJson(emp) );  // write each employee object as string line to file
            }
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public void readFromFile( Employee[] employees , String inFile ){
        //JSONFormat format = new JSONFormat();

        try( BufferedReader bw = new BufferedReader(new FileReader( inFile )) ){ // soz

//            for( String emp : bw ){
//                bw.read( JsonToObj(emp) );  // write each employee object as string line to file
//            }
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
