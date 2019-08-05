package controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import beans.MovieRegistBeans;
import beans.MovieTheaterRegistBeans;
import beans.TimesortBeans;
import inter.TSBeansComparator;


@WebServlet("/regist_check")
@MultipartConfig(location="/tmp", maxFileSize=1048576)
public class M04_MovieRegistrationCheckServlet extends HttpServlet{
	String errorMsg;
	final int sabun=30;
	static final String UPLOAD ="/Users/yoshinotakumi/Desktop/git/Movie/MovieReservationA/WebContent/uploaded/";
	static final String UPLOADED = "/Users/yoshinotakumi/Desktop/git/Movie/MovieReservationA/WebContent/uploadedComplete/";
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			 throws ServletException, IOException  {
		HttpSession session=request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//エラーメッセージ一覧
		List<String> errorMsgs=new ArrayList<String>();

		//映画情報Beans呼び出し
		MovieRegistBeans MRBeans=new MovieRegistBeans();


		//映画名取得
		MRBeans.setMovieName((request.getParameter("movie_name")));
		if(MRBeans.getMovieName().length()==0) {
			errorMsgs.add("映画の名前が入力されていません");
		}

		//映画説明文取得
		MRBeans.setMovieDescription((request.getParameter("movie_description")));
		if(MRBeans.getMovieDescription().length()==0) {
			errorMsgs.add("映画の説明文が入力されていません");
		}

		//映画上映時間取得、差分用、分+30分に変換
		int movieTimeHour=Integer.parseInt(request.getParameter("movie_time_hour"));
		int movieTimeMinute=Integer.parseInt(request.getParameter("movie_time_minute"));
		int time=movieTimeHour*60+movieTimeMinute;
		MRBeans.setMovieTime(time);
		int sabunTime=MRBeans.getMovieTime()+sabun;

		//映画開始日
		String startYear=request.getParameter("movie_time_startyear");
		String startMonth=request.getParameter("movie_time_startmonth");
		String startDay=request.getParameter("movie_time_startday");
		Date startDate=DateConnect(startYear,startMonth,startDay);
		MRBeans.setStartDate(startDate);
		if(startDate==null) {
			errorMsgs.add("映画開始日でエラーが起きました");
		}

		//映画終了日
		String endYear=request.getParameter("movie_time_endyear");
		String endMonth=request.getParameter("movie_time_endmonth");
		String endDay=request.getParameter("movie_time_endday");
		Date endDate=DateConnect(endYear,endMonth,endDay);
		MRBeans.setEndDate(endDate);
		if(endDate==null) {
			errorMsgs.add("映画終了日でエラーが起きました");
		}
		//開始日終了日比較
		if(startDate.after(endDate)) {
			errorMsgs.add("映画開始日が映画終了日よりも遅いです");
		}

		//シアター割り振りID取得
		String theaterId=request.getParameter("tID");
		MRBeans.setTheaterIds(theaterId.split(","));
		String[] tIds=MRBeans.getTheaterIds();
		ArrayList<Integer> theaterIds = new ArrayList<Integer>();
		for(int i=0;i<MRBeans.getTheaterIds().length;i++) {
			theaterIds.add(Integer.parseInt(tIds[i]));
		}

		//映画上映開始時間
		//Stringの一時格納配列生成
		String[] theaterStartHour;
		String[] theaterStartMinute;
		//シアター毎の上映時間Beans呼び出し

		List<MovieTheaterRegistBeans> MTRBeansList=new ArrayList<MovieTheaterRegistBeans>();

		for(int i=0;i<MRBeans.getTheaterIds().length;i++) {
			MovieTheaterRegistBeans MTRBeans= new MovieTheaterRegistBeans();
			//映画シアター番号取得
			MTRBeans.setTheaterNumber(request.getParameter("theater_number["+theaterIds.get(i)+"]"));
			//映画上映開始 時間取得 int変換
			theaterStartHour=request.getParameterValues("theater_start_hour["+theaterIds.get(i)+"]");
			theaterStartMinute=request.getParameterValues("theater_start_minute["+theaterIds.get(i)+"]");
			for(int j=0;j<theaterStartHour.length;j++) {
				MTRBeans.pushTheaterStartHour(Integer.parseInt(theaterStartHour[j]));
				MTRBeans.pushTheaterStartMinute(Integer.parseInt(theaterStartMinute[j]));
			}
			MTRBeansList.add(MTRBeans);
		}
		//シアター番号重複チェック用List
		List<Integer> check=new ArrayList<Integer>();
		for(int i=0;i<MTRBeansList.size();i++) {
			check.add(Integer.parseInt(MTRBeansList.get(i).getTheaterNumber()));
		}
		int count=0;
		//シアター番号重複チェック
		check : for(int i=0;i<check.size();i++) {
			for(int n=0;n<check.size();n++) {
				if(check.get(i)==check.get(n)) {
					count++;
				}
				if(count==2) {
					errorMsgs.add("シアター番号が重複しています。");
					break check;
				}
			}
			count=0;
		}
		//シアター毎の上映時間取得
		//
		List<TimesortBeans> TSBeansList=new ArrayList<TimesortBeans>();
		for(int i=0;i<MTRBeansList.size();i++) {

			for(int n=0;n<MTRBeansList.get(i).getTheaterStartHour().size();n++) {
				TimesortBeans TSBeans=new TimesortBeans();
				TSBeans.setHour(MTRBeansList.get(i).getTheaterStartHour().get(n));
				TSBeans.setMinute(MTRBeansList.get(i).getTheaterStartMinute().get(n));
				TSBeans.setTotalminute(TSBeans.getHour()*60+TSBeans.getMinute());
				TSBeans.setTheaterNumber(MTRBeansList.get(i).getTheaterNumber());

				TSBeansList.add(TSBeans);

			}
			//シアター毎の上映時間を昇順にソート
			Collections.sort(TSBeansList, new TSBeansComparator());
			List<Integer> changeHourList=new ArrayList<Integer>();
			List<Integer> changeMinuteList=new ArrayList<Integer>();
			for(int x=0;x<TSBeansList.size();x++) {

				changeHourList.add(TSBeansList.get(x).getHour());
				changeMinuteList.add(TSBeansList.get(x).getMinute());

			}
			MTRBeansList.get(i).setTheaterStartHour(changeHourList);
			MTRBeansList.get(i).setTheaterStartMinute(changeMinuteList);
			MTRBeansList.get(i).setTheaterNumber(TSBeansList.get(0).getTheaterNumber());
			//changeHourList.clear();
			//changeMinuteList.clear();
			if(SabunCheck(sabunTime,TSBeansList)==false) {
				errorMsgs.add("上映時間帯が上映時間+30分の間を開けるに従っていません");
				break;
			};
			TSBeansList.clear();
		}


		//HPアドレス取得
		MRBeans.setMovieAddress(HtmlUtil.nl2be(request.getParameter("movie_address")));

		Part part = request.getPart("thumbnail");

		if(this.getFileName(part).equals("")==false) {
			MRBeans.setThumbnail(HtmlUtil.nl2be(this.getFileName(part)));
			part.write(UPLOAD+MRBeans.getThumbnail());
			//サムネイル書き込み
			//part.write(getServletContext().getRealPath("uploaded") + "/" + MRBeans.getThumbnail());
		}
		if(MRBeans.getThumbnail()==null) {
			errorMsgs.add("サムネイルが入力されていません");
		}
		if(errorMsgs.size()==0) {
			session.setAttribute("MRBeans", MRBeans);
			session.setAttribute("MTRBeansList",MTRBeansList);
			RequestDispatcher dispatcher =
					request.getRequestDispatcher("WEB-INF/jsp/m04_movieRegistrationCheck.jsp");
			dispatcher.forward(request, response);
		}else {
			//エラーメッセージがある場合
			request.setAttribute("errorMsgs",errorMsgs);
			//一時保存ファイルからサムネイル削除
			File file=new File(UPLOAD+MRBeans.getThumbnail());
			file.delete();

			RequestDispatcher dispatcher =
					request.getRequestDispatcher("WEB-INF/jsp/m03_movieRegistration.jsp");
			dispatcher.forward(request, response);
		}
	}
	private String getFileName(Part part) {
        String name = null;
        for (String dispotion : part.getHeader("Content-Disposition").split(";")) {
            if (dispotion.trim().startsWith("filename")) {
                name = dispotion.substring(dispotion.indexOf("=") + 1).replace("\"", "").trim();
                name = name.substring(name.lastIndexOf("\\") + 1);
                break;
            }
        }
        return name;
    }

	private Date DateConnect(String year,String month,String day ) {
		String connect=year+"/"+month+"/"+day;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
		Date formatDate;
		try {
			formatDate = (Date) sdf.parse(connect);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			formatDate=null;
			e.printStackTrace();
		}
		return formatDate;
	}

	private boolean SabunCheck(int sabunTime,List<TimesortBeans> TSBeansList) {
		for(int i=0;i<TSBeansList.size();i++) {
			//最後の上映時刻かどうか
			if(i==TSBeansList.size()-1){
				//最後の上映時刻+上映時間が24時を超える場合
				if(TSBeansList.get(i).getTotalminute()+sabunTime>1440) {
					if((TSBeansList.get(i).getTotalminute()-1440)+TSBeansList.get(0).getTotalminute()<sabunTime) {
						return false;
					}
				}
			}else if(TSBeansList.size()==1){
				return true;
			}else {
				if(TSBeansList.get(i+1).getTotalminute()-TSBeansList.get(i).getTotalminute()<sabunTime) {
					return false;
				}
			}
		}
		return true;
	}
}
