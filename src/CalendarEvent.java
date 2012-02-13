import java.util.Date;


public class CalendarEvent {
	
	String myTitle;
	
	Date myStartTime;
	Date myEndTime;
	
	String mySummaries;

	public CalendarEvent(String title, Date start, Date end, String summaries){
		
		myTitle = title;
		myStartTime = start;
		myEndTime = end;
		mySummaries = summaries;
		
	}
	
	
}
