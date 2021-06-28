package studentmanager;

import java.time.Year;

public class Semester {
    private Season season;
    private Year year;

    public Semester(Season season, Year year) {
        this.season = season;
        this.year = year;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return season + " " + year;
    }
}

enum Season{
    SPRING,
    SUMMER,
    FALL;
    
    @Override
    public String toString() {
        switch(this) {
            case SPRING:    return "Spring";
            case SUMMER:    return "Summer";
            case FALL:      return "Fall";
            default: throw new IllegalArgumentException();
    }
  }
}