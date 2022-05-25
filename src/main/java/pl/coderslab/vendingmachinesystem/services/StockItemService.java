package pl.coderslab.vendingmachinesystem.services;

import org.springframework.stereotype.Service;
import pl.coderslab.vendingmachinesystem.entities.StockItem;
import pl.coderslab.vendingmachinesystem.repositories.StockItemRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StockItemService {

    private final StockItemRepository stockItemRepository;

    public StockItemService(StockItemRepository stockItemRepository) {
        this.stockItemRepository = stockItemRepository;
    }

    public Map<Integer, Map<Integer, List<StockItem>>> getStock(List<StockItem> stockItems) {
        return stockItems.stream()
                .collect(Collectors.groupingBy(StockItem::getNoHorizontally,
                        Collectors.groupingBy(StockItem::getNoVertically)));
    }

}
