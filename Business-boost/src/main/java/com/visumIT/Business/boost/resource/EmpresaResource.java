package com.visumIT.Business.boost.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.visumIT.Business.boost.DTO.EmpresaDTO;
import com.visumIT.Business.boost.exception.ValidationFormat;
import com.visumIT.Business.boost.models.Empresa;
import com.visumIT.Business.boost.models.Telefone;
import com.visumIT.Business.boost.repository.EmpresaRepository;
import com.visumIT.Business.boost.repository.TelefoneRepository;

@RestController
@RequestMapping("/empresa")
public class EmpresaResource {

	@Autowired
	private EmpresaRepository empresaRepository;

	private EmpresaDTO dto = new EmpresaDTO();
//	@Autowired
//	private EnderecoRepository enderecoRepository;

	@Autowired
	private TelefoneRepository telefoneRepository;

	@GetMapping
	public List<Empresa> getEmpresas() {
		return empresaRepository.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getEmpresa(@PathVariable Long id) {
		Optional<Empresa> empresaProcurada = empresaRepository.findById(id);
		if(empresaProcurada.isPresent()) {
			EmpresaDTO dtoProcurada = dto.toEmpresaDTO(empresaProcurada.get());
			return ResponseEntity.ok().body(dtoProcurada);
		}
		
		return empresaProcurada.isPresent() ? ResponseEntity.ok(empresaProcurada.get())
				: ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> gravar(@Valid @RequestBody Empresa empresa, BindingResult bindingResult) {
		if (empresaRepository.existsByEmail(empresa.getEmail())) {
			return ResponseEntity.badRequest().body(new JSONObject().put("message", "E-mail allready in use").toString());
			
		} else if(bindingResult.hasErrors()){
			return ResponseEntity.badRequest().body(ValidationFormat.formatarErros(bindingResult));
		} 
		else {
			Empresa e = empresaRepository.save(empresa);
			for (Telefone tel : e.getTelefone()) {
				tel.setEmpresa(e);
				telefoneRepository.save(tel);
			}
			return ResponseEntity.ok().body(new JSONObject()
					.put("message", "company successfully registered").toString());
		}
	}

	// usando o retorno response entity para poder retornar o erro 404 caso tente
	// deletar algo q não existe
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		if (empresaRepository.existsById(id)) {
			empresaRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?>  atualizar(@Valid @RequestBody Empresa empresa, @PathVariable Long id) {
		if(empresaRepository.existsById(id)) {
			empresaRepository.save(empresa);
			return ResponseEntity.ok().body(new JSONObject()
					.put("message", "company successfully updated").toString());
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}

}
