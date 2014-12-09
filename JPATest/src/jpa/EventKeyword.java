package jpa;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the event_keywords database table.
 * 
 */
@Entity
@Table(name="infogroup2eagenda.event_keywords")
public class EventKeyword implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	//bi-directional many-to-one association to Event
	@ManyToOne
	private Event event;

	//bi-directional many-to-one association to Keyword
	@ManyToOne
	private Keyword keyword;

	public EventKeyword() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Keyword getKeyword() {
		return this.keyword;
	}

	public void setKeyword(Keyword keyword) {
		this.keyword = keyword;
	}
	
	@Override
	public int hashCode() {
		int hash = 1;
		hash= hash*31+id;
		hash = hash * 17 + ((keyword == null) ? 0 : keyword.hashCode());
		hash = hash * 13 + ((event == null) ? 0 : event.hashCode());
		return hash;
	}
	 
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj == this)
			return true;	
	if (!(obj instanceof EventKeyword)){
		return false;
	}
	EventKeyword nueva= (EventKeyword)obj;
	return ((nueva.getEvent().getId().equals(this.getEvent().getId()))&& 
			(nueva.getKeyword().getId().equals(this.getKeyword().getId())));
		
	}

}