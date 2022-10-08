package com.amecardsapi.cards.controller;

import com.amecardsapi.cards.exception.InvalidEntityAttibuteException;
import com.amecardsapi.cards.model.Card;
import com.amecardsapi.cards.service.CardService;
import com.amecardsapi.cards.service.CardServiceJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/card")
public class CardController {
    private final CardService cardService;
    private final CardServiceJPA cardServiceJPA;


    @Autowired
    public CardController(CardService cardService, CardServiceJPA cardServiceJPA) {
        this.cardService = cardService;
        this.cardServiceJPA = cardServiceJPA;
    }

    @GetMapping("{id}")
    public Card findById(@PathVariable("id") long id) {

        Optional<Card> cardOptional = cardService.findById(id);
        if(cardOptional.isPresent()){
            return cardOptional.get();
        }
        throw new InvalidEntityAttibuteException("Card not found");
    }

    @PostMapping
    public Card save(@RequestBody CardRequest cardRequest){

        //return cardService.save(cardRequest);
        return cardServiceJPA.save(cardRequest);
    }
}
