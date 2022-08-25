package com.example.usersapp.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
//@EnableAutoConfiguration
//@EnableGlobalMethodSecurity(prePostEnabled = true)

public class SecurityConfig {


    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
//        return new BCryptPasswordEncoder(15, new SecureRandom());
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll()

                .anyRequest().permitAll()
                .and().formLogin().disable().csrf().disable();



//        http.authorizeRequests((auth) -> auth.anyRequest().authenticated())
//                .httpBasic(withDefaults())
//                .csrf().disable();



//        http
//                .httpBasic()
//                .and()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.DELETE, "/user/delete/{id}").hasRole("ADMIN") // Admin should be able to delete
//                .antMatchers(HttpMethod.PUT, "/user/update").hasRole("ADMIN") // Admin should be able to update
//                .antMatchers(HttpMethod.POST,"/user/add").hasAnyRole("ADMIN", "OPERATION") // Admin and OPERATION should be able to add
//                .antMatchers("/user/all").hasAnyRole("ADMIN", "OPERATION","CLIENT") // All three users should be able to get all users.
//                .anyRequest()
//                .authenticated()
//                .and()
//                .csrf()
//                .disable();
        return http.build();
    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));

        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                "Accept", "Authorization", "Origin, Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));

        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));

        corsConfiguration.setAllowedMethods(Arrays.asList("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH"));
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }


}








//
//    @Bean
//    public CorsFilter corsFilter(){
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//
//        corsConfiguration.setAllowedMethods(Collections.singletonList("GET,POST"));
//        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
//        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
//
//        return new CorsFilter(urlBasedCorsConfigurationSource);
//    }

//    @Override
//    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//        // authentication manager (see below)
//        auth.inMemoryAuthentication()
//                .withUser("foo")
//                .password("$2a$15$p8LilglG79qMGKN6UWfFNeLwe9zk94C74viJza7a1dKn0LaZdw52K")
//                .roles("USER")
//                .and()
//                .withUser("admin")
//                .password("$2a$15$VWLm9jB1ra4WdB2jSbzGaO5.LCFTiVMlPC0QaL.65r.I2eHQ76rFu")
//                .roles("ADMIM");
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/admin").hasRole("ADMIN")
//                .antMatchers("/user").hasAnyRole("USER", "ADMIN")
//                .antMatchers("/").permitAll()
//                .and()
//                .formLogin();
//    }


//    @Resource
//    private UserDetailsService userDetailsService;
//    @Bean
//    public DaoAuthenticationProvider authProvider() {
//        System.out.println("authProvider");
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService);
//        authProvider.setPasswordEncoder(passwordEncoder());
//
//        return authProvider;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        System.out.println("PasswordEncoder: ");
//
//        return new BCryptPasswordEncoder();
//    }
//

//     @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests((authz) -> authz
//                        .anyRequest().authenticated()
//                )
//                .httpBasic(withDefaults());
//        return http.build();
//    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
//                .formLogin(form -> form.loginPage("/login")
//                        .loginProcessingUrl("/authenticateLogin").permitAll());
//        return http.build();
//    }

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails theUser = User.withUsername("Reza")
//                .password("{noop}reza").roles("USER").build();
//        UserDetails theManager = User.withUsername("frobese")
//                .password("{noop}frobese").roles("MANAGER").build();
//        UserDetails theAdmin = User.withUsername("admin")
//                .password("{noop}admin").roles("ADMIN").build();
//        return new InMemoryUserDetailsManager(theAdmin,theManager,theUser);
//
//    }


//    @Bean
//    public UserDetailsManager users(DataSource dataSource) {
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build();
//        JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//        users.createUser(user);
//        return users;
//    }

