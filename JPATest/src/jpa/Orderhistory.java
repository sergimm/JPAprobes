package jpa;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the orderhistory database table.
 * 
 */
@Entity
@Table(name="infogroup2eagenda.orderhistory")
public class Orderhistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String comment;

	private Timestamp date;

	//bi-directional many-to-one association to Event
	@ManyToOne
	private Event event;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public Orderhistory() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
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
		hash=hash*31+comment.hashCode();
		hash=hash*13+date.hashCode();
		hash = hash * 7 + ((event == null) ? 0 : event.hashCode());
		hash = hash * 5 + ((user == null) ? 0 : user.hashCode());
		return hash;
	}
	 
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;	
	if (!(obj instanceof Orderhistory)){
		return false;
	}
	Orderhistory nueva= (Orderhistory)obj;
	if ((nueva.getDate().equals(this.getDate()))){
		return ((nueva.getUser().equals(this.getUser())) && (nueva.getEvent().equals(this.getEvent())));
	}else{
		return false;
	}
		
	}


}