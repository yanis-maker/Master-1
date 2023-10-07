package coom.example.demo.cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class EmployeeRestClientCLI extends AbstractMain implements CommandLineRunner {
	
	/*ATTRIBUTES*/
	@Autowired
	private RestTemplate proxy;
	private IntegerInputProcessor inputProcessor;
	private static String URI_EMPLOYEE;
	private static String URI_EMPLOYEE_ID; 
	
	
	@Override
	public void run(String... args) throws Exception {
		
		BufferedReader inputReader;
		String userInput = "";
		
		try {
			
			inputReader = new BufferedReader(
			new InputStreamReader(System.in));
			setTestServiceUrl(inputReader);
			
			URI_EMPLOYEE = SERVICE_URL + "/employees";
			URI_EMPLOYEE_ID = URI_EMPLOYEE + "/{id}";
			
			do {
				menu();
				userInput = inputReader.readLine();
				processUserInput(inputReader, userInput, proxy);
				Thread.sleep(3000);
			} while(!userInput.equals(QUIT));
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
	}

	@Override
	protected boolean validServiceUrl() {
		return SERVICE_URL.equals(
				"http://localhost:8080/employeeservice/api");
	}

	@Override
	protected void menu() {
		
		StringBuilder builder = new StringBuilder();
		builder.append(QUIT+". Quit.");
		builder.append("\n1. Get number of employees.");
		builder.append("\n2. Display all employees.");
		builder.append("\n3. Get employee by ID");
		builder.append("\n4. Add new employee");
		builder.append("\n5. Remove employee by ID");
		builder.append("\n6. Update existing employee");
		System.out.println(builder);

	}
	
	private void processUserInput(BufferedReader reader, String userInput, RestTemplate proxy) {
		
		try {
			switch(userInput) {
				case "1":
					String uri=URI_EMPLOYEE +"/count";
					String countStr=proxy.getForObject(uri, String.class);
					ObjectMapper mapper=new ObjectMapper();
					mapper.readValue(countStr, Map.class);
					long count =(int) mapper.readValue(countStr,Map.class).get("count");
					String.out.println(String.format)("There are %d emplouyees courn)
					break;
				
			}
		}
		
		
		
	}

}
