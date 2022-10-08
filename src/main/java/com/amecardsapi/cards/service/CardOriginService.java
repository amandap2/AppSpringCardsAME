package com.amecardsapi.cards.service;

import com.amecardsapi.cards.controller.CardOriginRequest;
import com.amecardsapi.cards.exception.EntityNotFoundException;
import com.amecardsapi.cards.model.Card;
import com.amecardsapi.cards.model.CardOrigin;
import com.amecardsapi.cards.repository.CardOriginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CardOriginService {
    private final CardOriginRepository cardOriginRepository;

    @Autowired
    public CardOriginService(CardOriginRepository cardOriginRepository) {
        this.cardOriginRepository = cardOriginRepository;
    }

    public CardOrigin findById(int id) {
        return this.cardOriginRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Card origin id [" + id + "] not found"));
    }

    public CardOrigin save(CardOriginRequest cardOriginRequest) {
        CardOrigin cardOrigin = new CardOrigin();
        cardOrigin.setName(cardOriginRequest.getName());
        cardOrigin.setDescription(cardOriginRequest.getDescription());
        cardOrigin.setCreator(cardOriginRequest.getCreator());
        cardOrigin.setUpdateAt(LocalDateTime.now());
        cardOrigin.setCreatedAt(LocalDateTime.now());
        return cardOriginRepository.save(cardOrigin);

    }
}
