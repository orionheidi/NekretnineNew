package jwd.wafepa.service;

import org.springframework.data.domain.Page;

import jwd.wafepa.model.TipNekretnine;

public interface TipNekretnineService {

	public TipNekretnine save(TipNekretnine tip);
	
	public Page<TipNekretnine> findAll(int page);
	
	public TipNekretnine findOne(Long id);
}
