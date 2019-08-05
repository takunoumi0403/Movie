package inter;

import java.util.Comparator;

import beans.TimesortBeans;

public class TSBeansComparator implements Comparator<TimesortBeans>{
	@Override
	public int compare(TimesortBeans TSB1,TimesortBeans TSB2){
		return TSB1.getTotalminute() < TSB2.getTotalminute() ? -1:1;
	}
}
