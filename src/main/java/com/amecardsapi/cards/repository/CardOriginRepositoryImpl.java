package com.amecardsapi.cards.repository;

import com.amecardsapi.cards.exception.InvalidEntityAttibuteException;
import com.amecardsapi.cards.model.CardOrigin;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CardOriginRepositoryImpl implements CardOriginRepository{
    private List<CardOrigin> cardOrigins = new ArrayList<>();

    @Override
    public Optional<CardOrigin> findById(int id) {
        return cardOrigins.stream().filter(cardOrigin -> cardOrigin.getId() == id).findFirst();
    }

    @Override
    public CardOrigin save(CardOrigin cardOrigin) {
        Optional<CardOrigin> cardOriginFound = cardOrigins.stream().filter(cardOriginCurrent ->
                cardOriginCurrent
                .getName().equals(cardOrigin.getName())).findFirst();

        if (cardOriginFound.isPresent()) {
            throw new InvalidEntityAttibuteException("Card origin name [" + cardOriginFound.get()
                    .getName() + "] already stored");
        }
        cardOrigin.setId(cardOrigins.size() + 1);
        cardOrigins.add(cardOrigin);
        return cardOrigin;
    }
}
