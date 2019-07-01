package br.gov.rn.saogoncalo.smtsisapi.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.gov.rn.saogoncalo.smtsisapi.models.Imovel;
import br.gov.rn.saogoncalo.smtsisapi.repositories.ImovelRepository;

@RestController
@RequestMapping("/imoveis")
public class ImovelResource {
	
	@Autowired
	private ImovelRepository repository;
	
	@GetMapping
	public List<Imovel> obtemTodosImoveis(){
		return repository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Imovel> salvaImovel(@RequestBody @Valid Imovel imovel, UriComponentsBuilder uriBuilder){
		repository.save(imovel);
		
		URI uri = uriBuilder.path("/imoveis/{id}")
				.buildAndExpand(imovel.getId())
				.toUri();
		
		return ResponseEntity.created(uri).body(imovel);
	}

}
