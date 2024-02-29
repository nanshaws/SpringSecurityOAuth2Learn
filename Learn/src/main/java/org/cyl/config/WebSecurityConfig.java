package org.cyl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

//    @Bean
//    public UserDetailsService userDetailsService(){
//        InMemoryUserDetailsManager manager=new InMemoryUserDetailsManager();
//        manager.createUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build());
//        return manager;
//    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(
                authorize->authorize
//                        .requestMatchers("/user/list").hasAuthority("USER_LIST")
//                        .requestMatchers("/user/add").hasAuthority("USER_ADD")
                        .requestMatchers("/user/**").hasRole("ADMIN")
                        .requestMatchers("/register","/index.html").permitAll()
                        .anyRequest()
                        .authenticated()
        );
        http.formLogin(form->{
            form.loginPage("/login").permitAll()
                    .successHandler(new MyAuthenticationSuccessHandler()) //认证成功时的处理
                    .failureHandler(new MyAuthenticationFailureHandler());


        });
        http.logout(logout->{
            logout.logoutSuccessHandler(new MyLogoutSuccessHandler());
        });
        http.exceptionHandling(exception->{
            exception.authenticationEntryPoint(new MyAuthenticationEntryPoint());
            exception.accessDeniedHandler(new MyAccessDeniedHandler());
        });

        http.sessionManagement(session->{
            session.maximumSessions(1).expiredSessionStrategy(new MySessionInformationExpiredStrategy());
        });
        http.cors(Customizer.withDefaults());
        http.csrf(csrf->csrf.disable());

        return http.build();
    }

}
