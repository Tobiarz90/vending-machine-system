package pl.coderslab.vendingmachinesystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.vendingmachinesystem.entities.StockItem;
import pl.coderslab.vendingmachinesystem.repositories.StockItemRepository;

import java.util.List;

@Controller
@RequestMapping(path = "/user")
public class UserPanelController {

    private final StockItemRepository stockItemRepository;

    public UserPanelController(StockItemRepository stockItemRepository) {
        this.stockItemRepository = stockItemRepository;
    }

    @GetMapping(path = "/machine")
    public String showStockItems(Model model) {
        List<StockItem> stockItems = stockItemRepository.findAll();
        return "machine";
    }
}
