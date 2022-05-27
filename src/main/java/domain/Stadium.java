package domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Stadium {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Stadium() {}
	
	public Stadium(String name) {
		this.setName(name);
	}

	@OneToMany(mappedBy = "stadium")
	private Collection<WedstrijdTicket> listWedstrijdTickets;

	public Collection<WedstrijdTicket> getListWedstrijdTickets() {
		return listWedstrijdTickets;
	}

	public void setListWedstrijdTickets(Collection<WedstrijdTicket> listWedstrijdTickets) {
		this.listWedstrijdTickets = listWedstrijdTickets;
	}

	@Override
	public String toString() {
		return "Stadium{" +
				"id=" + id +
				", name='" + name + '\'' +
				", listWedstrijdTickets=" + listWedstrijdTickets +
				'}';
	}
}
