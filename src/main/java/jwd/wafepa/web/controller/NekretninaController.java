package jwd.wafepa.web.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import jwd.wafepa.model.Nekretnina;
import jwd.wafepa.service.NekretninaService;
import jwd.wafepa.support.NekretninaDTOToNekretnina;
import jwd.wafepa.support.NekretninaToNekretninaDTO;
import jwd.wafepa.web.dto.NekretninaDTO;

@RestController
@RequestMapping(value="/api/nekretnine")
public class NekretninaController {
	
	@Autowired
	private NekretninaService nekretninaService;
	
	@Autowired
	private NekretninaToNekretninaDTO toDTO;
	
	@Autowired
	private NekretninaDTOToNekretnina toNekretnina;
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<NekretninaDTO>> getAllNekretnine(
			@RequestParam(value = "page", defaultValue = "0") int page) 
	{
		Page<Nekretnina> nekretnine = nekretninaService.findAll(page);

		if(nekretnine == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else{
			HttpHeaders headers = new HttpHeaders();
			headers.add("totalPages", nekretnine.getTotalPages() + "");
			return new ResponseEntity<List<NekretninaDTO>>(toDTO.convert(nekretnine.getContent()), headers, HttpStatus.OK);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value ="/filterNekretnina")
	ResponseEntity<List<NekretninaDTO>> filterNekretnina(
			@RequestParam(value = "adresa", defaultValue = "") String adresa,
			@RequestParam(value = "cenaOd", defaultValue = "0") int cenaOd,
			@RequestParam(value = "cenaDo", defaultValue = "0") int cenaDo,
			@RequestParam(value = "page", defaultValue = "0") int page)
	
	{
		Page<Nekretnina> filterNekretnine = nekretninaService.filterNekretnina(adresa, cenaOd, cenaDo, page);
		
		return new ResponseEntity<>(toDTO.convert(filterNekretnine.getContent()),HttpStatus.OK);
		
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ResponseEntity<NekretninaDTO> getNekretnina(@PathVariable Long id) {
		Nekretnina nekretnina = nekretninaService.findOne(id);
		if (nekretnina == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDTO.convert(nekretnina), HttpStatus.OK);
	}
	
	@RequestMapping( method=RequestMethod.POST, consumes = "application/json")
	ResponseEntity<NekretninaDTO> add(@RequestBody NekretninaDTO dto) {
		
		Nekretnina savedNekretnina = nekretninaService.save(toNekretnina.convert(dto));
		
		if(savedNekretnina == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		else
			return new ResponseEntity<>(toDTO.convert(savedNekretnina),HttpStatus.CREATED);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}",consumes = "application/json")
	ResponseEntity<NekretninaDTO> edit(
			@RequestBody NekretninaDTO nekretninaDto,
			@PathVariable Long id){
		
		if(id != nekretninaDto.getId()){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Nekretnina savedNekretnina = nekretninaService.save(toNekretnina.convert(nekretninaDto));
				return new ResponseEntity<>(toDTO.convert(savedNekretnina), HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	ResponseEntity<NekretninaDTO> delete(@PathVariable Long id){
		
		Nekretnina nekretnina = nekretninaService.delete(id);
		
		return new ResponseEntity<>(toDTO.convert(nekretnina),HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
