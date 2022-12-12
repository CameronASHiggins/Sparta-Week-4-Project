package com.sparta.utilities;

import com.sparta.model.dao.interfaces.EmployeeObjectToFile;
import com.sparta.model.entities.Employee;
import org.json.simple.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class EmployeeToXMLFile implements EmployeeObjectToFile {

    @Override
    public void retrievedEmployeesToFile(ArrayList<Employee> retrievedEmployeeslist) {

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;

        try {

            StreamResult file = new StreamResult(new File("retrievedEmployees.xml"));

            for (Employee employee : retrievedEmployeeslist) {

                try {
                    dBuilder = dbFactory.newDocumentBuilder();
                    Document doc = dBuilder.newDocument();
                    // add elements to Document

                    Element rootElement = doc.createElement("Employees");
                    // append root element to document
                    doc.appendChild(rootElement);

                    // append first child element to root element
                    rootElement.appendChild(createUserElement(doc, employee.getEmpNo(), employee.getBirthDate(),
                            employee.getFirstName(), employee.getLastName(), employee.getGender(), employee.getHireDate(),
                            employee.getDepartment()));

                    // for output to file, console
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    // for pretty print
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                    DOMSource source = new DOMSource(doc);

                    // write to console or file
                    StreamResult console = new StreamResult(System.out);

                    // write data
                    transformer.transform(source, console);
                    transformer.transform(source, file);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static Node createUserElement(Document doc, int empNo, String birthDate, String firstName,
                                          String lastName, String gender, String hireDate, String department) {

        Element employee = doc.createElement("Employee");

        // set id attribute
        employee.setAttribute("EmployeeNumber", Integer.toString(empNo));

        // create birthDate element
        employee.appendChild(createUserElements(doc, employee, "birthDate", birthDate));

        // create firstName element
        employee.appendChild(createUserElements(doc, employee, "firstName", firstName));

        // create lastName element
        employee.appendChild(createUserElements(doc, employee, "lastName", lastName));

        // create gender element
        employee.appendChild(createUserElements(doc, employee, "gender", gender));

        // create age element
        employee.appendChild(createUserElements(doc, employee, "hireDate", hireDate));

        // create gender element
        employee.appendChild(createUserElements(doc, employee, "department", department));

        return employee;
    }

    // utility method to create text node
    private static Node createUserElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
}

