package jpa;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the ratting database table.
 * 
 */
@Entity
@Table(name="infogroup2eagenda.ratting")
public class Ratting implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Integer ratting;

	//bi-directional many-to-one association to Event
	@ManyToOne
	private Event event;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public Ratting() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRatting() {
		return this.ratting;
	}

	public void setRatting(Integer ratting) {
		this.ratting = ratting;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public int hashCode() {
		int hash = 1;
		hash= hash*17+id;
		hash=hash*31+ratting.hashCode();
		hash = hash * 5 + ((event == null) ? 0 : event.hashCode());
		hash = hash * 13 + ((user == null) ? 0 : user.hashCode());
		return hash;
	}
	 
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;	
	if (!(obj instanceof Ratting)){
		return false;
	}
	Ratting nuevo= (Ratting)obj;
	if ((nuevo.getRatting().equals(this.getRatting()))){
		return ((nuevo.getEvent().equals(this.getEvent())) && (nuevo.getUser().equals(this.getUser())));
	}else{
		return false;
	}
		
	}

}