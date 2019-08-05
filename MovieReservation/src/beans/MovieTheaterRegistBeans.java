package beans;

import java.util.ArrayList;
import java.util.List;

public class MovieTheaterRegistBeans {
	private String theaterNumber;
	private List<Integer> theaterStartHour=new ArrayList<Integer>();
	private List<Integer> theaterStartMinute=new ArrayList<Integer>();
	private List<Integer> sortHour=new ArrayList<Integer>();
	private int seatSpace;
	public String getTheaterNumber() {
		return theaterNumber;
	}
	public List<Integer> getSortHour() {
		return sortHour;
	}
	public void setSortHour(List<Integer> sortHour) {
		this.sortHour = sortHour;
	}
	public void setTheaterNumber(String theaterNumber) {
		this.theaterNumber = theaterNumber;
	}
	public List<Integer> getTheaterStartHour() {
		return theaterStartHour;
	}
	public void pushTheaterStartHour(int i) {
		this.theaterStartHour.add(i);
	}
	public void setTheaterStartHour(List<Integer> theaterStartHour) {
		this.theaterStartHour = theaterStartHour;
	}
	public List<Integer> getTheaterStartMinute() {
		return theaterStartMinute;
	}
	public void pushTheaterStartMinute(int i) {
		this.theaterStartMinute.add(i);
	}
	public void setTheaterStartMinute(List<Integer> theaterStartMinute) {
		this.theaterStartMinute = theaterStartMinute;
	}
	public int getSeatSpace() {
		return seatSpace;
	}
	public void setSeatSpace(int seatSpace) {
		this.seatSpace = seatSpace;
	}
	
}