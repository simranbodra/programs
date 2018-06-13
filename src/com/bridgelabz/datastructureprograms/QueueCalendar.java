package com.bridgelabz.datastructureprograms;

import com.bridgelabz.utils.Utility;

public class QueueCalendar {

	public static void main(String[] args) {
		if(Utility.validateYear(args[1]) && Utility.validateMonth(args[0])) {
			int year = Integer.parseInt(args[1]);
			int month = Integer.parseInt(args[0]);
			int weekDay = Utility.getWeekDay(month, year);
			Utility.printCalenderQueue(weekDay, month, year);
		}
		else
			System.out.println("Invalid Input");
	}

}
