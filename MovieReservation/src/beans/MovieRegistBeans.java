package beans;

import java.sql.Timestamp;

import javax.servlet.http.Part;

public class MovieRegistBeans {
	private Timestamp insertDate;
	private String movieName;
	private String movieDescription;
	//日時はdatetime型
	private String movieTime;
	private String movieStartDay;
	private String movieEndDay;
	private String theaterNumber;
	private String movieStartTime;
	private String movieAddress;
	//サムネイルPart型 サーバの指定のファイルパス？
	private Part thubnail;
	public Timestamp getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Timestamp insertDate) {
		this.insertDate = insertDate;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieDescription() {
		return movieDescription;
	}
	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}
	public String getMovieTime() {
		return movieTime;
	}
	public void setMovieTime(String movieTime) {
		this.movieTime = movieTime;
	}
	public String getMovieStartDay() {
		return movieStartDay;
	}
	public void setMovieStartDay(String movieStartDay) {
		this.movieStartDay = movieStartDay;
	}
	public String getMovieEndDay() {
		return movieEndDay;
	}
	public void setMovieEndDay(String movieEndDay) {
		this.movieEndDay = movieEndDay;
	}
	public String getTheaterNumber() {
		return theaterNumber;
	}
	public void setTheaterNumber(String theaterNumber) {
		this.theaterNumber = theaterNumber;
	}
	public String getMovieStartTime() {
		return movieStartTime;
	}
	public void setMovieStartTime(String movieStartTime) {
		this.movieStartTime = movieStartTime;
	}
	public String getMovieAddress() {
		return movieAddress;
	}
	public void setMovieAddress(String movieAddress) {
		this.movieAddress = movieAddress;
	}
	public Part getThubnail() {
		return thubnail;
	}
	public void setThubnail(Part thubnail) {
		this.thubnail = thubnail;
	}
	
	
}
