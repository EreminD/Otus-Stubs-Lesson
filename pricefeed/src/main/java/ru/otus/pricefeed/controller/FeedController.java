package ru.otus.pricefeed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.model.CcyPairs;
import ru.otus.model.PriceFeed;
import ru.otus.pricefeed.repository.FeedRepository;

import java.util.Collection;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/feed")
public class FeedController {
    @Autowired
    private FeedRepository repository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<PriceFeed>> history() {
        return ok(repository.getAll());
    }

    @GetMapping(value = "/{ccyPair}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PriceFeed> getByPair(@PathVariable CcyPairs ccyPair) {
        return ResponseEntity.ok(repository.getByName(ccyPair));
    }

}
