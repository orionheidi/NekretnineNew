package jwd.wafepa.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.wafepa.model.Nekretnina;
import jwd.wafepa.model.TipNekretnine;
import jwd.wafepa.service.TipNekretnineService;
import jwd.wafepa.support.TipNekretnineToTipNekDTO;
import jwd.wafepa.web.dto.NekretninaDTO;
import jwd.wafepa.web.dto.TipNekretnineDTO;

@RestController
@RequestMapping(value = "/api/tipNekretnine")
public class TipNekretnineController {
	
	@Autowired
	private TipNekretnineService tipNekretnineService;
	
	@Autowired
	private TipNekretnineToTipNekDTO toDTO;
	
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<TipNekretnineDTO>> getAllTip(
			@RequestParam(value = "page", defaultValue = "0") int page) 
	{
		Page<TipNekretnine> tipNew = tipNekretnineService.findAll(page);
		
		if(tipNew == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			HttpHeaders headers = new HttpHeaders();
			headers.add("totalPages", tipNew.getTotalPages() + "");
			return new ResponseEntity<List<TipNekretnineDTO>>(toDTO.convert(tipNew.getContent()), headers, HttpStatus.OK);
		}
		
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ResponseEntity<TipNekretnineDTO> get(@PathVariable Long id){
		
		TipNekretnine tip = tipNekretnineService.findOne(id);
		
		if (tip == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		
		return new ResponseEntity<>(toDTO.convert(tip),HttpStatus.OK);
	}
	

}
