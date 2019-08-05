package beans;

import java.io.Serializable;
import java.sql.Date;

public class ReservationListBeans implements Serializable {
	private int reservation_code;	//予約番号
	private int detail_number;		//予約詳細番号
	private String name; 			//名前
	private String movieName;		//映画名
	private String theater;			//シアターの番号
	private Date showDate;			//上映開始時刻
	private String feeType;			//券種
	
	
	public int getReservation_code() {
		return reservation_code;
	}
	public void setReservation_code(int reservation_code) {
		this.reservation_code = reservation_code;
	}
	public int getDetail_number() {
		return detail_number;
	}
	public void setDetail_number(int detail_number) {
		this.detail_number = detail_number;
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
	public Date getShowDate() {
		return showDate;
	}
	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}
	public String getFeeType() {
		return feeType;
	}
	public void setFeeType(String feeType) {
		this.feeType = feeType;
	}	
}
