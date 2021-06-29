/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentmanager.JavaClasses;

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

    public Schedule(){
    }
    
    public Schedule(List<DayOfWeek> days, LocalTime startTime, LocalTime endTime) {
        this.days = days;
        this.startTime = startTime;
        this.endTime = endTime;
    }
    
    public Schedule(List<DayOfWeek> days, String startHour, String startMinute, String startAMPM, 
                    String endHour, String endMinute, String endAMPM)
    {
        this.days = days;
        
        DateTimeFormatter format = DateTimeFormatter.ofPattern("KK:mm:a");
        this.startTime = LocalTime.parse(startHour + ":" + startMinute + ":" + startAMPM, format); 
        this.endTime = LocalTime.parse(endHour + ":" + endMinute + ":" + endAMPM, format);
    }

    public List<DayOfWeek> getDays() {
        return days;
    }

    public void setDays(List<DayOfWeek> days) {
        this.days = days;
    }

    public String getStartTime() {
        return startTime.format(DateTimeFormatter.ofPattern("hh:mm:ss"));
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime.format(DateTimeFormatter.ofPattern("hh:mm:ss"));
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
        List<DayOfWeek> days = Arrays.asList(DayOfWeek.TUESDAY);
        Schedule schedule = new Schedule(days, String.valueOf(11), 
                    String.valueOf(11),  
                    "AM",
                    String.valueOf(11),
                    String.valueOf(12),
                    "AM");
        
        System.out.println(schedule.toString());
        System.out.println(schedule.getEndTime());
    }
}
