package jpa;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
@Table(name="infogroup2eagenda.user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String address;

	private String email;

	private String name;

	private String nif;

	private String password;

	private String preferedlanguage;

	private String surname;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="user")
	private List<Comment> comments;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="user")
	private List<Event> events;

	//bi-directional many-to-one association to Orderhistory
	@OneToMany(mappedBy="user")
	private List<Orderhistory> orderhistories;

	//bi-directional many-to-one association to Ratting
	@OneToMany(mappedBy="user")
	private List<Ratting> rattings;

	public User() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNif() {
		return this.nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPreferedlanguage() {
		return this.preferedlanguage;
	}

	public void setPreferedlanguage(String preferedlanguage) {
		this.preferedlanguage = preferedlanguage;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setUser(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setUser(null);

		return comment;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setUser(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setUser(null);

		return event;
	}

	public List<Orderhistory> getOrderhistories() {
		return this.orderhistories;
	}

	public void setOrderhistories(List<Orderhistory> orderhistories) {
		this.orderhistories = orderhistories;
	}

	public Orderhistory addOrderhistory(Orderhistory orderhistory) {
		getOrderhistories().add(orderhistory);
		orderhistory.setUser(this);

		return orderhistory;
	}

	public Orderhistory removeOrderhistory(Orderhistory orderhistory) {
		getOrderhistories().remove(orderhistory);
		orderhistory.setUser(null);

		return orderhistory;
	}

	public List<Ratting> getRattings() {
		return this.rattings;
	}

	public void setRattings(List<Ratting> rattings) {
		this.rattings = rattings;
	}

	public Ratting addRatting(Ratting ratting) {
		getRattings().add(ratting);
		ratting.setUser(this);

		return ratting;
	}

	public Ratting removeRatting(Ratting ratting) {
		getRattings().remove(ratting);
		ratting.setUser(null);

		return ratting;
	}
	
	@Override
	public int hashCode() {
		int hash = 1;
		hash= hash*17+id;
		hash=hash*31+email.hashCode();
		hash=hash*5+name.hashCode();
		hash=hash*7+nif.hashCode();
		hash=hash*21+password.hashCode();
		hash = hash * 13 + ((rattings == null) ? 0 : rattings.hashCode());
		return hash;
	}
	 
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;	
	if (!(obj instanceof User)){
		return false;
	}
	User nuevo= (User)obj;
	return ((nuevo.getNif().equals(this.getNif())));
		
	}

}