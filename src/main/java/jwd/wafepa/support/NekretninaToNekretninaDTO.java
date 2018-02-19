package jwd.wafepa.support;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import jwd.wafepa.model.Nekretnina;
import jwd.wafepa.web.dto.NekretninaDTO;

@Component
public class NekretninaToNekretninaDTO implements Converter<Nekretnina, NekretninaDTO> {
	
	@Autowired
	TipNekretnineToTipNekDTO tiptoDTO;

	public NekretninaDTO convert(Nekretnina nekretnina) {
		
		NekretninaDTO dto = new NekretninaDTO(nekretnina.getId(), nekretnina.getPovrsina(), nekretnina.getCena(), nekretnina.getAdresa(), tiptoDTO.convert(nekretnina.getTip()));

		return dto;
	}
	
	public List<NekretninaDTO> convert(List<Nekretnina> listaNekretnina){
		List<NekretninaDTO> ret = new ArrayList<>();
		
		for(Nekretnina n: listaNekretnina){
			ret.add(convert(n));
		}
		
		return ret;
	}

}
