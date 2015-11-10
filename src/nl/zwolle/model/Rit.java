package nl.zwolle.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author reindert
 *
 * Een entiteit voor het vastleggen van mijn kilometerregistratie voor autoritten.
 */
@Entity
public class Rit {

	private Long id;
	private String omschrijving;
	private BigDecimal start;
	private BigDecimal end;
	private Boolean business;

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Long getId() {
	    return id;
	}
	
	
	public Rit(){}
	
	public void setId(Long id){
		this.id = id;
	}
	
	
	public String getOmschrijving() {
		return omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	public BigDecimal getStart() {
		return start;
	}

	public void setStart(BigDecimal start) {
		this.start = start;
	}

	public BigDecimal getEnd() {
		return end;
	}

	public void setEnd(BigDecimal end) {
		this.end = end;
	}

	public Boolean getBusiness() {
		return business;
	}

	public void setBusiness(Boolean business) {
		this.business = business;
	}
	
	@Override
	public String toString(){
		return this.omschrijving;
	}
}
