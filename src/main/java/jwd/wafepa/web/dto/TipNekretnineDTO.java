package jwd.wafepa.web.dto;

public class TipNekretnineDTO {

	private Long id;
	private String naziv;

	
	public TipNekretnineDTO() {
		super();
	}


	public TipNekretnineDTO(Long id, String naziv) {
		super();
		this.id = id;
		this.naziv = naziv;
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
	
	
	
	
}
