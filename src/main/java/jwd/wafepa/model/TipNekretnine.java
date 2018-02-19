package jwd.wafepa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class TipNekretnine {

	@Id
	@GeneratedValue
	private Long id;
	private String naziv;
	
	@JsonManagedReference
	@OneToMany (mappedBy="tip",cascade=CascadeType.REMOVE)
	private List<Nekretnina> nekretnine = new ArrayList<Nekretnina>();
	

	public TipNekretnine() {
		super();
	}

	public TipNekretnine(Long id, String naziv, List<Nekretnina> nekretnine) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.nekretnine = nekretnine;
	}
	

	public TipNekretnine(Long id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
	}

	public TipNekretnine(String naziv, List<Nekretnina> nekretnine) {
		super();
		this.naziv = naziv;
		this.nekretnine = nekretnine;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Nekretnina> getNekretnine() {
		return nekretnine;
	}

	public void setNekretnine(List<Nekretnina> nekretnine) {
		this.nekretnine = nekretnine;
	}

	@Override
	public String toString() {
		return "TipNekretnine [id=" + id + ", naziv=" + naziv + ", nekretnine=" + nekretnine + "]";
	}

	
	
	
	
}
