package com.forumhub.forumhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.forumhub.forumhub.model.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
}