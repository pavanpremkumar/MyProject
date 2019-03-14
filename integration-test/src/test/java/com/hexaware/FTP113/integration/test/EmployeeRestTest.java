package com.hexaware.FTP113.integration.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import org.junit.Test;
import static org.junit.Assert.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.given;

public class EmployeeRestTest {

	@Test
	public void testEmployeesList() throws AssertionError, URISyntaxException, ParseException {
		Employee[] res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees")).getBody().as(Employee[].class);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String s1 = "2016-05-20";
    	Date doj = sdf.parse(s1);
		System.out.println(doj);
    	String s2 = "2018-10-20";
    	Date doj1 = sdf.parse(s2);
		
		String s3 = "2018-12-20";
    	Date doj2 = sdf.parse(s3);

		String s4 = "2017-03-22";
    	Date doj3 = sdf.parse(s4);

		String s5 = "2019-01-01";
    	Date doj4 = sdf.parse(s5);

		Employee e101 = new Employee(1000, "SANJANA KOLAGE", "SANJANAK@HEXAWARE.COM", "7768858666", doj, "HEXAVARSITY", 0, 26);
		Employee e102 = new Employee(2000, "BHASKAR GURANA", "BHASKARG@HEXAWARE.COM", "8555001572", doj1, "HEXAVARSITY", 1000, 8);
		Employee e103 = new Employee(3000, "PAVANPREMKUMAR ", "PAVANPREM@HEXAWARE.COM", "897235639", doj2, "HEXAVARSITY", 1000, 33);
		Employee e104 = new Employee(4000, "NISHTHA BABBAR", "NISHTHAB@HEXAWARE.COM", "896834599", doj3, "HEXAVARSITY", 2000, 40);
		Employee e105 = new Employee(5000, "KARTHIGA PITCHIAH", "KARTHIGAP@HEXAWARE.COM", "9488779298", doj4, "HEXAVARSITY", 3000, 21);

		
		for (Employee e: res) {
			switch (e.getEmpId()) {
				case 1000:
					assertEquals(res[0], e101);
					break;
				case 2000 : 
					assertEquals(res[1], e102);
					break;
				case 3000:
					assertEquals(res[2], e103);
					break;
				case 4000:
					assertEquals(res[3], e104);
					break;
				case 5000:
					assertEquals(res[4], e105);
					break;
				default:
					fail("Unknown employee with id:" + e);	
			}
	}
	}

	@Test
	public void testEmployeeById() throws AssertionError, URISyntaxException,ParseException { 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String s1 = "2016-05-20";
    	Date doj = sdf.parse(s1);
		System.out.println(doj);
    	String s2 = "2018-10-20";
    	Date doj1 = sdf.parse(s2);
		String s3 = "2018-12-20";
    	Date doj2 = sdf.parse(s3);

		String s4 = "2017-03-22";
    	Date doj3 = sdf.parse(s4);

		String s5 = "2019-01-01";
    	Date doj4 = sdf.parse(s5);

		Employee e101 = new Employee(1000, "SANJANA KOLAGE", "SANJANAK@HEXAWARE.COM", "7768858666", doj, "HEXAVARSITY", 0, 26);
		Employee res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/1000")).getBody().as(Employee.class);
		// assertEquals(e101, res);
		assertEquals(e101.getEmpId(), res.getEmpId());
		assertEquals(e101.getEmpFullName(), res.getEmpFullName());
		assertEquals(e101.getEmpEmail(), res.getEmpEmail());
		assertEquals(e101.getEmpMobileNo(), res.getEmpMobileNo());
		assertEquals(e101.getEmpDepartment(), res.getEmpDepartment());
		assertEquals(e101.getEmpMgrId(), res.getEmpMgrId());
		assertEquals(e101.getEmpAvailLeavBal(), res.getEmpAvailLeavBal());

		Employee e102 = new Employee(2000, "BHASKAR GURANA", "BHASKARG@HEXAWARE.COM", "8555001572", doj1, "HEXAVARSITY", 1000, 8);
		Employee res1 = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/2000")).getBody().as(Employee.class);
		// assertEquals(e101, res);
		assertEquals(e102.getEmpId(), res1.getEmpId());
		assertEquals(e102.getEmpFullName(), res1.getEmpFullName());
		assertEquals(e102.getEmpEmail(), res1.getEmpEmail());
		assertEquals(e102.getEmpMobileNo(), res1.getEmpMobileNo());
		assertEquals(e102.getEmpDepartment(), res1.getEmpDepartment());
		assertEquals(e102.getEmpMgrId(), res1.getEmpMgrId());
		assertEquals(e102.getEmpAvailLeavBal(), res1.getEmpAvailLeavBal());


		Employee e103 = new Employee(3000, "PAVANPREMKUMAR ", "PAVANPREM@HEXAWARE.COM", "897235639", doj2, "HEXAVARSITY", 1000, 33);
		Employee res2 = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/3000")).getBody().as(Employee.class);
		// assertEquals(e101, res);
		assertEquals(e103.getEmpId(), res2.getEmpId());
		assertEquals(e103.getEmpFullName(), res2.getEmpFullName());
		assertEquals(e103.getEmpEmail(), res2.getEmpEmail());
		assertEquals(e103.getEmpMobileNo(), res2.getEmpMobileNo());
		assertEquals(e103.getEmpDepartment(), res2.getEmpDepartment());
		assertEquals(e103.getEmpMgrId(), res2.getEmpMgrId());
		assertEquals(e103.getEmpAvailLeavBal(), res2.getEmpAvailLeavBal());



		Employee e104 = new Employee(4000, "NISHTHA BABBAR", "NISHTHAB@HEXAWARE.COM", "896834599", doj3, "HEXAVARSITY", 2000, 40);
		Employee res3 = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/4000")).getBody().as(Employee.class);
		// assertEquals(e101, res);
		assertEquals(e104.getEmpId(), res3.getEmpId());
		assertEquals(e104.getEmpFullName(), res3.getEmpFullName());
		assertEquals(e104.getEmpEmail(), res3.getEmpEmail());
		assertEquals(e104.getEmpMobileNo(), res3.getEmpMobileNo());
		assertEquals(e104.getEmpDepartment(), res3.getEmpDepartment());
		assertEquals(e104.getEmpMgrId(), res3.getEmpMgrId());
		assertEquals(e104.getEmpAvailLeavBal(), res3.getEmpAvailLeavBal());


		Employee e105 = new Employee(5000, "KARTHIGA PITCHIAH", "KARTHIGAP@HEXAWARE.COM", "9488779298", doj4, "HEXAVARSITY", 3000, 21);
		Employee res4 = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/5000")).getBody().as(Employee.class);
		// assertEquals(e101, res);
		assertEquals(e105.getEmpId(), res4.getEmpId());
		assertEquals(e105.getEmpFullName(), res4.getEmpFullName());
		assertEquals(e105.getEmpEmail(), res4.getEmpEmail());
		assertEquals(e105.getEmpMobileNo(), res4.getEmpMobileNo());
		assertEquals(e105.getEmpDepartment(), res4.getEmpDepartment());
		assertEquals(e105.getEmpMgrId(), res4.getEmpMgrId());
		assertEquals(e105.getEmpAvailLeavBal(), res4.getEmpAvailLeavBal());

  }
  
  @Test
	public void testEmployeeById404() throws AssertionError, URISyntaxException { 
	
		given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/9999")).then().assertThat().statusCode(404);
	}
}
