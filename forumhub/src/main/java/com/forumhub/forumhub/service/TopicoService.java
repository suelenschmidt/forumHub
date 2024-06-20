package com.forumhub.forumhub.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forumhub.forumhub.dto.TopicoDTO;
import com.forumhub.forumhub.dto.TopicoForm;
import com.forumhub.forumhub.model.Topico;
import com.forumhub.forumhub.repository.TopicoRepository;
import com.forumhub.forumhub.repository.UsuarioRepository;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<TopicoDTO> findAll() {
        return topicoRepository.findAll().stream().map(TopicoDTO::new).collect(Collectors.toList());
    }

    public TopicoDTO findById(Long id) {
        Topico topico = topicoRepository.findById(id).orElseThrow();
        return new TopicoDTO(topico);
    }

    public TopicoDTO save(TopicoForm form) {
        Topico topico = form.converter(usuarioRepository);
        topicoRepository.save(topico);
        return new TopicoDTO(topico);
    }

    public TopicoDTO update(Long id, TopicoForm form) {
        Topico topico = topicoRepository.findById(id).orElseThrow();
        topico.setTitulo(form.getTitulo());
        topico.setMensagem(form.getMensagem());
        topicoRepository.save(topico);
        return new TopicoDTO(topico);
    }

    public void delete(Long id) {
        topicoRepository.deleteById(id);
    }
}