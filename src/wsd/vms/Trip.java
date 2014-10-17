package wsd.vms;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class Trip implements Serializable {
	private String regoNumber;
	private String driverId;
	private String driverName;
	private Date stratDate;
	private Date endDate;
	private Time startTime;
	private Time endTime;
	private String descripton;
	private double kilometres;
	private boolean deleted = false;
	private int deletedById;
	
	public Trip() {	}
		
	public Trip(String regoNumber, String driverId, String driverName,
			Date stratDate, Date endDate, Time startTime, Time endTime,
			String descripton, double kilometres, int deletedById) {
		super();
		this.regoNumber = regoNumber;
		this.driverId = driverId;
		this.driverName = driverName;
		this.stratDate = stratDate;
		this.endDate = endDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.descripton = descripton;
		this.kilometres = kilometres;
		this.deletedById = deletedById;
	}

	public String getRegoNumber() {
		return regoNumber;
	}

	public void setRegoNumber(String regoNumber) {
		this.regoNumber = regoNumber;
	}

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public Date getStratDate() {
		return stratDate;
	}

	public void setStratDate(Date stratDate) {
		this.stratDate = stratDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public String getDescripton() {
		return descripton;
	}

	public void setDescripton(String descripton) {
		this.descripton = descripton;
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

	public int getDeletedById() {
		return deletedById;
	}

	public void setDeletedById(int deletedById) {
		this.deletedById = deletedById;
	}

}
