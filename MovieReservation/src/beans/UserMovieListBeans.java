package beans;

import java.io.Serializable;

public class UserMovieListBeans implements Serializable {
	private String movieCode;
	private String movieName;
	private String movieTime;
	private String movieAddress;
	private String movieThumbnail;
	private String movieDescription;
	private String showCode;
	private String theaterCode;
	private String seatSpace;

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
	public String getMovieTime() {
		return movieTime;
	}
	public void setMovieTime(String movieTime) {
		this.movieTime = movieTime;
	}
	public String getMovieAddress() {
		return movieAddress;
	}
	public void setMovieAddress(String movieAddress) {
		this.movieAddress = movieAddress;
	}
	public String getMovieThumbnail() {
		return movieThumbnail;
	}
	public void setMovieThumbnail(String movieThumbnail) {
		this.movieThumbnail = movieThumbnail;
	}
	public String getMovieDescription() {
		return movieDescription;
	}
	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}
	public String getShowCode() {
		return showCode;
	}
	public void setShowCode(String showCode) {
		this.showCode = showCode;
	}
	public String getTheaterCode() {
		return theaterCode;
	}
	public void setTheaterCode(String theaterCode) {
		this.theaterCode = theaterCode;
	}
	public String getSeatSpace() {
		return seatSpace;
	}
	public void setSeatSpace(String seatSpace) {
		this.seatSpace = seatSpace;
	}


}
