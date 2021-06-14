package model;

import java.util.Comparator;

public class SortDate implements Comparator<Player>{

	@Override
	public int compare(Player o1, Player o2) {
		return o1.getGameDate().compareTo(o2.getGameDate());
	}

}
