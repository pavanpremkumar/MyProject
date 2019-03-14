package com.hexaware.FTP113.integration.test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

import javax.management.RuntimeErrorException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil {
    public static final String host;
    public static final String port;
    public static final String webapp;
    public static final String uri_prefix;
    static {
        host = System.getProperty("service.host", "localhost");
        port = System.getProperty("service.port", "8080");
        webapp = System.getProperty("service.webapp", "FTP113");
        uri_prefix = "http://" + host + ":" + port + "/" + webapp;
    }
    public static URI getURI(String path) throws URISyntaxException {
        return new URI(uri_prefix + path);
    }
}

enum LeaveType {
  /**
  * LeaveType to store EL.
  */
  EL,

  /**
  * LeaveType to store PL.
  */
  PL,

  /**
  * LeaveType to store ML.
  */
  ML;

}

enum LeaveStatus {
  /**
  * LeaveStatus to store Approved.
  */
  APPROVED,

  /**
  * LeaveStatus to store Denied.
  */
  DENIED,

  /**
  * LeaveStatus to store Pending.
  */
  PENDING;

}


/**
 * LeaveDetails class to store employee's leave details.
 * @author hexware
 */
class LeaveDetails {

/**
   * leaId to store employee's leave id.
   * leaEmpId to store employee id.
   * leaNumberOfDays store leave days.
   * leaStartDate store employee's leave start date.
   * leaEndDate store employee's leave end date.
   * leaLeaveType store employee leave type.
   * leaStatus store employee leave status.
   * leaReason store employee leave reason.
   * leaAppliedOn store employee leave applied on.
   * leaManagerComment store employee manager comments.
   */
  private int leaId;
  private int leaEmpId;
  private int leaNumberOfDays;
  private Date leaStartDate;
  private Date leaEndDate;
  private LeaveType leaLeaveType;
  private LeaveStatus leaStatus;
  private String leaReason;
  private Date leaAppliedOn;
  private String leaManagerComment;

  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    } 
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    LeaveDetails lea = (LeaveDetails) obj;
        String lst1 = sdf.format(leaStartDate);
    String lst2 = sdf.format(lea.leaStartDate);

    String lend1 = sdf.format(leaEndDate);
    String lend2 = sdf.format(lea.leaEndDate);

    String lapp1 = sdf.format(leaAppliedOn);
    String lapp2 = sdf.format(lea.leaAppliedOn);

    if (Objects.equals(leaId, lea.leaId)
        && Objects.equals(leaEmpId, lea.leaEmpId)
        && Objects.equals(leaNumberOfDays, lea.leaNumberOfDays)
        && Objects.equals(lst1, lst2)
        && Objects.equals(lend1, lend2)
        && Objects.equals(leaLeaveType, lea.leaLeaveType)
        && Objects.equals(leaStatus, lea.leaStatus)
        && Objects.equals(leaReason, lea.leaReason)
        && Objects.equals(lapp1, lapp2)
        && Objects.equals(leaManagerComment, lea.leaManagerComment)) {
      return true;
    }
    return false;
  }
  @Override
  public final int hashCode() {
    return Objects.hash(leaId, leaEmpId, leaNumberOfDays, leaStartDate, leaEndDate, leaLeaveType,
                        leaStatus, leaReason, leaAppliedOn, leaManagerComment);
  }

  public String toString() {
      try {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(this);
      } catch(Exception e) {
        throw new RuntimeException(e);
      }
    }
 
  /**
   * Default Constructors for LeaveDetails.
   */
  public LeaveDetails() {

  }
  /**
   * @param argLeaId to initialize employee's leave id.
   * @param argLeaEmpId to initialize employee id.
   * @param argLeaNumberOfDays to initialize leave days.
   * @param argLeaStartDate to initialize leave start date.
   * @param argLeaEndDate to initialize leave end date.
   * @param argLeaLeaveType to initialize leave type.
   * @param argLeaStatus to initialize leave Status.
   * @param argLeaReason to initialize leave reason.
   * @param argLeaAppliedOn to initialize leave applied on.
   * @param argLeaManagerComment to initialize manager comments.
   */
  public LeaveDetails(final int argLeaId, final int argLeaEmpId, final int argLeaNumberOfDays,
                  final Date argLeaStartDate, final Date argLeaEndDate,
                  final LeaveType argLeaLeaveType, final LeaveStatus argLeaStatus, final String argLeaReason,
                  final Date argLeaAppliedOn, final String argLeaManagerComment) {
    this.leaId = argLeaId;
    this.leaEmpId = argLeaEmpId;
    this.leaNumberOfDays = argLeaNumberOfDays;
    this.leaStartDate = argLeaStartDate;
    this.leaEndDate = argLeaEndDate;
    this.leaLeaveType = argLeaLeaveType;
    this.leaStatus = argLeaStatus;
    this.leaReason = argLeaReason;
    this.leaAppliedOn = argLeaAppliedOn;
    this.leaManagerComment = argLeaManagerComment;
  }

