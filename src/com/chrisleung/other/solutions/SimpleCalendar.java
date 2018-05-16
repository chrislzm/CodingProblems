package com.chrisleung.other.solutions;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class SimpleCalendar {
    
    // SimpleCalendar
    // addEvent - 
    //     Params: Unix Time Start, Unix End Time, String Name
    //     Return: Event Id
    // deleteEvent
    //    Params: Event ID
    //    
    // getEventsForDay
    //    Param: Date
    //    Returns: All Event Id for the day

    // Objects
    //    Event
    //    Hash Table - <Date, Hash Table of Event Objects<Id, Event Object>>
    //    Hash Table - <Event Id, Event Object>
    
    Map<Long,Map<Integer,Event>> dateEventMap = new HashMap<Long,Map<Integer,Event>>();
    Map<Integer,Event> idEvent = new HashMap<>();
    
    int nextEventId = 0;
    
    class Event {
        final long startTime;
        final long endTime;
        final int id;
        final String name;

        Event(long s, long e, String n) {
            startTime = s;
            endTime = e;
            name = n;
            id = nextEventId++;
        }
    }
    
    int addEvent(long startTime, long endTime, String name) {
        Event event = new Event(startTime,endTime,name);
        // 1. Put event in its day
        Date startDate = new Date((long)startTime*1000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
        sdf.setTimeZone(TimeZone.getDefault()); 
        String formattedDate = sdf.format(startDate);
        LocalDate localDate = LocalDate.parse(formattedDate, DateTimeFormatter.ofPattern("yyyy-MM-dd") );
        long unixDate = localDate.atStartOfDay(ZoneId.systemDefault()).toEpochSecond();
        Map<Integer,Event> dateIdEventMap = dateEventMap.get(unixDate);
        if(dateIdEventMap == null) {
            dateIdEventMap = new HashMap<>();
            dateEventMap.put(unixDate,dateIdEventMap);
        }
        dateIdEventMap.put(event.id,event);
        // 2. Put in the general id - event table
        idEvent.put(event.id,event);
        return event.id;
    }
    

    public static void main(String args[] ) throws Exception {
        SimpleCalendar calendar = new SimpleCalendar();
        calendar.addEvent(0,1,"Test Event");
    }
}
