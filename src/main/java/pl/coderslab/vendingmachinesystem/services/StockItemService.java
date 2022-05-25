package pl.coderslab.vendingmachinesystem.services;

import org.springframework.stereotype.Service;
import pl.coderslab.vendingmachinesystem.repositories.StockItemRepository;

@Service
public class StockItemService {

    private final StockItemRepository stockItemRepository;

    public StockItemService(StockItemRepository stockItemRepository) {
        this.stockItemRepository = stockItemRepository;
    }

}
