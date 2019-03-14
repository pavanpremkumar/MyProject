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


public class LeaveDetailsRestTest {

   

    @Test 
    public void testLeaveHistory() throws AssertionError, URISyntaxException,ParseException { 
              
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
          final String s1 = "2019-03-04";
    final Date s = sdf.parse(s1);
    final String s2 = "2019-03-05";
    final Date e = sdf.parse(s2);
    final String s3 = "2019-02-05";
    final Date l = sdf.parse(s3);
           LeaveDetails[] res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leaveDetails/leaveHistory/1000")).getBody().as(LeaveDetails[].class);
           LeaveDetails l2 = new LeaveDetails(1, 1000, 2, s, e, LeaveType.EL, LeaveStatus.PENDING, "sick", l, "null");
           assertEquals(res[0].getLeaId(), l2.getLeaId());
    }

     @Test
	public void testPendingLeaves() throws AssertionError, URISyntaxException,ParseException { 
              
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
          final String s1 = "2019-02-26";
    final Date s = sdf.parse(s1);
    final String s2 = "2019-02-26";
    final Date e = sdf.parse(s2);
    final String s3 = "2019-02-25";
    final Date l = sdf.parse(s3);
           LeaveDetails[] res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leaveDetails/listPending/1000")).getBody().as(LeaveDetails[].class);
           LeaveDetails l2 = new LeaveDetails(37, 2000, 1, s, e, LeaveType.EL, LeaveStatus.PENDING, "home", l, "null");
           assertEquals(res[0].getLeaId(), l2.getLeaId());
    }

