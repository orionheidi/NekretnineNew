package jwd.wafepa.support;

import java.util.ArrayList;

import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.TipNekretnine;
import jwd.wafepa.web.dto.TipNekretnineDTO;

@Component
public class TipNekretnineToTipNekDTO implements Converter<TipNekretnine, TipNekretnineDTO>{

	@Override
	public TipNekretnineDTO convert(TipNekretnine tip) {
		
		TipNekretnineDTO tipNekdto = new TipNekretnineDTO(tip.getId(),tip.getNaziv());
		
		return tipNekdto;
	}

		
		public List<TipNekretnineDTO> convert(List<TipNekretnine> tipovi) {
			
			List<TipNekretnineDTO> dtos = new ArrayList<>();
			
			for(TipNekretnine d: tipovi){
				dtos.add(convert(d));
			}
			return dtos;
		
		
	}

	

}
