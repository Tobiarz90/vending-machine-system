package pl.coderslab.vendingmachinesystem.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/admin")
@Secured("ROLE_ADMIN")
public class AdminPanelController {
}
