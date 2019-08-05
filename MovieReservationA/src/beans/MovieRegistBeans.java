package beans;

import java.util.Date;

public class MovieRegistBeans {
	private String[] theaterIds;
	private String movieName;
	private String movieDescription;
	private int movieTime;
	private Date startDate;
	private Date endDate;
	private int[] theaterNumbers;
	private String movieAddress;
	private String thumbnail;
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String[] getTheaterIds() {
		return theaterIds;
	}
	public void setTheaterIds(String[] theaterIds) {
		this.theaterIds = theaterIds;
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
	public int getMovieTime() {
		return movieTime;
	}
	public void setMovieTime(int movieTime) {
		this.movieTime = movieTime;
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
	public int[] getTheaterNumbers() {
		return theaterNumbers;
	}
	public void setTheaterNumbers(int[] theaterNumbers) {
		this.theaterNumbers = theaterNumbers;
	}
	
	public String getMovieAddress() {
		return movieAddress;
	}
	public void setMovieAddress(String movieAddress) {
		this.movieAddress = movieAddress;
	}
	
}
