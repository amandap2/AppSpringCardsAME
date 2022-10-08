package com.amecardsapi.cards.repository;

import com.amecardsapi.cards.model.Card;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepositoryJPA extends JpaRepository<Card, Long> {
}
