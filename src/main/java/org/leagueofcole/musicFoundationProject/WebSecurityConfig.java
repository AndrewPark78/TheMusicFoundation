package org.leagueofcole.musicFoundationProject;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/login", "/console").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/images/*").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .successHandler(new RefererRedirectionAuthenticationSuccessHandler())
                .permitAll()
                .and()
            .logout()
            		.permitAll();
    }
    

//    
//    public void configureAuth(AuthenticationManagerBuilder auth) throws Exception{
//			auth.inMemoryAuthentication().
//				withUser("User")
//				.password("Password")
//				.roles("USER");
//	
//
//    }

   
}