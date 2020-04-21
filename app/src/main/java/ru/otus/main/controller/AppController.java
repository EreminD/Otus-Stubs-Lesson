package ru.otus.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        try {
            DealResponse change = service.change(ccyPair, request.getSize());
            return ResponseEntity.ok(change);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
