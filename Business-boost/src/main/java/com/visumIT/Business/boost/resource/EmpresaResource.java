package com.visumIT.Business.boost.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.visumIT.Business.boost.models.Empresa;
import com.visumIT.Business.boost.models.Telefone;
import com.visumIT.Business.boost.repository.EmpresaRepository;
import com.visumIT.Business.boost.repository.TelefoneRepository;

@RestController
@RequestMapping("/empresa")
public class EmpresaResource {

	@Autowired
	private EmpresaRepository empresaRepository;
	

//	@Autowired
//	private EnderecoRepository enderecoRepository;

	@Autowired
	private TelefoneRepository telefoneRepository;
	
	
	@GetMapping
	public List<Empresa> getEmpresas() {
		return empresaRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmpresa(@PathVariable Long id){
		Optional<?> empresaProcurada = empresaRepository.findById(id);
		return empresaProcurada.isPresent() ?
				ResponseEntity.ok(empresaProcurada.get()) :
				ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Empresa gravar(@Valid @RequestBody Empresa empresa) {
		Empresa e = empresaRepository.save(empresa);
		for(Telefone tel : e.getTelefone()) {
			tel.setEmpresa(e);
			telefoneRepository.save(tel);
		}
		return e;
//		return empresaRepository.save(empresa);
//		Empresa e = empresaRepository.save(empresa);
//		for(Endereco end : e.getEndereco()) {
//			end.setEmpresa(e);
//			enderecoRepository.save(end);
//		}
//		return e;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluir(@PathVariable Long id) {
		empresaRepository.deleteById(id);
	}
	
	@PutMapping("/")
	public void atualizar(@Valid @RequestBody Empresa empresa) {
		empresaRepository.save(empresa);
	}
	
}
