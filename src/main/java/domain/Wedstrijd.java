package domain;
//Een wedstrijd

import java.time.LocalDateTime;

public class Wedstrijd {

    private String id; //unieke sleutel

    private String[] landen; //2 landen van de wedstrijd
    
    private LocalDateTime date;

    public Wedstrijd() {
    }

    public Wedstrijd(String id, String[] landen, LocalDateTime date) {
        this.id = id;
        this.landen = landen;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String[] getLanden() {
        return landen;
    }

    public String getDag() {
        return date.getDayOfMonth() + date.getMonth().toString();
    }

    public int getUur() {
        return date.getHour();
    }

    public int getMinute(){return date.getMinute();}
    
    @Override
    public String toString()
    {
        return String.format("%s vs %s op %d-11", landen[0], landen[1], getDag()); 
    }
}
