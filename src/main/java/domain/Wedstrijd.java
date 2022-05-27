package domain;
//Een wedstrijd

import service.StadiumDao;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Locale;
@Entity
public class Wedstrijd {
    @Id
    @Column(name = "id", nullable = false)
    private String id; //unieke sleutel

    private String[] landen; //2 landen van de wedstrijd
    
    private LocalDateTime date;

//    @OneToOne
//    private WedstrijdTicket wedstrijdTicket;

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
        return String.format("%d %s",date.getDayOfMonth(),date.getMonth().toString().toLowerCase());
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
