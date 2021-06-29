package studentmanager.JavaClasses;

import java.time.Year;
import studentmanager.Repository.MySQL;

public class Semester {
    private Season season;
    private Year year;

    public Semester()
    {
        
    }
    
    public Semester(Season season, Year year) {
        this.season = season;
        this.year = year;
    }
    
    public Semester(Season season, int year) {
        this.season = season;
        this.year = Year.of(year);
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }
    
    public void setSeason(String season) {
        this.season = Season.valueOf(season.toUpperCase());
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }
    
    public void setYear(int year) {
        this.year = Year.of(year);
    }

    @Override
    public String toString() {
        return season + " " + year;
    }
    
    public void set(MySQL attr, Object value)
    {
        switch(attr)
        {
            case YEAR: setYear(Year.of((int)value)); return;
            case SEASON : setSeason(Season.valueOf(((String) value).toUpperCase())); return;
        }
    }
}