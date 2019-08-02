package beans;

import java.io.Serializable;

public class ReservationListBeans implements Serializable {
	private String reservation_code; //予約番号
	private String name; //名前
	private String movieName; //映画名
	private String theater; //シアターの番号
	private String showDate; //上映開始時刻
	private String feeType; //券種
	
	
	public String getReservation_code() {
		return reservation_code;
	}
	public void setReservation_code(String reservation_code) {
		this.reservation_code = reservation_code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getTheater() {
		return theater;
	}
	public void setTheater(String theater) {
		this.theater = theater;
	}
	public String getShowDate() {
		return showDate;
	}
	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}
	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}	
}
