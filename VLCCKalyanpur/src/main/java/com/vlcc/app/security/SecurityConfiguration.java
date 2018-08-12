package com.vlcc.app.security;

public class SecurityConfiguration{
	
	 /*@Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	            .authorizeRequests()
	                .antMatchers("/", "/welcome").permitAll()
	                .anyRequest().authenticated()
	                .and()
	            .formLogin()
	                .loginPage("/index")
	                .permitAll()
	                .and()
	            .logout()
	                .permitAll();
	    }
	 
	 @Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
			auth
				.inMemoryAuthentication()
					.withUser("user").password("password").roles("USER");
		}
*/
}
