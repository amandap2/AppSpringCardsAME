package com.amecardsapi.cards.controller;


import com.amecardsapi.cards.model.CardOrigin;
import com.amecardsapi.cards.service.CardOriginService;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/card-origin")
public class CardOriginController {

    private final CardOriginService cardOriginService;

    @Autowired
    public CardOriginController(CardOriginService cardOriginService) {
        this.cardOriginService = cardOriginService;
    }

    @GetMapping("{id}")
    public CardOrigin findById(@PathVariable("id") int id){
        return cardOriginService.findById(id);
    }

    @PostMapping
    public CardOrigin save(@RequestBody CardOriginRequest cardOriginRequest){
        return cardOriginService.save(cardOriginRequest);
    }
}
