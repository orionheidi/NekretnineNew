package jwd.wafepa.web.dto;

public class NekretninaDTO {

	private Long id;
	private int povrsina;
	private int cena;
	private String adresa;
	private TipNekretnineDTO tip;
	
	
	
	public NekretninaDTO() {
		super();
	}


	public NekretninaDTO(Long id, int povrsina, int cena, String adresa, TipNekretnineDTO tip) {
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


	public TipNekretnineDTO getTip() {
		return tip;
	}


	public void setTip(TipNekretnineDTO tip) {
		this.tip = tip;
	}


	

	


	
	
	
}
