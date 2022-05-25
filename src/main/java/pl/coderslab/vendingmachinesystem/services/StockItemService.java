package pl.coderslab.vendingmachinesystem.services;

import org.springframework.stereotype.Service;
import pl.coderslab.vendingmachinesystem.Machine;
import pl.coderslab.vendingmachinesystem.entities.StockItem;
import pl.coderslab.vendingmachinesystem.repositories.StockItemRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
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

    public Optional<StockItem> findItemWithNumber(Integer itemNumber) {
        List<StockItem> stockItems = stockItemRepository.findAll();
        Map<Integer, Map<Integer, List<StockItem>>> stock = getStock(stockItems);

        int counter = 0;
        for (int i = 0; i < Machine.ROWS; i++) {
            for (int j = 0; j < Machine.COLUMNS; j++) {
                counter++;
                if (stock.get(i) != null) {
                    if (stock.get(i).get(j) != null) {
                        if (counter == itemNumber) {
                            return Optional.of(stock.get(i).get(j).get(0));
                        }
                    }
                }
            }
        }

        return Optional.empty();
    }

}
