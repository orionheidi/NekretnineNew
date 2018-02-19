package jwd.wafepa.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Nekretnina {

	@Id
	@GeneratedValue
	private Long id;
	private int povrsina;
	private int cena;
	private String adresa;
	
	@JsonBackReference
	@ManyToOne (fetch=FetchType.LAZY)
	private TipNekretnine tip;

	
	public Nekretnina() {
		super();
	}



	public Nekretnina(int povrsina, int cena, String adresa, TipNekretnine tip) {
		super();
		this.povrsina = povrsina;
		this.cena = cena;
		this.adresa = adresa;
		this.tip = tip;
	}



	public Nekretnina(Long id, int povrsina, int cena, String adresa, TipNekretnine tip) {
		super();
		this.id = id;
		this.povrsina = povrsina;
		this.cena = cena;
		this.adresa = adresa;
		this.tip = tip;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public int getPovrsina() {
		return povrsina;
	}



	public void setPovrsina(int povrsina) {
		this.povrsina = povrsina;
	}



	public int getCena() {
		return cena;
	}



	public void setCena(int cena) {
		this.cena = cena;
	}



	public String getAdresa() {
		return adresa;
	}



	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}



	public TipNekretnine getTip() {
		return tip;
	}



	public void setTip(TipNekretnine tip) {
		this.tip = tip;
	}



	@Override
	public String toString() {
		return "Nekretnina [id=" + id + ", povrsina=" + povrsina + ", cena=" + cena + ", adresa=" + adresa + ", tip="
				+ tip + "]";
	}


	
}
