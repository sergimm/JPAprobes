package jpa;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the superadministrator database table.
 * 
 */
@Entity
@Table(name="infogroup2eagenda.superadministrator")
public class Superadministrator implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String email;

	private String name;

	private String nif;

	private String password;

	//bi-directional many-to-one association to Category
	@OneToMany(mappedBy="superadministrator")
	private List<Category> categories;

	//bi-directional many-to-one association to Company
	@OneToMany(mappedBy="superadministrator")
	private List<Company> companies;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="superadministrator")
	private List<Event> events;

	public Superadministrator() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public List<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Category addCategory(Category category) {
		getCategories().add(category);
		category.setSuperadministrator(this);

		return category;
	}

	public Category removeCategory(Category category) {
		getCategories().remove(category);
		category.setSuperadministrator(null);

		return category;
	}

	public List<Company> getCompanies() {
		return this.companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public Company addCompany(Company company) {
		getCompanies().add(company);
		company.setSuperadministrator(this);

		return company;
	}

	public Company removeCompany(Company company) {
		getCompanies().remove(company);
		company.setSuperadministrator(null);

		return company;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setSuperadministrator(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setSuperadministrator(null);

		return event;
	}
	
	@Override
	public int hashCode() {
		int hash = 1;
		hash= hash*17+id;
		hash=hash*31+email.hashCode();
		hash=hash*5+name.hashCode();
		hash=hash*7+nif.hashCode();
		hash=hash*21+password.hashCode();
		hash = hash * 13 + ((categories == null) ? 0 : categories.hashCode());
		return hash;
	}
	 
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;	
	if (!(obj instanceof Superadministrator)){
		return false;
	}
	Superadministrator nuevo= (Superadministrator)obj;
	return ((nuevo.getNif().equals(this.getNif())));
		
	}

}