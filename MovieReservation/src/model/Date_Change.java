package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Date_Change {
	public String StringChange(Date date) {
		String str;
		try {
			
			str=new SimpleDateFormat("yyyy-MM-dd").format(date);
			
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			 str=null;
			e.printStackTrace();
		}
		return str; 
	}
	
	public String[] StringUpdateSet(Date date) {
		String str;
		String[] strs= {"0","0","0"};
		try {
			str=new SimpleDateFormat("yyyy-MM-dd").format(date);
			strs=str.split("-",0);
		}catch(Exception e) {
			str=null;
			e.printStackTrace();
		}
		return strs;
	}
}
