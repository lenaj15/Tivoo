
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Filter {


	private Map <Object, ArrayList<CalendarEvent>> filterByKeyword(ArrayList <CalendarEvent> lists, String word){
		Map <Object, ArrayList<CalendarEvent>> eventMap = new HashMap <Object, ArrayList<CalendarEvent>> ();
		ArrayList<CalendarEvent> wordFiltered = new ArrayList<CalendarEvent>();
		for (CalendarEvent e: lists){

			if (e.myTitle.contains(word))  //right now the title is public; make a getter method in future?
				wordFiltered.add(e);

		}
		eventMap.put(word, wordFiltered);
		return eventMap;
	}
	
	
	//The map key will be the starting time of the event
	private Map <Object, ArrayList<CalendarEvent>> filterByDates(ArrayList <CalendarEvent> lists, Date start, Date end){
		Map <Object, ArrayList<CalendarEvent>> eventMap = new HashMap <Object, ArrayList<CalendarEvent>> ();
		
		
		for (CalendarEvent e: lists){
			Date myTime = e.myStartTime;
			if (myTime.getTime()>= start.getTime() && e.myEndTime.getTime() <= end.getTime()){
					if (!eventMap.containsKey(myTime)){
						ArrayList<CalendarEvent> dateFiltered = new ArrayList<CalendarEvent>();
						eventMap.put(myTime, dateFiltered);
					}
					ArrayList<CalendarEvent> dateFiltered = eventMap.get(myTime);
					dateFiltered.add(e);
					eventMap.put(myTime, dateFiltered);
			}
		}
		
		return eventMap;
	}
	
	/* just testing to see if I could make it more flexible by taking multiple keywords; don't know if this is necessary
	private Map <Object, ArrayList<CalendarEvent>> filterByKeyword(ArrayList <CalendarEvent> lists, ArrayList<String> wordList){
		Map <Object, ArrayList<CalendarEvent>> eventMap = new HashMap <Object, ArrayList<CalendarEvent>> ();
		ArrayList<CalendarEvent> wordFiltered = new ArrayList<CalendarEvent>();
		for (CalendarEvent e: lists){
			for (String s : wordList){
				if (e.myTitle.equals(s))
					wordFiltered.add(e);
			}
		}
		eventMap.put(wordList, wordFiltered);
		return eventMap;
	}
	*/
	
}
