package jwd.wafepa.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.wafepa.model.Nekretnina;
import jwd.wafepa.repository.NekretninaRepository;
import jwd.wafepa.service.NekretninaService;

@Service
@Transactional
public class JpaNekretninaService implements NekretninaService{

	@Autowired
	NekretninaRepository nekretninaRepository;
	
	@Override
	public Nekretnina save(Nekretnina nekretnina) {
		return nekretninaRepository.save(nekretnina);
	}

	@Override
	public Page<Nekretnina> findAll(int page) {
		return nekretninaRepository.findAll(new PageRequest(page, 10));
	}

	@Override
	public Nekretnina findOne(Long id) {
		return nekretninaRepository.findOne(id);
	}

	@Override
	public Nekretnina delete(Long id) {
		Nekretnina nek = nekretninaRepository.findOne(id);
		if(nek == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant nekretnina");
		}
		nekretninaRepository.delete(nek);
		return nek;
	}

	@Override
	public Page<Nekretnina> filterNekretnina(String adresa, int cenaOd, int cenaDo, int page) {
		return nekretninaRepository.filterNekretnina(adresa, cenaOd, cenaDo, new PageRequest(page, 10));
	}

}
