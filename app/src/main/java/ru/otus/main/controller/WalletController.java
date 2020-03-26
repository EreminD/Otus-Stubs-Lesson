package ru.otus.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.otus.main.service.WalletService;

import java.util.Map;

@RestController
@RequestMapping("/api/wallet")
public class WalletController {
    @Autowired
    private WalletService wallet;

    @GetMapping("/{ccy}")
    public ResponseEntity<Map.Entry<String, Double>> change(@PathVariable String ccy) {
        return ResponseEntity.ok(wallet.getByCcy(ccy));
    }

}
