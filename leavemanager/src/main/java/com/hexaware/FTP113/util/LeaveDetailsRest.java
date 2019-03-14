package com.hexaware.FTP113.util;

import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.hexaware.FTP113.model.LeaveDetails;
/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/leaveDetails")
public class LeaveDetailsRest {

  /**
   * Returns a specific leave details.
   * @param id the leaid of the employee
   * @return the leave details
   */
  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails listById(@PathParam("id") final int id) {
    final LeaveDetails l3 = LeaveDetails.listById(id);
    if (l3 == null) {
      throw new NotFoundException("No such Leave ID: " + id);
    }
    return l3;
  }
    /**
   * Returns a specific leave details.
   * @param id the leaid of the employee.
   * @return the leave pendings.
   */
  @GET
  @Path("/listPending/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] listPending(@PathParam("id") final int id) {
    final LeaveDetails[] l2 = LeaveDetails.listPending(id);
    if (l2 == null) {
      throw new NotFoundException("No such Leave ID: " + id);
    }
    return l2;
  }
      /**
   * Returns a specific leave details.
   * @param id the leaid of the employee.
   * @return the leave history.
   */
  @GET
  @Path("/leaveHistory/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails[] listAll(@PathParam("id") final int id) {
    final LeaveDetails[] l1 = LeaveDetails.listAll(id);
    if (l1 == null) {
      throw new NotFoundException("No such Leave ID: " + id);
    }
    return l1;
  }
        /**
   * Returns a specific leave details.
   * @param empId the leaid of the employee.
   * @param e input leave details.
   * @return the apply leave status.
   * @throws ParseException  for handling date issue.
   */
  @POST
  @Path("/applyleave/{empId}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final String applyLeave(@PathParam("empId") final int empId, final LeaveDetails e)throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String sDate = sdf.format(e.getLeaStartDate());
    String eDate = sdf.format(e.getLeaEndDate());
    String s = LeaveDetails.applyLeave(empId, sDate, eDate, e.getLeaNumberOfDays(),
                                       e.getLeaLeaveType(), e.getLeaReason());
    return s;
  }
        /**
   * Returns a specific leave details.
   * @param empMgrId the leaid of the employee.
   * @param e input leave details.
   * @param status for approval status.
   * @return the apply leave status.
   * @throws ParseException  for handling date issue.
   */
  @POST
  @Path("/approveDeny/{empMgrId}/{status}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public final String approveDeny(@PathParam("empMgrId") final int empMgrId,
          @PathParam("status") final String status, final LeaveDetails e) throws ParseException {
    String s = LeaveDetails.approveDeny(e.getLeaId(), empMgrId, status,
                    e.getLeaManagerComment());
    return s;
  }
}
