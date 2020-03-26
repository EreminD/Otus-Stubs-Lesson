package com.otus.exchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.otus.model.DealRequest;
import ru.otus.model.DealResponse;


@RestController
@RequestMapping("/api/forex")
public class ExchangeController {
    private final static double fee = 0.01; //1%
    @PostMapping(value = "/deal", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DealResponse> deal(@RequestBody DealRequest request) {
        System.out.println("===>" + request);
        double feeCharge = request.getAmountInCcy1()*fee;
        double totalToDeal = request.getAmountInCcy1() - feeCharge;
        double totalChanged = request.getAmount() * totalToDeal/request.getAmountInCcy1();
        DealResponse response = new DealResponse(request.getPair(), totalChanged, feeCharge);
        System.out.println("<===" + response);
        return ResponseEntity.ok(response);
    }

}
