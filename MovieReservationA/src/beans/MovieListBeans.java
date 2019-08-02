package beans;

import java.io.Serializable;
import java.util.Date;

public class MovieListBeans implements Serializable {
	
	private int movieCode; //映画コード
	private String movieName; //映画名
	private Date movieStart; //上映開始日
	private Date movieFinish; //上映終了日
	private boolean showFlag;
	private String showStatus;
	public int getMovieCode() {
		return movieCode;
	}
	public void setMovieCode(int movieCode) {
		this.movieCode = movieCode;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public Date getMovieStart() {
		return movieStart;
	}
	public void setMovieStart(Date movieStart) {
		this.movieStart = movieStart;
	}
	public Date getMovieFinish() {
		return movieFinish;
	}
	public void setMovieFinish(Date movieFinish) {
		this.movieFinish = movieFinish;
	}
	public boolean getShowFlag() {
		return showFlag;
	}
	public void setShowFlag(boolean showFlag) {
		this.showFlag = showFlag;
	}
	public String getShowStatus() {
		return showStatus;
	}
	public void setShowStatus(String showStatus) {
		this.showStatus = showStatus;
	}
}
