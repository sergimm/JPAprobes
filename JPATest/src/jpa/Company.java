package jpa;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the company database table.
 * 
 */
@Entity
@Table(name="infogroup2eagenda.company")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String name;

	//bi-directional many-to-one association to Superadministrator
	@ManyToOne
	private Superadministrator superadministrator;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="company")
	private List<Event> events;

	public Company() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Superadministrator getSuperadministrator() {
		return this.superadministrator;
	}

	public void setSuperadministrator(Superadministrator superadministrator) {
		this.superadministrator = superadministrator;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setCompany(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setCompany(null);

		return event;
	}
	
	@Override
	public int hashCode() {
		int hash = 1;
		hash= hash*17+id;
		hash=hash*31+name.hashCode();
		hash = hash * 13 + ((superadministrator == null) ? 0 : superadministrator.hashCode());
		return hash;
	}
	 
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;	
	if (!(obj instanceof Company)){
		return false;
	}
	Company nueva= (Company)obj;
	return ((nueva.getName().equals(this.getName())));
		
	}


}