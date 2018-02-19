package jwd.wafepa.service;


import org.springframework.data.domain.Page;
import jwd.wafepa.model.Nekretnina;


public interface NekretninaService {

	public Nekretnina save(Nekretnina nekretnina);
	
	public Page<Nekretnina> findAll(int page); 
	
	public Nekretnina findOne(Long id);
	
	public Nekretnina delete(Long id);
	
	public Page<Nekretnina> filterNekretnina(String adresa, int cenaOd, int cenaDo,int page);
}
