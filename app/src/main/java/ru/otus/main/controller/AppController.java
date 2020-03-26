package ru.otus.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.otus.main.model.ChangeCurrencyRequest;
import ru.otus.main.service.AppService;
import ru.otus.model.CcyPairs;
import ru.otus.model.DealResponse;

@RestController
@RequestMapping("/api/change")
public class AppController {
    @Autowired
    private AppService service;

    @PostMapping()
    public ResponseEntity<DealResponse> change(@RequestBody ChangeCurrencyRequest request) {
        CcyPairs ccyPair = CcyPairs.valueOf(request.getCcyTo() + "_" + request.getCcyFrom());
        return ResponseEntity.ok(service.change(ccyPair, request.getAmount()));
    }
}
