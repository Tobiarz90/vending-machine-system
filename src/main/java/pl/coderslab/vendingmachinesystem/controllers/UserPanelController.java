package pl.coderslab.vendingmachinesystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.vendingmachinesystem.Machine;
import pl.coderslab.vendingmachinesystem.entities.*;
import pl.coderslab.vendingmachinesystem.repositories.PurchaseRepository;
import pl.coderslab.vendingmachinesystem.repositories.StockItemRepository;
import pl.coderslab.vendingmachinesystem.services.StockItemService;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping(path = "/user")
@SessionAttributes({"price", "purchase"})
public class UserPanelController {

    private final StockItemRepository stockItemRepository;

    private final StockItemService stockItemService;

    private final PurchaseRepository purchaseRepository;

    private final Validator validator;

    public UserPanelController(StockItemRepository stockItemRepository, StockItemService stockItemService, PurchaseRepository purchaseRepository, AdminService adminService, Validator validator) {
        this.stockItemRepository = stockItemRepository;
        this.stockItemService = stockItemService;
        this.purchaseRepository = purchaseRepository;
        this.validator = validator;
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

    @PostMapping(path = "/keypad")
    public String keypadSelect(@RequestParam Integer itemNumber, Model model) {
        Optional<StockItem> stockItem = stockItemService.findItemWithNumber(itemNumber);
        if (stockItem.isPresent()) {
            Purchase purchase = new Purchase();
            purchase.setStockItem(stockItem.get());
            purchase.setAmount(1);
            purchase.setStatus(OrderStatus.IN_PROGRESS);

            BigDecimal price = stockItem.get().getProduct().getPrice();
            model.addAttribute("price", price);

            Purchase savedPurchase = purchaseRepository.save(purchase);
            model.addAttribute("purchase", savedPurchase);

            return "redirect:payment";
        }

        return "redirect:keypad";
    }

    @GetMapping(path = "/payment")
    public String showPayment() {
        return "payment";
    }

    @PostMapping(path = "/payment")
    public String processPayment(@RequestParam(defaultValue = "0") BigDecimal amount, HttpSession session, Model model) {
        Purchase purchase = (Purchase) session.getAttribute("purchase");
        BigDecimal price = (BigDecimal) session.getAttribute("price");

        if (price != null && purchase != null) {
            if (price.compareTo(amount) <= 0) {
                purchase.setPaymentMethod(PaymentMethod.COINS);
                purchase.setDateTime(LocalDateTime.now());
                purchase.setPrice(price);
                purchase.setStatus(OrderStatus.FINALIZED);

                Set<ConstraintViolation<Purchase>> violations = validator.validate(purchase);
                if (!violations.isEmpty()) {
                    List<String> errorMessages = violations.stream()
                            .map(ConstraintViolation::getMessage)
                            .collect(Collectors.toList());
                    model.addAttribute("errors", errorMessages);
                } else {
                    StockItem stockItem = purchase.getStockItem();
                    stockItem.setQuantity(stockItem.getQuantity() > 0 ? stockItem.getQuantity() - 1 : 0);
                    stockItemRepository.save(stockItem);

                    Purchase savedPurchase = purchaseRepository.save(purchase);
                    model.addAttribute("purchase", savedPurchase);

                    model.addAttribute("formatter", DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
                    return "paymentConfirmation";
                }
            }
        } else {
            return "redirect:keypad";
        }

        return "redirect:payment";
    }
}
