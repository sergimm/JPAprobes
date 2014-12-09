package jpa;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the category_event database table.
 * 
 */
@Entity
@Table(name="infogroup2eagenda.category_event")
public class CategoryEvent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	//bi-directional many-to-one association to Category
	@ManyToOne
	private Category category;

	//bi-directional many-to-one association to Event
	@ManyToOne
	private Event event;

	public CategoryEvent() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	@Override
	public int hashCode() {
		int hash = 1;
		hash= hash*31+id;
		hash = hash * 13 + ((category == null) ? 0 : category.hashCode());
		hash = hash * 13 + ((event == null) ? 0 : event.hashCode());
		return hash;
	}
	 
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;	
	if (!(obj instanceof CategoryEvent)){
		return false;
	}
	CategoryEvent nueva= (CategoryEvent)obj;
	return ((nueva.getCategory().getId().equals(this.getCategory().getId()))&& 
			(nueva.getEvent().getId().equals(this.getEvent().getId())));
		
	}

}