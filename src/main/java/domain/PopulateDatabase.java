package domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import service.StadiumDao;
import service.WedstrijdTicketDao;

import java.time.LocalDateTime;

public class PopulateDatabase implements CommandLineRunner {
    @Autowired
    private StadiumDao stadiumDao;
    @Autowired
    private WedstrijdTicketDao wedStrijdTicketDao;
    @Override
    public void run(String... args) throws Exception {
        Stadium s1 = new Stadium("Al Bayt Stadium");
        Stadium s2 = new Stadium("Al Thumama Stadium");


        stadiumDao.insert(s1);
        stadiumDao.insert(s2);

        wedStrijdTicketDao.insert(new WedstrijdTicket(s1,new Wedstrijd("1", new String[]{"België", "Canada"}, LocalDateTime.of(2022,9,20,20,30)), 35));
        wedStrijdTicketDao.insert(new WedstrijdTicket(s1,new Wedstrijd("2", new String[]{"Brazilië", "Zwitserland"},LocalDateTime.of(2022,9,27,18,00)), 21));
        wedStrijdTicketDao.insert(new WedstrijdTicket(s1,new Wedstrijd("3", new String[]{"Marroko", "Kroatië"},LocalDateTime.of(2022,9 ,28, 15, 00)), 5));
        wedStrijdTicketDao.insert(new WedstrijdTicket(s2,new Wedstrijd("4", new String[]{"Spanje", "Duitsland"},LocalDateTime.of(2022,9 , 28, 18,00)), 95));
        wedStrijdTicketDao.insert(new WedstrijdTicket(s2,new Wedstrijd("5", new String[]{"Frankrijk", "Denemarken"},LocalDateTime.of(2022,9 , 29, 15,00)), 45));
        wedStrijdTicketDao.insert(new WedstrijdTicket(s1,new Wedstrijd("6", new String[]{"Argentinië", "Mexico"},LocalDateTime.of(2022,9 , 29, 18,00)), 10));
        wedStrijdTicketDao.insert(new WedstrijdTicket(s1,new Wedstrijd("7", new String[]{"Engeland", "USA"}, LocalDateTime.of(2022,9 ,30, 18,00)), 22));
        wedStrijdTicketDao.insert(new WedstrijdTicket(s2,new Wedstrijd("8", new String[]{"Nederland", "Qatar"}, LocalDateTime.of(2022,9 ,30, 21,00)), 16));


    }
}