    @Test
	public void testLeaveDetailsById() throws AssertionError, URISyntaxException,ParseException { 
        LeaveDetails res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leaveDetails/1")).getBody().as(LeaveDetails.class);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
          final String s1 = "2019-03-04";
    final Date s = sdf.parse(s1);
    final String s2 = "2019-03-05";
    final Date e = sdf.parse(s2);
    final String s3 = "2019-02-05";
    final Date l = sdf.parse(s3);

    LeaveDetails l1 = new LeaveDetails(1, 1000, 2, s, e, LeaveType.EL, LeaveStatus.PENDING, "sick", l, null);
    assertEquals(l1.getLeaId(), res.getLeaId());
     assertEquals(l1.getLeaEmpId(), res.getLeaEmpId());
      assertEquals(l1.getLeaNumberOfDays(), res.getLeaNumberOfDays());
         assertEquals(l1.getLeaLeaveType(), res.getLeaLeaveType());
          assertEquals(l1.getLeaStatus(), res.getLeaStatus());
           assertEquals(l1.getLeaReason(), res.getLeaReason());
             assertEquals(l1.getLeaManagerComment(), res.getLeaManagerComment());

    LeaveDetails res1 = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leaveDetails/2")).getBody().as(LeaveDetails.class);

    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    final String s4 = "2019-08-12";
    final Date s11 = sdf1.parse(s4);
    final String s5 = "2019-08-13";
    final Date e11 = sdf1.parse(s5);
    final String s6 = "2019-02-05";
    final Date l11 = sdf1.parse(s6);
        
    LeaveDetails l2 = new LeaveDetails(2, 4000, 2, s11, e11, LeaveType.EL, LeaveStatus.APPROVED, "sick", l11, "BYE");
    assertEquals(l2.getLeaId(), res1.getLeaId());
     assertEquals(l2.getLeaEmpId(), res1.getLeaEmpId());
      assertEquals(l2.getLeaNumberOfDays(), res1.getLeaNumberOfDays());
         assertEquals(l2.getLeaLeaveType(), res1.getLeaLeaveType());
          assertEquals(l2.getLeaStatus(), res1.getLeaStatus());
           assertEquals(l2.getLeaReason(), res1.getLeaReason());
             assertEquals(l2.getLeaManagerComment(), res1.getLeaManagerComment());


 LeaveDetails res2 = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leaveDetails/3")).getBody().as(LeaveDetails.class);

    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    final String s7 = "2019-03-01";
    final Date s22 = sdf2.parse(s7);
    final String s8 = "2019-03-05";
    final Date e22 = sdf2.parse(s8);
    final String s9 = "2019-02-05";
    final Date l22 = sdf2.parse(s9);
        
    LeaveDetails l3 = new LeaveDetails(3, 2000, 5, s22, e22, LeaveType.PL, LeaveStatus.APPROVED, "Marraige", l22, "ENJOY YOUR HOILDAY..");
    assertEquals(l3.getLeaId(), res2.getLeaId());
     assertEquals(l3.getLeaEmpId(), res2.getLeaEmpId());
      assertEquals(l3.getLeaNumberOfDays(), res2.getLeaNumberOfDays());
         assertEquals(l3.getLeaLeaveType(), res2.getLeaLeaveType());
          assertEquals(l3.getLeaStatus(), res2.getLeaStatus());
           assertEquals(l3.getLeaReason(), res2.getLeaReason());
             assertEquals(l3.getLeaManagerComment(), res2.getLeaManagerComment());

             LeaveDetails res3 = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leaveDetails/4")).getBody().as(LeaveDetails.class);

    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
    final String s10 = "2019-03-20";
    final Date s33 = sdf3.parse(s10);
    final String s111 = "2019-03-21";
    final Date e33 = sdf3.parse(s111);
    final String s12 = "2019-02-05";
    final Date l33 = sdf3.parse(s12);
        
    LeaveDetails l4 = new LeaveDetails(4, 2000, 2, s33, e33, LeaveType.PL, LeaveStatus.DENIED, "Function", l33, "Not");
    assertEquals(l4.getLeaId(), res3.getLeaId());
     assertEquals(l4.getLeaEmpId(), res3.getLeaEmpId());
      assertEquals(l4.getLeaNumberOfDays(), res3.getLeaNumberOfDays());
         assertEquals(l4.getLeaLeaveType(), res3.getLeaLeaveType());
          assertEquals(l4.getLeaStatus(), res3.getLeaStatus());
           assertEquals(l4.getLeaReason(), res3.getLeaReason());
             assertEquals(l4.getLeaManagerComment(), res3.getLeaManagerComment());

                          LeaveDetails res4 = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leaveDetails/5")).getBody().as(LeaveDetails.class);

    SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy-MM-dd");
    final String s13 = "2019-03-20";
    final Date s44 = sdf4.parse(s13);
    final String s14 = "2019-03-21";
    final Date e44 = sdf4.parse(s14);
    final String s15 = "2019-02-05";
    final Date l44 = sdf4.parse(s15);
        
    LeaveDetails l5 = new LeaveDetails(5, 5000, 11, s44, e44, LeaveType.EL, LeaveStatus.APPROVED, "Personal", l44, "fdg");
    assertEquals(l5.getLeaId(), res4.getLeaId());
     assertEquals(l5.getLeaEmpId(), res4.getLeaEmpId());
      assertEquals(l5.getLeaNumberOfDays(), res4.getLeaNumberOfDays());
         assertEquals(l5.getLeaLeaveType(), res4.getLeaLeaveType());
          assertEquals(l5.getLeaStatus(), res4.getLeaStatus());
           assertEquals(l5.getLeaReason(), res4.getLeaReason());
             assertEquals(l5.getLeaManagerComment(), res4.getLeaManagerComment());


    }