/**
   * Gets the LeaId.
   * @return this Employee's leave id.
   */
  public final int getLeaId() {
    return leaId;
  }

  /**
   *
   * @param argLeaId to set employee leave id.
   */
  public final void setLeaId(final int argLeaId) {
    this.leaId = argLeaId;

  }

  /**
   * Gets the EmpId.
   * @return this Employee's ID.
   */
  public final int getLeaEmpId() {
    return leaEmpId;
  }

  /**
   *
   * @param argEmpId to set employee id.
   */
  public final void setLeaEmpId(final int argEmpId) {
    this.leaEmpId = argEmpId;

  }

  /**
   * Gets the LeaNumberOfDay.
   * @return this Employee's leave days.
   */
  public final int getLeaNumberOfDays() {
    return leaNumberOfDays;
  }

  /**
   *
   * @param argLeaNumberOfDays to set employee leave NumberOfDay.
   */
  public final void setLeaNumberOfDays(final int argLeaNumberOfDays) {
    this.leaNumberOfDays = argLeaNumberOfDays;
  }

  /**
   * Gets the LeaStartDate.
   * @return this Employee's Leave Start date.
   */
  public final Date getLeaStartDate() {
    return leaStartDate;
  }

  /**
   *
   * @param argLeaStartDate to set employee leave start date.
   */
  public final void setLeaStartDate(final Date argLeaStartDate) {
    this.leaStartDate = argLeaStartDate;
  }
  /**
   * Gets the LeaEndDate.
   * @return this Employee's Leave End date.
   */
  public final Date getLeaEndDate() {
    return leaEndDate;
  }

  /**
   *
   * @param argLeaEndDate to set employee leave End date.
   */
  public final void setLeaEndDate(final Date argLeaEndDate) {
    this.leaEndDate = argLeaEndDate;
  }

  /**
   * Gets the LeaLeaveType.
   * @return this Employee's leave Type.
   */
  public final LeaveType getLeaLeaveType() {
    return leaLeaveType;
  }

  /**
   *
   * @param argLeaLeaveType to set employee leave Type.
   */
  public final void setLeaLeaveType(final LeaveType argLeaLeaveType) {
    this.leaLeaveType = argLeaLeaveType;
  }

  /**
   * Gets the LeaLeaveStatus.
   * @return this Employee's leave Status.
   */
  public final LeaveStatus getLeaStatus() {
    return leaStatus;
  }

  /**
   * @param argLeaStatus to set employee leave Status.
    */
  public final void setLeaStatus(final LeaveStatus argLeaStatus) {
    this.leaStatus = argLeaStatus;
  }

  /**
   * Gets the LeaReason.
   * @return this Employee's leave reason.
   */
  public final String getLeaReason() {
    return leaReason;
  }

  /**
   *
   * @param argLeaReason to set employee leave reason.
   */
  public final void setLeaReason(final String argLeaReason) {
    this.leaReason = argLeaReason;
  }

  /**
   * Gets the LeaAppliedOn.
   * @return this Employee's Leave Applied On.
   */
  public final Date getLeaAppliedOn() {
    return leaAppliedOn;
  }

  /**
   *
   * @param argLeaAppliedOn to set employee leave applied on.
   */
  public final void setLeaAppliedOn(final Date argLeaAppliedOn) {
    this.leaAppliedOn = argLeaAppliedOn;
  }

  /**
   * Gets the LeaManagerComment.
   * @return this Employee's leave Manager Comments.
   */
  public final String getLeaManagerComment() {
    return leaManagerComment;
  }

  /**
   *
   * @param argLeaManagerComment to set employee leave manager comment.
   */
  public final void setLeaManagerComment(final String argLeaManagerComment) {
    this.leaManagerComment = argLeaManagerComment;
  }

}
class Employee {


  /**
   * empId to store employee id.
   * empFullName store employee name.
     empEmail store employee email.
     empMobileNo store employee number.
     empDateOfJoining store employee DOJ.
     empDepartment store employee MgrId.
     empAvailLeavBal store employee available leave balance.
   */
  private int empId;
  private String empFullName;
  private String empEmail;
  private String empMobileNo;
  private Date empDateOfJoining;
  private String empDepartment;
  private int empMgrId;
  private int empAvailLeavBal;

  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Employee emp = (Employee) obj;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String d1 = sdf.format(emp.empDateOfJoining); 
    String d2 = sdf.format(empDateOfJoining);
    if (Objects.equals(empId, emp.empId)
        && Objects.equals(empFullName, emp.empFullName)
        && Objects.equals(empEmail, emp.empEmail)
        && Objects.equals(empMobileNo, emp.empMobileNo)
        && Objects.equals(d1, d2)
        && Objects.equals(empDepartment, emp.empDepartment)
        && Objects.equals(empMgrId, emp.empMgrId)
        && Objects.equals(empAvailLeavBal, emp.empAvailLeavBal)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(empId, empFullName, empEmail, empMobileNo, empDateOfJoining,
                        empDepartment, empMgrId, empAvailLeavBal);
  }

