package beans;

import java.io.Serializable;

public class UserReservationBeans implements Serializable {
	//予約コード
	private String reservationCode;
	//予約詳細コード
	private String reservationDetailsCode;
	//映画コード
	private String movieCode;
	//映画名
	private String movieName;
	//ユーザーコード
	private String userCode;
	//上映コード
	private String showCode;
	//上映日時
	private String showDate;
	//シアターコード
	private String theaterCode;
	//座席番号
	private String seatNumber;
	//金額
	private int fee;

	public String getReservationCode() {
		return reservationCode;
	}
	public void setReservationCode(String reservationCode) {
		this.reservationCode = reservationCode;
	}
	public String getReservationDetailsCode() {
		return reservationDetailsCode;
	}
	public void setReservationDetailsCode(String reservationDetailsCode) {
		this.reservationDetailsCode = reservationDetailsCode;
	}
	public String getMovieCode() {
		return movieCode;
	}
	public void setMovieCode(String movieCode) {
		this.movieCode = movieCode;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getShowCode() {
		return showCode;
	}
	public void setShowCode(String showCode) {
		this.showCode = showCode;
	}
	public String getShowDate() {
		return showDate;
	}
	public void setShowDate(String showDate) {
		this.showDate = showDate;
	}
	public String getTheaterCode() {
		return theaterCode;
	}
	public void setTheaterCode(String theaterCode) {
		this.theaterCode = theaterCode;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}





}
