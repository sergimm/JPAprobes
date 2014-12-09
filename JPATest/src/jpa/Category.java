package jpa;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@Table(name="infogroup2eagenda.category")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String description;

	private String name;

	//bi-directional many-to-one association to Superadministrator
	@ManyToOne
	@JoinColumn(name="superadministrator_id")
	private Superadministrator superadministrator;

	//bi-directional many-to-one association to CategoryEvent
	@OneToMany(mappedBy="category")
	private List<CategoryEvent> categoryEvents;

	public Category() {
	}
	
	public Category(String name, String description, Superadministrator admin) {		
		this.name = name;
		this.description = description;
		this.superadministrator=admin;
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

	public List<CategoryEvent> getCategoryEvents() {
		return this.categoryEvents;
	}

	public void setCategoryEvents(List<CategoryEvent> categoryEvents) {
		this.categoryEvents = categoryEvents;
	}

	public CategoryEvent addCategoryEvent(CategoryEvent categoryEvent) {
		//prueba
		FacesContext context = FacesContext.getCurrentInstance();
		
		//inicial
		getCategoryEvents().add(categoryEvent);
		categoryEvent.setCategory(this);

		return categoryEvent;
	}

	public CategoryEvent removeCategoryEvent(CategoryEvent categoryEvent) {
		getCategoryEvents().remove(categoryEvent);
		categoryEvent.setCategory(null);

		return categoryEvent;
	}
	
	@Override
	public int hashCode() {
		int hash = 1;
		hash= hash*17+id;
		hash=hash*31+name.hashCode();
		hash=hash*13+description.hashCode();
		return hash;
	}
	 
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;	
	if (!(obj instanceof Category)){
		return false;
	}
	Category nueva= (Category)obj;
	return ((nueva.getName().equals(this.getName()))&& (nueva.getDescription().equals(this.getDescription())));
		
	}

}