  /**
   * Default Constructor.
   */
  public Employee() {

  }

  /**
   * @param argEmpId to initialize employee id.
   * @param argEmpFullName to initialize employee fullname.
   * @param argEmpEmail to initialize employee Email.
   * @param argEmpMobileNo to initialize employee MobileNo.
   * @param argEmpDateOfJoining to initialize employee DOJ.
   * @param argEmpDepartment to initialize employee dept.
   * @param argEmpMgrId to initialize employee manager Id.
   * @param argEmpAvailLeavBal to initialize employee AvailLeaveBal.
   */
  public Employee(final int argEmpId, final String argEmpFullName, final String argEmpEmail,
                  final String argEmpMobileNo, final Date argEmpDateOfJoining,
                  final String argEmpDepartment, final int argEmpMgrId,
                  final int argEmpAvailLeavBal) {
    this.empId = argEmpId;
    this.empFullName = argEmpFullName;
    this.empEmail = argEmpEmail;
    this.empMobileNo = argEmpMobileNo;
    this.empDateOfJoining = argEmpDateOfJoining;
    this.empDepartment = argEmpDepartment;
    this.empMgrId = argEmpMgrId;
    this.empAvailLeavBal = argEmpAvailLeavBal;
  }

  /**
   * Gets the EmployeeId.
   * @return this Employee's ID.
   */
  public final int getEmpId() {
    return empId;
  }

  /**
   *
   * @param argEmpId to set employee id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;

  }

  /**
   * Gets the EmployeeName.
   * @return this Employee's Name.
   */
  public final String getEmpFullName() {
    return empFullName;
  }
  /**
   *
   * @param argEmpFullName to set employee name.
   */

  public final void setEmpFullName(final String argEmpFullName) {
    this.empFullName = argEmpFullName;
  }
  /**
   * Gets the EmployeeEmail.
   * @return this Employee's Email.
   */
  public final String getEmpEmail() {
    return empEmail;
  }
   /**
   *
   * @param argEmpEmail to set employee name.
   */

  public final void setEmpEmail(final String argEmpEmail) {
    this.empEmail = argEmpEmail;
  }
  /**
   * Gets the EmployeeMobileNo.
   * @return this Employee's MobileNo.
   */
  public final String getEmpMobileNo() {
    return empMobileNo;
  }
  /**
   *
   * @param argEmpMobileNo to set employee MobileNo.
   */

  public final void setEmpMobileNo(final String argEmpMobileNo) {
    this.empMobileNo = argEmpMobileNo;
  }
  /**
   * Gets the EmployeeDOJ.
   * @return this Employee's DOJ.
   */
  public final Date getEmpDateOfJoining() {
    return empDateOfJoining;
  }
  /**
   *
   * @param doj to set employee DOJ.
   */

  public final void setEmpDateOfJoining(final Date doj) {
    this.empDateOfJoining = doj;
  }
  /**
   * Gets the EmployeeDepartment.
   * @return this Employee's Department.
   */
  public final String getEmpDepartment() {
    return empDepartment;
  }
  /**
   *
   * @param argEmpDepartment to set employee Department.
   */

  public final void setEmpDepartment(final String argEmpDepartment) {
    this.empDepartment = argEmpDepartment;
  }
  /**
   * Gets the Employee Manager ID.
   * @return this Employee's Manager ID.
   */
  public final int getEmpMgrId() {
    return empMgrId;
  }

  /**
   *
   * @param argEmpMgrId to set employee manager id.
   */
  public final void setEmpMgrId(final int argEmpMgrId) {
    this.empMgrId = argEmpMgrId;
  }

  /**
   * Gets the Employee Available leave balance.
   * @return this Employee's Available leave balance.
   */
  public final int getEmpAvailLeavBal() {
    return empAvailLeavBal;
  }

  /**
   *
   * @param argEmpAvailLeavBal to set employee Available leave balance .
   */
  public final void setEmpAvailLeavBal(final int argEmpAvailLeavBal) {
    this.empAvailLeavBal = argEmpAvailLeavBal;
  }


    public String toString() {
      try {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(this);
      } catch(Exception e) {
        throw new RuntimeException(e);
      }
    }
}
