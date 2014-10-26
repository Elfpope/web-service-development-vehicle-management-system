package wsd.vms;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Trip implements Serializable {
	private static final long serialVersionUID = 1L;
	@XmlElement(name = "id")
	private int id;
	@XmlElement(name = "regoNumber")
	private String regoNumber;
	@XmlElement(name = "driverId")
	private int driverId;
	@XmlElement(name = "driverName")
	private String driverName;
	@XmlElement(name = "startDate")
	private String startDate;
	@XmlElement(name = "startTime")
	private String startTime;
	@XmlElement(name = "endDate")
	private String endDate;
	@XmlElement(name = "endTime")
	private String endTime;
	@XmlElement(name = "description")
	private String description;
	@XmlElement(name = "kilometres")
	private double kilometres;
	@XmlElement(name = "deleted")
	private boolean deleted;
	@XmlElement(name = "deletedById")
	private String deletedById;

	
	public Trip() {	}
		
	public Trip(String regoNumber, int driverId, String driverName,
			String startDate, String endDate, String startTime, String endTime,
			String description, double kilometres, String deletedById) {
		super();
		this.regoNumber = regoNumber;
		this.driverId = driverId;
		this.driverName = driverName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
		this.kilometres = kilometres;
	}

	public String getRegoNumber() {
		return regoNumber;
	}

	public void setRegoNumber(String regoNumber) {
		this.regoNumber = regoNumber;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getKilometres() {
		return kilometres;
	}

	public void setKilometres(double kilometres) {
		this.kilometres = kilometres;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getDeletedById() {
		return deletedById;
	}

	public void setDeletedById(int deletedById) {
		
		this.deletedById = Integer.toString(deletedById);
	}
	public int getId() {
		
		return id;
	}
public void setId(int id) {
		
		this.id = id;
	}

	public void setStartDateTime(String dateTime) {
		String[] splitDateTime = dateTime.split(" ");
		startDate = splitDateTime[0];
		startTime = splitDateTime[1];
	}
	
	public void setEndDateTime(String dateTime) {
		String[] splitDateTime = dateTime.split(" ");
		endDate = splitDateTime[0];
		endTime = splitDateTime[1];	
	}
}
