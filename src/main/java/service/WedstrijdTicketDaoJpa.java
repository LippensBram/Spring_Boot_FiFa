package service;

import domain.Wedstrijd;
import domain.WedstrijdTicket;

import javax.transaction.Transactional;
import java.util.List;

public class WedstrijdTicketDaoJpa extends GenericDaoJpa<WedstrijdTicket> implements WedstrijdTicketDao {

    public WedstrijdTicketDaoJpa() {
        super(WedstrijdTicket.class);
    }


}
