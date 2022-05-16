package pl.coderslab.vendingmachinesystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class VendingMachineSystemApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(VendingMachineSystemApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(VendingMachineSystemApplication.class);
    }
}
