package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import beans.MovieListBeans;
import beans.ReservationListBeans;
import dao.MasterReservationDao;

public class MasterMovieListModel {
	/**
	 * 映画一覧
	 * @return
	 */
	public List<MovieListBeans> getMovieList() {
		List<MovieListBeans> movieList = new ArrayList<MovieListBeans>();

		MasterReservationDao mResercationDao = new MasterReservationDao();
		try{
			///////////////////////////////////
			//DBの接続
			mResercationDao.connect();

			//////////////////////////////////
			//映画情報の取得
			movieList = mResercationDao.getMovieList();

		}catch(Exception e) {
			//エラー発生した場合にコンソールにログを出力する
			e.printStackTrace();
		}
		finally {
			//接続（コネクション）を閉じる
			if(mResercationDao!=null) {
				mResercationDao.close();
			}
		}
		return movieList;
	}
	/**
	 *
	 */
	public List<MovieListBeans> statusSet(List<MovieListBeans> movieList){
		Date date = new Date();
		for(int i=0;i<movieList.size();i++) {
			if(date.before(movieList.get(i).getMovieStart())) {
				movieList.get(i).setShowStatus("公開前");
			}else if(date.after(movieList.get(i).getMovieStart())&&date.before(movieList.get(i).getMovieFinish())) {
				movieList.get(i).setShowStatus("公開中");
			}else if(date.after(movieList.get(i).getMovieFinish())) {
				movieList.get(i).setShowStatus("公開終了");
			}else {
				movieList.get(i).setShowStatus("エラー");
			}

		}
		return movieList;

	}

	/**
	 * 名前検索 表示フラグ設定
	 */
	public List<MovieListBeans> searchList(String keyword,int Release,List<MovieListBeans> movieList){

		for(int i=0;i<movieList.size();i++) {
			//全表示
			if(Release==0) {
				if("".equals(keyword)||movieList.get(i).getMovieName().contains(keyword)) {
					movieList.get(i).setShowFlag(true);
				}else {
					movieList.get(i).setShowFlag(false);
				}
			//公開前
			}else if(Release==1) {
				if("公開前".equals(movieList.get(i).getShowStatus())) {
					if("".equals(keyword)||(movieList.get(i).getMovieName().contains(keyword))) {
						movieList.get(i).setShowFlag(true);
					}else {
						movieList.get(i).setShowFlag(false);
					}

				}else {
					movieList.get(i).setShowFlag(false);
				}
			//公開中
			}else if(Release==2) {
				if("公開中".equals(movieList.get(i).getShowStatus())) {
					if("".equals(keyword)||(movieList.get(i).getMovieName().contains(keyword))) {
						movieList.get(i).setShowFlag(true);
					}else {
						movieList.get(i).setShowFlag(false);
					}

				}else {
					movieList.get(i).setShowFlag(false);
				}
			//公開終了
			}else if(Release==3) {
				if("公開終了".equals(movieList.get(i).getShowStatus())) {
					if("".equals(keyword)||(movieList.get(i).getMovieName().contains(keyword))) {
						movieList.get(i).setShowFlag(true);
					}else {
						movieList.get(i).setShowFlag(false);
					}

				}else {
					movieList.get(i).setShowFlag(false);
				}
			}else {
				movieList.get(i).setShowFlag(false);
			}


		}
		return movieList;
	}


	/**
	 * 予約一覧
	 */
	public List<ReservationListBeans> getList(int number, String name){
		List<ReservationListBeans> reservationList = new ArrayList<ReservationListBeans>();

		MasterReservationDao mReservationDao = new MasterReservationDao();
		try{
			///////////////////////////////////
			//DBの接続
			mReservationDao.connect();

			///////////////////////////////////
			//予約情報の取得
			reservationList = mReservationDao.getList(number,name);

		}catch(Exception e) {
			//エラー発生した場合にコンソールにログを出力する
			e.printStackTrace();
		}
		finally {
			//接続（コネクション）を閉じる
			if(mReservationDao!=null) {
				mReservationDao.close();
			}
		}

		return reservationList;
	}


}
