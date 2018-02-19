package jwd.wafepa.support;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import jwd.wafepa.model.Nekretnina;
import jwd.wafepa.service.NekretninaService;
import jwd.wafepa.service.TipNekretnineService;
import jwd.wafepa.web.dto.NekretninaDTO;
import jwd.wafepa.web.dto.TipNekretnineDTO;

@Component
public class NekretninaDTOToNekretnina 	implements Converter<NekretninaDTO, Nekretnina> {

	@Autowired
	NekretninaService nekretninaService;
	
	@Autowired
	TipNekretnineService tipService;
	
	@Override
	public Nekretnina convert(NekretninaDTO dto) {
		
		Nekretnina nekretnina = new Nekretnina();
		if(dto.getId() != null){
			nekretnina = nekretninaService.findOne(dto.getId());
		}
		if(nekretnina==null){
			throw new IllegalStateException("Tried to "
					+ "modify a non-existant nekretnina");
		}
		
		nekretnina.setId(dto.getId());
		nekretnina.setAdresa(dto.getAdresa());
		nekretnina.setCena(dto.getCena());
		nekretnina.setPovrsina(dto.getPovrsina());
		nekretnina.setTip(tipService.findOne(dto.getTip().getId()));
		
		return nekretnina;

	}
	
	public List<Nekretnina> convert(List<NekretninaDTO> listadto){
		
		List<Nekretnina> nekretnine = new ArrayList<>();
		
		for(NekretninaDTO dto: listadto){		
		
			nekretnine.add(convert(dto));
		
	}
	
		return nekretnine;
}
}
