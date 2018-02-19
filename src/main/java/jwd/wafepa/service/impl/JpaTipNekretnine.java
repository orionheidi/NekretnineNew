package jwd.wafepa.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jwd.wafepa.model.TipNekretnine;
import jwd.wafepa.repository.TipNekretnineRepository;
import jwd.wafepa.service.TipNekretnineService;

@Service
@Transactional
public class JpaTipNekretnine implements TipNekretnineService {
	
	@Autowired
	TipNekretnineRepository tipNekretnineRepo;

	@Override
	public TipNekretnine save(TipNekretnine tip) {
		return tipNekretnineRepo.save(tip);
	}

	@Override
	public Page<TipNekretnine> findAll(int page) {
		return tipNekretnineRepo.findAll(new PageRequest(page,10));
	}

	@Override
	public TipNekretnine findOne(Long id) {
		return tipNekretnineRepo.findOne(id);
	}

}
