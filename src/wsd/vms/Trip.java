package wsd.vms;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/** java bean for trip data */
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

	/** creates new blank trip */
	public Trip() {
	}

	/** creates new trip */
	/**
	 * @param regoNumber Registration Number of vehicle
	 * @param driverId Driver ID who took the trip
	 * @param driverName Name of the driver
	 * @param startDate Starting date of trip
	 * @param endDate End date of  trip
	 * @param startTime Starting time of trip
	 * @param endTime End time of trip
	 * @param description Brief description of trip purpose
	 * @param kilometres Accumulated kilometres travelled
	 */
	public Trip(String regoNumber, int driverId, String driverName,
			String startDate, String endDate, String startTime, String endTime,
			String description, double kilometres) {
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
		this.deleted = false;
	}

	/** returns the trip id */
	public int getId() {
		return id;
	}

	/** sets the trip id */
	public void setId(int id) {
		this.id = id;
	}

	/** returns the registration number */
	public String getRegoNumber() {
		return regoNumber;
	}

	/** sets the registration number */
	public void setRegoNumber(String regoNumber) {
		this.regoNumber = regoNumber;
	}

	/** returns the driver ID */
	public int getDriverId() {
		return driverId;
	}

	/** sets the driver ID */
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	/** returns the driver name */
	public String getDriverName() {
		return driverName;
	}

	/** sets the driver name */
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	/** returns the start date */
	public String getStartDate() {
		return startDate;
	}

	/** sets the start date */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/** returns the end date */
	public String getEndDate() {
		return endDate;
	}

	/** sets the end date */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/** returns the start time */
	public String getStartTime() {
		return startTime;
	}

	/** sets the start time */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/** returns the end time */
	public String getEndTime() {
		return endTime;
	}

	/** sets the end time */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/** returns the description */
	public String getDescription() {
		return description;
	}

	/** sets the description */
	public void setDescription(String description) {
		this.description = description;
	}

	/** returns the kilometres travelled */
	public double getKilometres() {
		return kilometres;
	}

	/** sets the kilometres travelled */
	public void setKilometres(double kilometres) {
		this.kilometres = kilometres;
	}

	/** returns the deleted flag */
	public boolean isDeleted() {
		return deleted;
	}

	/** sets the deleted flag */
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	/** returns the driver ID who deleted the trip */
	public String getDeletedById() {
		return deletedById;
	}

	/** sets the driver ID who deleted the trip */
	public void setDeletedById(int deletedById) {
		this.deletedById = Integer.toString(deletedById);
	}

	/** sets the start date and time */
	public void setStartDateTime(String dateTime) {
		String[] splitDateTime = dateTime.split(" ");
		startDate = splitDateTime[0];
		startTime = splitDateTime[1];
	}

	/** sets the end date and time */
	public void setEndDateTime(String dateTime) {
		String[] splitDateTime = dateTime.split(" ");
		endDate = splitDateTime[0];
		endTime = splitDateTime[1];
	}
}
