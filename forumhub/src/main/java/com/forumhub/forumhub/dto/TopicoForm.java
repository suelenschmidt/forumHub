package com.forumhub.forumhub.dto;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.forumhub.forumhub.model.Topico;
import com.forumhub.forumhub.model.Usuario;
import com.forumhub.forumhub.repository.UsuarioRepository;


@Validated
public class TopicoForm {
    @NotNull
    private String titulo;
    @NotNull
    private String mensagem;
    @NotNull
    private Long autorId;

    // Getters and Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }


    public Topico converter(UsuarioRepository usuarioRepository) {
        Usuario autor = usuarioRepository.findById(autorId).orElseThrow();
        return new Topico(titulo, mensagem, autor);
    }
}

