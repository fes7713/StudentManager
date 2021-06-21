/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanager;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author fes77
 */
public class Schedule {
    private List<DayOfWeek> days;
    LocalTime startTime;
    LocalTime endTime;
//    DayOfWeek[] days = { 
//    DayOfWeek.Sunday, 
//    DayOfWeek.Monday, 
//    DayOfWeek.Tuesday, 
//    DayOfWeek.Wednesday, 
//    DayOfWeek.Thursday, 
//    DayOfWeek.Friday, 
//    DayOfWeek.Saturday };

    public Schedule(List<DayOfWeek> days, LocalTime startTime, LocalTime endTime) {
        this.days = days;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public List<DayOfWeek> getDays() {
        return days;
    }

    public void setDays(List<DayOfWeek> days) {
        this.days = days;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Schedule{" + "days=" + days + ", startTime=" + startTime.format(DateTimeFormatter.ofPattern("KK:mm:ss:a")) + 
                ", endTime=" + endTime.format(DateTimeFormatter.ofPattern("KK:mm:ss:a")) + '}';
    }
    
    
    public static void main(String[] args)
    {
        DateTimeFormatter csvFormat = DateTimeFormatter.ofPattern("KK:mm:a");

        String time2 = "07:30:PM"; //○;

        LocalTime  d1 = LocalTime.parse(time2, csvFormat);
        LocalTime  d2 = LocalTime.parse(time2, csvFormat);
 
        System.out.println(d2.format(DateTimeFormatter.ofPattern("HH:mm")));
        
        DateTimeFormatter format = DateTimeFormatter.ofPattern("KK:mm:a");

        Schedule schedule = new Schedule(
                new ArrayList<>(Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY)),
                LocalTime.parse("10:20:AM", format),
                LocalTime.parse("11:50:AM", format)
        );
        
        System.out.println(schedule);

    }
}
