package model;

import java.util.Comparator;

public class SortTime implements Comparator<Player>{

	@Override
	public int compare(Player o1, Player o2) {
		int x1 = (int) (o1.getPlayTime()/1000);
		int x2 = (int) (o2.getPlayTime()/1000);
		return x1-x2;
	}

}
