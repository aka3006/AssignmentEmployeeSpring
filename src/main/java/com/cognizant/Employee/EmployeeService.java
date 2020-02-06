package com.cognizant.Employee;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cognizant.Employee.Employee.Gender;

@Service
public class EmployeeService {

	List<Employee> employeeList = new ArrayList<>();

	public void readFromCsv() {
		try {
			InputStream inputStream = EmployeeService.class.getResourceAsStream("/MOCK_DATA.csv");
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			reader.readLine();

			employeeList = reader.lines().map(line -> line.split(",")).map(line -> {
				Employee employee = new Employee();
				employee.setEmployeeId(line[0]);
				employee.setFirstName(line[1]);
				employee.setLastName(line[2]);
				employee.setEmail(line[3]);
				if ((line[3].substring(line[3].lastIndexOf(".") + 1)).length() == 2) {
					employee.setCountryDomain(true);
				}
				if (line[4].equalsIgnoreCase("male")) {
					employee.setGender(Gender.Male);
				} else if (line[4].equalsIgnoreCase("female")) {
					employee.setGender(Gender.Female);
				}
				employee.setDepartmentName(line[5]);
				employee.setSalary(Float.parseFloat(line[6].substring(1).replace(",", "")));
				employee.setSsn(line[7]);
				employee.setStreetAddress(line[8]);
				employee.setCity(line[9]);
				employee.setState(line[10]);
				employee.setZip(line[11]);
				return employee;
			}).collect(Collectors.toList());
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Employee> getAllEmployee() {
		return employeeList;
	}

	public List<Employee> getEmployeeByFirstName(String firstName) {
		return employeeList.stream().filter(employee -> employee.getFirstName().equalsIgnoreCase(firstName))
				.collect(Collectors.toList());
	}

}
