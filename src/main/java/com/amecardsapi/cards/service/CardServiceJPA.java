package com.amecardsapi.cards.service;

import com.amecardsapi.cards.controller.CardRequest;
import com.amecardsapi.cards.model.Card;
import com.amecardsapi.cards.model.CardOrigin;
import com.amecardsapi.cards.repository.CardRepositoryJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CardServiceJPA {
    private final CardRepositoryJPA cardRepositoryJPA;

    @Autowired
    public CardServiceJPA(CardRepositoryJPA cardRepositoryJPA) {
        this.cardRepositoryJPA = cardRepositoryJPA;
    }

    public Optional<Card> findById(long id){
        return cardRepositoryJPA.findById(id);
    }

    public Card save(CardRequest cardRequest) {
        Card card = new Card();
        card.setName(cardRequest.getName());
        card.setDescription(cardRequest.getDescription());
        card.setImageUrl(cardRequest.getImageUrl());
        card.setStrength(cardRequest.getStrength());
        card.setSpeed(cardRequest.getSpeed());
        card.setIntellect(cardRequest.getIntellect());
        card.setGear(cardRequest.getGear());
        card.setSkill(cardRequest.getSkill());
        card.setCreatedAt(LocalDateTime.now());
        card.setUpdatedAt(LocalDateTime.now());
        return cardRepositoryJPA.save(card);
    }
}
