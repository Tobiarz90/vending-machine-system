package pl.coderslab.vendingmachinesystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.coderslab.vendingmachinesystem.services.AdminService;
import pl.coderslab.vendingmachinesystem.services.SpringDataAdminDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AdminService adminService;

    private final BCryptPasswordEncoder passwordEncoder;

    public SecurityConfig(AdminService adminService, PasswordEncoderConfig passwordEncoderConfig, BCryptPasswordEncoder passwordEncoder) {
        this.adminService = adminService;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public SpringDataAdminDetailsService customUserDetailsService() {
        return new SpringDataAdminDetailsService(adminService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/user/**").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .and().formLogin().loginPage("/login")//.defaultSuccessUrl("")
                .and().logout()//.logoutSuccessUrl("/")
                .and().exceptionHandling().accessDeniedPage("/403");
    }

}
