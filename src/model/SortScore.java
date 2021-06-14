package model;

import java.util.Comparator;

public class SortScore implements Comparator<Player>{

	@Override
	public int compare(Player o1, Player o2) {
		return (int) (o1.getScore()-o2.getScore());
	}

}
