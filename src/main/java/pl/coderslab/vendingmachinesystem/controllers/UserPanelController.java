package pl.coderslab.vendingmachinesystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.vendingmachinesystem.entities.StockItem;
import pl.coderslab.vendingmachinesystem.repositories.StockItemRepository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/user")
public class UserPanelController {

    private final StockItemRepository stockItemRepository;

    public UserPanelController(StockItemRepository stockItemRepository) {
        this.stockItemRepository = stockItemRepository;
    }

    @GetMapping(path = "/machine")
    public String showStock(Model model) {
        List<StockItem> stockItems = stockItemRepository.findAll();

        Map<Integer, Map<Integer, List<StockItem>>> stock = stockItems.stream()
                .collect(Collectors.groupingBy(StockItem::getNoHorizontally,
                        Collectors.groupingBy(StockItem::getNoVertically)));
        model.addAttribute("stock", stock);

        return "machine";
    }

    @GetMapping(path = "/keypad")
    public String showKeypad() {
        return "keypad";
    }

}
