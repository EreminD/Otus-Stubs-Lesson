package ru.otus.main.service;

import org.springframework.stereotype.Service;
import ru.otus.model.CcyPairs;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class WalletService {
    private final Map<String, Double> wallet = new HashMap<>();

    @PostConstruct
    private void setWallet(){
        wallet.put("RUB", 1000000d);
        wallet.put("USD", 1000000d);
        wallet.put("EUR", 0d);
        wallet.put("JPY", 0d);
        wallet.put("GBP", 0d);
    }

    public void add(String ccy, double amount){
        double current = wallet.get(ccy);
        wallet.put(ccy, current + amount);
    }

    public void withdraw(String ccy, double amount) {
        double current = wallet.get(ccy);
        wallet.put(ccy, current - amount);
    }

    public Map.Entry<String, Double> getByCcy(String ccy){
        return wallet.entrySet().stream().filter(e -> e.getKey().equalsIgnoreCase(ccy)).findFirst().get();
    }
}
