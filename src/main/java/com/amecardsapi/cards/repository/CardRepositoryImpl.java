package com.amecardsapi.cards.repository;

import com.amecardsapi.cards.model.Card;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CardRepositoryImpl implements CardRepository{

    private final List<Card> cards = new ArrayList<>();

    @Override
    public Optional<Card> findById(long id) {
        return cards.stream().filter(card -> card.getId() == id).findFirst();
    }

    @Override
    public Card save(Card card) {
        Optional<Card> optionalCard = cards.stream().filter(currentCard -> card.getName().equals(currentCard.getName())).findFirst();
        if(optionalCard.isPresent()){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Card [" + card.getName() + "] already exists");
        }
        card.setId(cards.size() + 1);
        cards.add(card);
        return card;
    }
}
