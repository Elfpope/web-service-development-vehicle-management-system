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
	private int startDate;
	@XmlElement(name = "startTime")
	private int startTime;
	@XmlElement(name = "endDate")
	private int endDate;
	@XmlElement(name = "endTime")
	private int endTime;
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
			int startDate, int endDate, int startTime, int endTime,
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

	public int getStartDate() {
		return startDate;
	}

	public void setStartDate(int startDate) {
		this.startDate = startDate;
	}

	public int getEndDate() {
		return endDate;
	}

	public void setEndDate(int endDate) {
		this.endDate = endDate;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
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
}
