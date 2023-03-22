package com.nt.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class securityconfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource ds;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		
		 //using Db s/w as Authentication Info provider thorugh spring jdbc
		auth.jdbcAuthentication().dataSource(ds).passwordEncoder(new BCryptPasswordEncoder())
		.usersByUsernameQuery("SELECT UNAME,PWD,STATUS FROM USERS WHERE UNAME=?")
		.authoritiesByUsernameQuery("SELECT UNAME,ROLE FROM ADMIN.USER_ROLES WHERE UNAME=?");
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests().antMatchers("/home").permitAll()
                                                      .antMatchers("/login1").permitAll()
                                                      .antMatchers("/votting").authenticated()
                                                      .antMatchers("/register").permitAll()
                                                      .antMatchers("/register").permitAll()
                                                     // .anyRequest().authenticated()
              //.and().httpBasic()
               .and().formLogin()
               //.and().rememberMe()
               .and().logout()
              .and().exceptionHandling().accessDeniedPage("/denied")
              .and().sessionManagement().maximumSessions(20).maxSessionsPreventsLogin(true);
	}
}