      @Test
    public void testApproveDeny() throws AssertionError, URISyntaxException {
        String res1=given().accept(ContentType.JSON).contentType("application/json").body("{\"leaId\":\"34\",\"leaManagerComment\":\"Enjoy\"}").
        when().post(CommonUtil.getURI("/api/leaveDetails/approveDeny/1000/YES")).getBody().asString();
        assertEquals("Leave Approved Sucessfully...", res1);

        String res2=given().accept(ContentType.JSON).contentType("application/json").body("{\"leaId\":\"34\",\"leaManagerComment\":\"Enjoy\"}").
        when().post(CommonUtil.getURI("/api/leaveDetails/approveDeny/2000/YES")).getBody().asString();
        assertEquals("You are unauthorised to approve the leave", res2);
    }
    @Test
    public void testApplyLeave() throws AssertionError, URISyntaxException {

        
     String res1=given().accept(ContentType.JSON).contentType("application/json").body("{\"leaNumberOfDays\":\"1\",\"leaStartDate\":\"2019-12-09\",\"leaEndDate\":\"2019-12-08\",\"leaLeaveType\":\"EL\",\"leaReason\":\"sick\"}").
        when().post(CommonUtil.getURI("/api/leaveDetails/applyleave/3000")).getBody().asString();
    
     assertEquals("Enter Correct No. of Days As.... 0", res1);

     String res2=given().accept(ContentType.JSON).contentType("application/json").body("{\"leaStartDate\":\"2019-12-09\",\"leaEndDate\":\"2019-12-07\",\"leaLeaveType\":\"EL\",\"leaNumberOfDays\":\"0\",\"leaReason\":\"sick\"}").
        when().post(CommonUtil.getURI("/api/leaveDetails/applyleave/3000")).getBody().asString();
    
     assertEquals("End date must be greater than Start date... ", res2);

     String res3=given().accept(ContentType.JSON).contentType("application/json").body("{\"leaStartDate\":\"2019-03-09\",\"leaEndDate\":\"2019-03-09\",\"leaLeaveType\":\"EL\",\"leaNumberOfDays\":\"1\",\"leaReason\":\"sick\"}").
        when().post(CommonUtil.getURI("/api/leaveDetails/applyleave/3000")).getBody().asString();
    
     assertEquals("StartDate cannot be saturday...", res3);

    String res4=given().accept(ContentType.JSON).contentType("application/json").body("{\"leaStartDate\":\"2019-03-10\",\"leaEndDate\":\"2019-03-10\",\"leaLeaveType\":\"EL\",\"leaNumberOfDays\":\"1\",\"leaReason\":\"sick\"}").
        when().post(CommonUtil.getURI("/api/leaveDetails/applyleave/3000")).getBody().asString();
    
     assertEquals("StartDate cannot be sunday...", res4);

     String res5=given().accept(ContentType.JSON).contentType("application/json").body("{\"leaStartDate\":\"2019-03-07\",\"leaEndDate\":\"2019-03-07\",\"leaLeaveType\":\"EL\",\"leaNumberOfDays\":\"1\",\"leaReason\":\"sick\"}").
        when().post(CommonUtil.getURI("/api/leaveDetails/applyleave/3000")).getBody().asString();
    
     assertEquals("Already applied on given date....", res5);

    String res6=given().accept(ContentType.JSON).contentType("application/json").body("{\"leaStartDate\":\"2019-02-28\",\"leaEndDate\":\"2019-02-28\",\"leaLeaveType\":\"EL\",\"leaNumberOfDays\":\"1\",\"leaReason\":\"sick\"}").
        when().post(CommonUtil.getURI("/api/leaveDetails/applyleave/3000")).getBody().asString();
    
     assertEquals("Start date is less than current date", res6);

      String res7=given().accept(ContentType.JSON).contentType("application/json").body("{\"leaStartDate\":\"2019-04-30\",\"leaEndDate\":\"2019-05-28\",\"leaLeaveType\":\"EL\",\"leaNumberOfDays\":\"1\",\"leaReason\":\"sick\"}").
        when().post(CommonUtil.getURI("/api/leaveDetails/applyleave/2000")).getBody().asString();
    
     assertEquals("Insufficient leave balance.. ", res7);

    }
}