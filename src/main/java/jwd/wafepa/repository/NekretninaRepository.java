package jwd.wafepa.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import jwd.wafepa.model.Nekretnina;

@Repository
public interface NekretninaRepository extends PagingAndSortingRepository<Nekretnina,Long>{

	@Query("SELECT x FROM Nekretnina x where x.adresa LIKE ?1% AND x.cena >= ?2 OR x.cena <= ?3")
	Page<Nekretnina> filterNekretnina(String adresa, int cenaOd, int cenaDo,Pageable page);
}
