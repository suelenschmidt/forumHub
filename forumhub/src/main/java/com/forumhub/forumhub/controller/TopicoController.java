package com.forumhub.forumhub.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forumhub.forumhub.dto.TopicoDTO;
import com.forumhub.forumhub.dto.TopicoForm;
import com.forumhub.forumhub.service.TopicoService;


@RestController
@RequestMapping("/topicos")

public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @GetMapping
    public List<TopicoDTO> listar() {
        return topicoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicoDTO> detalhar(@PathVariable Long id) {
        TopicoDTO dto = topicoService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<TopicoDTO> cadastrar(@Valid @RequestBody TopicoForm form) {
        TopicoDTO dto = topicoService.save(form);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TopicoDTO> atualizar(@PathVariable Long id, @Valid @RequestBody TopicoForm form) {
        TopicoDTO dto = topicoService.update(id, form);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        topicoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
