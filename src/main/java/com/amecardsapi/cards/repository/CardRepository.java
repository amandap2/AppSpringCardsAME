package com.amecardsapi.cards.repository;

import com.amecardsapi.cards.model.Card;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepository {
    Optional<Card> findById(long id);

    Card save(Card card);

}
