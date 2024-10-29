package mx.ulsa.hendricklpsw.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Collection;
import java.util.Iterator;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
@EnableMethodSecurity
public class SpringSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {
        http.
                csrf(AbstractHttpConfigurer::disable);
        http.exceptionHandling((exceptionHandling) -> {
           exceptionHandling.accessDeniedPage("/403");
        });
        http
                .authorizeHttpRequests((httpRequests) -> {
                    httpRequests.requestMatchers(new AntPathRequestMatcher("/"))
                            .permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/home"))
                            .permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/Servicio"))
                            .permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/contactform"))
                            .permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/css/**"))
                            .permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/img/**"))
                            .permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/images/**"))
                            .permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/js/**"))
                            .permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/lib/**"))
                            .permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/WEB-INF/**"))
                            .permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/webapp/**"))
                            .permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/login"))
                            .permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/Registrar"))
                            .permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/saveUsuario"))
                            .permitAll()
                            /*
                            .requestMatchers(new AntPathRequestMatcher("/proyectos"))
                            .hasAuthority("ROLE_SUPERADMIN")
                            .requestMatchers(new AntPathRequestMatcher("/addProyecto"))
                            .hasAuthority("ROLE_SUPERADMIN")
                            .requestMatchers(new AntPathRequestMatcher("/saveProyecto"))
                            .hasAuthority("ROLE_SUPERADMIN")
                            .requestMatchers(new AntPathRequestMatcher("/editProyecto/{id}"))
                            .hasAuthority("ROLE_SUPERADMIN")
                            .requestMatchers(new AntPathRequestMatcher("/editSaveProyecto"))
                            .hasAuthority("ROLE_SUPERADMIN")
                            .requestMatchers(new AntPathRequestMatcher("/deleteProyecto/{id}"))
                            .hasAuthority("ROLE_SUPERADMIN")
                            .requestMatchers(new AntPathRequestMatcher("/roles"))
                            .hasAuthority("ROLE_SUPERADMIN")
                            .requestMatchers(new AntPathRequestMatcher("/addRol"))
                            .hasAuthority("ROLE_SUPERADMIN")
                            .requestMatchers(new AntPathRequestMatcher("/saveRol"))
                            .hasAuthority("ROLE_SUPERADMIN")
                            .requestMatchers(new AntPathRequestMatcher("/editRol/{id}"))
                            .hasAuthority("ROLE_SUPERADMIN")
                            .requestMatchers(new AntPathRequestMatcher("/editSaveRol"))
                            .hasAuthority("ROLE_SUPERADMIN")
                            .requestMatchers(new AntPathRequestMatcher("/deleteRol/{id}"))
                            .hasAuthority("ROLE_SUPERADMIN")
                            .requestMatchers(new AntPathRequestMatcher("/usuarios"))
                            .hasAuthority("ROLE_SUPERADMIN")
                            .requestMatchers(new AntPathRequestMatcher("/saveUsuario"))
                            .hasAuthority("ROLE_SUPERADMIN")
                            .requestMatchers(new AntPathRequestMatcher("/editUsuario/{id}"))
                            .hasAuthority("ROLE_SUPERADMIN")
                            .requestMatchers(new AntPathRequestMatcher("/editSaveUsuario"))
                            .hasAuthority("ROLE_SUPERADMIN")
                            .requestMatchers(new AntPathRequestMatcher("/deleteUsuario/{id}"))
                            .hasAuthority("ROLE_SUPERADMIN")
                            .requestMatchers(new AntPathRequestMatcher("/saveRol"))
                            .hasAuthority("ROLE_SUPERADMIN")
                             */
                            .anyRequest()
                            .authenticated();

                })
                .formLogin((formLogin) -> {
                    ((FormLoginConfigurer)((FormLoginConfigurer)formLogin.loginPage("/login").loginProcessingUrl("/login")).successHandler((request, response, authentication) -> {
                        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
                        Iterator var4 = authorities.iterator();

                        while (var4.hasNext()){
                            GrantedAuthority authority = (GrantedAuthority) var4.next();
                            if (authority.getAuthority().equals("ROLE_SUPERADMIN")){
                                response.sendRedirect("/roles");
                            }else {
                                response.sendRedirect("/");
                            }
                        }
                    })).permitAll();
                    /*
                    formLogin.loginPage("/login")
                            .loginProcessingUrl("/login")
                            .defaultSuccessUrl("/",true)
                            .permitAll();
                     */
                })
                .logout((logout) -> {
                    logout.logoutUrl("/logout")
                            .logoutSuccessUrl("/")
                            .permitAll();
                });
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
