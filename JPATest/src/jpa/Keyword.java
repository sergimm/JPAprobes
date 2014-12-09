package jpa;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the keyword database table.
 * 
 */
@Entity
@Table(name="infogroup2eagenda.keyword")
public class Keyword implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String name;

	//bi-directional many-to-one association to EventKeyword
	@OneToMany(mappedBy="keyword")
	private List<EventKeyword> eventKeywords;

	public Keyword() {
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

	public List<EventKeyword> getEventKeywords() {
		return this.eventKeywords;
	}

	public void setEventKeywords(List<EventKeyword> eventKeywords) {
		this.eventKeywords = eventKeywords;
	}

	public EventKeyword addEventKeyword(EventKeyword eventKeyword) {
		getEventKeywords().add(eventKeyword);
		eventKeyword.setKeyword(this);

		return eventKeyword;
	}

	public EventKeyword removeEventKeyword(EventKeyword eventKeyword) {
		getEventKeywords().remove(eventKeyword);
		eventKeyword.setKeyword(null);

		return eventKeyword;
	}
	
	@Override
	public int hashCode() {
		int hash = 1;
		hash= hash*17+id;
		hash=hash*31+name.hashCode();
		hash = hash * 13 + ((eventKeywords == null) ? 0 : eventKeywords.hashCode());
		return hash;
	}
	 
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;	
	if (!(obj instanceof Keyword)){
		return false;
	}
	Keyword nueva= (Keyword)obj;
	return ((nueva.getName().equals(this.getName())));
		
	}


}