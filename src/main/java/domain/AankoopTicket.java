package domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AankoopTicket {
	@Email
	private String email;
	@Min(1)
	@Max(25)
	private int aantalTickets;
	@NotNull
	private int voetbalCode1;
	@NotNull
	private int voetbalCode2;
	
	public AankoopTicket() {}
	public AankoopTicket(@Email String email, @Min(1) @Max(25) int aantalTickets, @NotNull int voetbalCode1,
			@NotNull int voetbalCode2) {
		this.setEmail(email);
		this.setAantalTickets(aantalTickets);
		setVoetbalCode1(voetbalCode1);
		setVoetbalCode2(voetbalCode2);
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAantalTickets() {
		return aantalTickets;
	}
	public void setAantalTickets(int aantalTickets) {
		this.aantalTickets = aantalTickets;
	}
	public int getVoetbalCode1() {
		return voetbalCode1;
	}
	public void setVoetbalCode1(int voetbalCode1) {
		this.voetbalCode1 = voetbalCode1;
	}
	public int getVoetbalCode2() {
		return voetbalCode2;
	}
	public void setVoetbalCode2(int voetbalCode2) {
		this.voetbalCode2 = voetbalCode2;
	}
	
}
