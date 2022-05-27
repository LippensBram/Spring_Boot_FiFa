package domain;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

//Aantal tickets beschikbaar per wedstrijd
@Entity
public class WedstrijdTicket {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@OneToOne(optional = false, cascade = CascadeType.ALL)
    private Wedstrijd wedstrijd;

    public void setWedstrijd(Wedstrijd wedstrijd) {
        this.wedstrijd = wedstrijd;
    }

    private int tickets; //aantal tickets beschikbaar
    
    public WedstrijdTicket(Stadium stadium,Wedstrijd wedstrijd, int tickets) {
        this.stadium = stadium;
        this.wedstrijd = wedstrijd;
        this.tickets = tickets;
    }

    public WedstrijdTicket() {

    }

    public int getTickets() {
        return tickets;
    }
    public void setTickets(int aantal){this.tickets=aantal;}
    
    public Wedstrijd getWedstrijd() {
        return wedstrijd;
    }
    
    //We willen 'aantal' tickets kopen
    public int ticketsKopen(int aantal) {
        if (aantal <= 0) {
            return -1;
        }
        
        //Nog voldoende tickets
        if (tickets >= aantal) {
            tickets -= aantal;
            return aantal;
        }

        //Niet meer voldoende tickets
        int gekocht = tickets;
        tickets = 0;
        return gekocht;
    }

    public boolean uitverkocht() {
        return tickets == 0;
    }

    @ManyToOne(optional = false)
    private Stadium stadium;

    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }
}
