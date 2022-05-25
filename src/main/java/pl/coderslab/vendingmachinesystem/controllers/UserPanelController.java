package pl.coderslab.vendingmachinesystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.vendingmachinesystem.Machine;
import pl.coderslab.vendingmachinesystem.entities.StockItem;
import pl.coderslab.vendingmachinesystem.repositories.StockItemRepository;
import pl.coderslab.vendingmachinesystem.services.StockItemService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(path = "/user")
public class UserPanelController {

    private final StockItemRepository stockItemRepository;

    private final StockItemService stockItemService;

    public UserPanelController(StockItemRepository stockItemRepository, StockItemService stockItemService) {
        this.stockItemRepository = stockItemRepository;
        this.stockItemService = stockItemService;
    }

    @GetMapping(path = "/machine")
    public String showStock(Model model) {
        List<StockItem> stockItems = stockItemRepository.findAll();

        Map<Integer, Map<Integer, List<StockItem>>> stock = stockItemService.getStock(stockItems);
        model.addAttribute("stock", stock);

        model.addAttribute("rows", Machine.ROWS);
        model.addAttribute("columns", Machine.COLUMNS);

        return "machine";
    }

    @GetMapping(path = "/keypad")
    public String showKeypad() {
        return "keypad";
    }

}
