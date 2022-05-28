package pl.coderslab.vendingmachinesystem.services;

import pl.coderslab.vendingmachinesystem.entities.Admin;

public interface AdminService {

    Admin findByUsername(String username);

    void saveAdmin(Admin admin);

}
