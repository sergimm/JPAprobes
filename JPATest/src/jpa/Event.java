package jpa;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the event database table.
 * 
 */
@Entity
@NamedQuery(name="Event.findAll", query="SELECT e FROM Event e")
@Table(name="infogroup2eagenda.event")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String description;

	private Timestamp enddate;

	private Timestamp initdate;

	private String location;

	private String name;

	private String picture;

	//bi-directional many-to-one association to CategoryEvent
	@OneToMany(mappedBy="event")
	private List<CategoryEvent> categoryEvents;

	//bi-directional many-to-one association to Comment
	@OneToMany(mappedBy="event")
	private List<Comment> comments;

	//bi-directional many-to-one association to Company
	@ManyToOne
	private Company company;

	//bi-directional many-to-one association to Superadministrator
	@ManyToOne
	private Superadministrator superadministrator;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	//bi-directional many-to-one association to EventKeyword
	@OneToMany(mappedBy="event")
	private List<EventKeyword> eventKeywords;

	//bi-directional many-to-one association to Orderhistory
	@OneToMany(mappedBy="event")
	private List<Orderhistory> orderhistories;

	//bi-directional many-to-one association to Ratting
	@OneToMany(mappedBy="event")
	private List<Ratting> rattings;

	public Event() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Timestamp enddate) {
		this.enddate = enddate;
	}

	public Timestamp getInitdate() {
		return this.initdate;
	}

	public void setInitdate(Timestamp initdate) {
		this.initdate = initdate;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return this.picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public List<CategoryEvent> getCategoryEvents() {
		return this.categoryEvents;
	}

	public void setCategoryEvents(List<CategoryEvent> categoryEvents) {
		this.categoryEvents = categoryEvents;
	}

	public CategoryEvent addCategoryEvent(CategoryEvent categoryEvent) {
		getCategoryEvents().add(categoryEvent);
		categoryEvent.setEvent(this);

		return categoryEvent;
	}

	public CategoryEvent removeCategoryEvent(CategoryEvent categoryEvent) {
		getCategoryEvents().remove(categoryEvent);
		categoryEvent.setEvent(null);

		return categoryEvent;
	}

	public List<Comment> getComments() {
		return this.comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment addComment(Comment comment) {
		getComments().add(comment);
		comment.setEvent(this);

		return comment;
	}

	public Comment removeComment(Comment comment) {
		getComments().remove(comment);
		comment.setEvent(null);

		return comment;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Superadministrator getSuperadministrator() {
		return this.superadministrator;
	}

	public void setSuperadministrator(Superadministrator superadministrator) {
		this.superadministrator = superadministrator;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<EventKeyword> getEventKeywords() {
		return this.eventKeywords;
	}

	public void setEventKeywords(List<EventKeyword> eventKeywords) {
		this.eventKeywords = eventKeywords;
	}

	public EventKeyword addEventKeyword(EventKeyword eventKeyword) {
		getEventKeywords().add(eventKeyword);
		eventKeyword.setEvent(this);

		return eventKeyword;
	}

	public EventKeyword removeEventKeyword(EventKeyword eventKeyword) {
		getEventKeywords().remove(eventKeyword);
		eventKeyword.setEvent(null);

		return eventKeyword;
	}

	public List<Orderhistory> getOrderhistories() {
		return this.orderhistories;
	}

	public void setOrderhistories(List<Orderhistory> orderhistories) {
		this.orderhistories = orderhistories;
	}

	public Orderhistory addOrderhistory(Orderhistory orderhistory) {
		getOrderhistories().add(orderhistory);
		orderhistory.setEvent(this);

		return orderhistory;
	}

	public Orderhistory removeOrderhistory(Orderhistory orderhistory) {
		getOrderhistories().remove(orderhistory);
		orderhistory.setEvent(null);

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
		ratting.setEvent(this);

		return ratting;
	}

	public Ratting removeRatting(Ratting ratting) {
		getRattings().remove(ratting);
		ratting.setEvent(null);

		return ratting;
	}
	
	@Override
	public int hashCode() {
		int hash = 1;
		hash= hash*17+id;
		hash=hash*31+description.hashCode();
		hash=hash*5+name.hashCode();
		hash = hash * 13 + ((enddate == null) ? 0 : enddate.hashCode());
		return hash;
	}
	 
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;	
	if (!(obj instanceof Event)){
		return false;
	}
	Event nuevo= (Event)obj;
	if ((nuevo.getName().equals(this.getName()))){
		return(	(nuevo.getInitdate().equals(this.getInitdate())) && (nuevo.getEnddate().equals(this.getEnddate())));
	}else{
		return false;
	}
		
	}

}