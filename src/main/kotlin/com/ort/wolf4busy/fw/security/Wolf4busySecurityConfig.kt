package com.ort.wolf4busy.fw.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.security.web.access.AccessDeniedHandler
import org.springframework.security.web.authentication.AuthenticationFailureHandler
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler
import org.springframework.security.web.csrf.CookieCsrfTokenRepository
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

/**
 * see https://qiita.com/rubytomato@github/items/6c6318c948398fa62275
 */
@EnableWebSecurity
class Wolf4busySecurityConfig() : WebSecurityConfigurerAdapter() {

    @Autowired
    lateinit var authenticationProvider: Wolf4busyCustomAuthenticationProvider

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {

        // JSONで受け付けたいので独自に定義
        val filter = Wolf4busyCustomAuthenticationFilter()
        filter.setRequiresAuthenticationRequestMatcher(AntPathRequestMatcher("/login", "POST"))
        filter.setAuthenticationManager(authenticationManagerBean())
        filter.setAuthenticationSuccessHandler(authenticationSuccessHandler())
        filter.setAuthenticationFailureHandler(authenticationFailureHandler())

        http
                // AUTHORIZE
                .authorizeRequests()
                .mvcMatchers("/admin/**")
                .hasRole("ADMIN")
                .anyRequest()
                .permitAll()
                .and()
                // EXCEPTION
                .exceptionHandling()
                .authenticationEntryPoint(authenticationEntryPoint())
                .accessDeniedHandler(accessDeniedHandler())
                .and()
                // LOGIN
//                .formLogin()
//                .loginProcessingUrl("/login").permitAll()
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .successHandler(authenticationSuccessHandler())
//                .failureHandler(authenticationFailureHandler())
//                .and()
                // LOGOUT
                .logout()
                .logoutUrl("/logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler(logoutSuccessHandler())
                //.addLogoutHandler(new CookieClearingLogoutHandler())
                .and()
                // CSRF
                .csrf()
                //.disable()
                .ignoringAntMatchers("/login", "/logout")
                .csrfTokenRepository(CookieCsrfTokenRepository())
                .and()
                .addFilter(filter)
    }

    @Autowired
    @Throws(Exception::class)
    fun configureGlobal(auth: AuthenticationManagerBuilder,
                        @Qualifier("wolf4busyUserDetailsService") userDetailsService: UserDetailsService,
                        passwordEncoder: PasswordEncoder) {
        auth.eraseCredentials(true)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder)
    }

    @Bean
    internal fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    internal fun authenticationEntryPoint(): AuthenticationEntryPoint {
        return Wolf4busyAuthenticationEntryPoint()
    }

    internal fun accessDeniedHandler(): AccessDeniedHandler {
        return Wolf4busyAccessDeniedHandler()
    }

    internal fun authenticationSuccessHandler(): AuthenticationSuccessHandler {
        return Wolf4busyAuthenticationSuccessHandler()
    }

    internal fun authenticationFailureHandler(): AuthenticationFailureHandler {
        return Wolf4busyAuthenticationFailureHandler()
    }

    internal fun logoutSuccessHandler(): LogoutSuccessHandler {
        return HttpStatusReturningLogoutSuccessHandler()
    }

    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth!!.authenticationProvider(authenticationProvider)
    }
}