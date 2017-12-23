package com.websystique.springmvc.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class MessageBoardSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
				
		http.authorizeRequests()

		    //.antMatchers("/messageList*").hasRole("USER")
			//.antMatchers("/messagePost*").hasAnyRole("ADMIM","USER")
			//.antMatchers("/messageDelete*").hasRole("USER")
		
		.antMatchers("/messageList*").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
		.antMatchers("/messageDelete*").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
		.antMatchers("/messagePost*").access("hasRole('ROLE_USER')")
		.and()
				 .formLogin().
				 loginPage("/login.jsp")
				 .loginProcessingUrl("/j_spring_security_check")
				 .usernameParameter("j_username")
		          .passwordParameter("j_password")
				 .defaultSuccessUrl("/messageList")
				 .failureUrl("/login.jsp?error=true")
				 //.failureUrl("/login.jsp") 
				 .and().
				 logout().
				 logoutSuccessUrl("/login.jsp") 
				 .and().rememberMe()
				 ;
				
			 http.csrf().disable();
			 
			 http.addFilterAfter(new CustomFilter(),BasicAuthenticationFilter.class );
	}

	
/*    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/").permitAll() 
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login.jsp")
                .permitAll()
                .and()
            .logout()                                    
                .permitAll();
		 http.csrf().disable();

    }*/

    // ...

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
/*		auth.inMemoryAuthentication().withUser("admin").password("secret").authorities("ROLE_ADMIN", "ROLE_USER").and()
				.withUser("user1").password("1111").authorities("ROLE_USER");
*/
		auth.inMemoryAuthentication().withUser("admin").password("secret").roles("ADMIN").and()
		.withUser("user1").password("1111").roles("USER");

	}
}
