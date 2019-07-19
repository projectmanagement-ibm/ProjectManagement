//package com.example.projectv1.config;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
////@Configuration
////@EnableWebSecurity
////public class SecurityConfig extends WebSecurityConfigurerAdapter {
////
////	@Autowired
////	private DataSource securityDataSource;
////
////	@Override
////	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////		// TODO Auto-generated method stub
////		super.configure(auth);
////		
//////		auth.jdbcAuthentication().dataSource(securityDataSource);
////
////	}
////
////	@Override
////	protected void configure(HttpSecurity http) throws Exception {
////		// TODO Auto-generated method stub
////		super.configure(http);
////		
////		http.authorizeRequests()
////		.antMatchers("/dashboard").hasRole("USER")
////		.antMatchers("/users/**").hasRole("MANAGER")
////		.antMatchers("/projects/**").hasRole("MANAGER")
////		.antMatchers("/tasks/**").hasRole("MANAGER")
////		.anyRequest().authenticated()
////		.and()
////		.formLogin()
////		.loginPage("/login")
////		.loginProcessingUrl("/authenticateTheUser")
////		.permitAll();
//////		.and().logout().permitAll()
//////		.and()
//////		.exceptionHandling().accessDeniedPage("/access-denied");	
//////		
////	}
////	
////	
////}
//
//
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
// 
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth)
//      throws Exception {
////        auth
////          .inMemoryAuthentication()
////          .withUser("user")
////            .password("{noop}password")
////            .roles("USER")
////            .and()
////          .withUser("admin")
////            .password("{noop}admin")
////            .roles("USER", "ADMIN");
//    }
// 
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        
//        
//		http.authorizeRequests()
//		.antMatchers("/dashboard").hasRole("USER")
//		.antMatchers("/users/**").hasRole("ADMIN")
//		.antMatchers("/projects/**").hasRole("ADMIN")
//		.antMatchers("/tasks/**").hasRole("ADMIN")
//		.anyRequest().authenticated()
//		.and()
//		.formLogin()
//		.loginPage("/login")
//		.loginProcessingUrl("/authenticateTheUser")
//		.permitAll();
////		.and().logout().permitAll()
////		.and()
////		.exceptionHandling().accessDeniedPage("/access-denied");
//        
//    }
//}