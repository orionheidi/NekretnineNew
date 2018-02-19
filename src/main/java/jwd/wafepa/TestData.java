package jwd.wafepa;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jwd.wafepa.model.Nekretnina;
import jwd.wafepa.model.TipNekretnine;
import jwd.wafepa.service.NekretninaService;
import jwd.wafepa.service.TipNekretnineService;

@Component
public class TestData {

	@Autowired
	
	private TipNekretnineService tipNekretnineService;
	
	@Autowired
	
	private NekretninaService nekretninaService;

	@PostConstruct
	public void init(){
		
		
	            TipNekretnine garsonjera = new TipNekretnine();
	            garsonjera.setNaziv("Garsonjera ");     
	            tipNekretnineService.save(garsonjera);
		  
		  
	
	            TipNekretnine jednosoban = new TipNekretnine();
	            jednosoban.setNaziv("Jednosoban ");
	            tipNekretnineService.save(jednosoban);
		  
		  
		
	            TipNekretnine dvosoban = new TipNekretnine();
	            dvosoban.setNaziv("Dvosoban ");
	            tipNekretnineService.save(dvosoban);
		
		  

	            for(int i=0;i<=10;i++){
	          
	                Nekretnina nekretnina1 = new Nekretnina();
	                nekretnina1.setPovrsina(32);
	                nekretnina1.setCena(40000);
	                nekretnina1.setAdresa("Branko Bajic 23");    
	                nekretnina1.setTip(garsonjera);
	        
	                nekretninaService.save(nekretnina1);
	            }
	           

	            for(int i=0;i<=10;i++){
	  	          
	                Nekretnina nekretnina2 = new Nekretnina();
	                nekretnina2.setPovrsina(45);
	                nekretnina2.setCena(50000);
	                nekretnina2.setAdresa("Malog Radojka 26");    
	                nekretnina2.setTip(jednosoban);
	        
	                nekretninaService.save(nekretnina2);
	            }
	           

	            for(int i=0;i<=10;i++){
	  	          
	                Nekretnina nekretnina3 = new Nekretnina();
	                nekretnina3.setPovrsina(60);
	                nekretnina3.setCena(75000);
	                nekretnina3.setAdresa("Stefana Stete Prodana 68");    
	                nekretnina3.setTip(dvosoban);
	        
	                nekretninaService.save(nekretnina3);
	            }
	           

	}
}
