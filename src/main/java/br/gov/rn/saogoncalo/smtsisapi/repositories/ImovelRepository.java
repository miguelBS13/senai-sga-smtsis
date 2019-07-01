package br.gov.rn.saogoncalo.smtsisapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.rn.saogoncalo.smtsisapi.models.Imovel;

@Repository
public interface ImovelRepository extends JpaRepository<Imovel, Long> {

	List<Imovel> findByResponsavel(String responsavel);
	
}
