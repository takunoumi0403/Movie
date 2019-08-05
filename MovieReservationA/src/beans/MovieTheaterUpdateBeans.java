package beans;

import java.util.Date;
import java.util.List;

public class MovieTheaterUpdateBeans {
	private String theaterNumber;
	private Date startDate;
	private Date endDate;
	private List<Date> showDate;
	public String getTheaterNumber() {
		return theaterNumber;
	}
	public void setTheaterNumber(String theaterNumber) {
		this.theaterNumber = theaterNumber;
	}
	public List<Date> getShowDate() {
		return showDate;
	}
	public void setShowDate(List<Date> showDate) {
		this.showDate = showDate;
	}
	public void pushShowDate(Date showDate) {
		this.showDate.add(showDate);
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
