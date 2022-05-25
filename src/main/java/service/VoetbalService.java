package service;

import java.util.List;

import domain.Stadium;
import domain.WedstrijdTicket;

public interface VoetbalService {

	public List<Stadium> getStadiumList();

	public List<WedstrijdTicket> getWedstrijdenByStadium(Stadium stadium);

	public WedstrijdTicket getWedstrijd(String id);

	public int ticketsBestellen(String id, int teBestellen);

}