package com.api.gestao_vagas.modules.candidate.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.gestao_vagas.modules.candidate.CandidateEntity;
import com.api.gestao_vagas.modules.candidate.useCases.CreateCandidateUseCase;


@RestController
@RequestMapping("/candidate")
public class CandidateController {
	@Autowired
	private CreateCandidateUseCase createCandidateUseCase;

	@PostMapping
	public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity) {
		try {
			var result = createCandidateUseCase.execute(candidateEntity);
			return ResponseEntity.ok().body(result);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
