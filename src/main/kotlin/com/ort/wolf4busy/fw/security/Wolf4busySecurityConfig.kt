package com.ort.wolf4busy.fw.security

import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.security.web.access.AccessDeniedHandler

/**
 * see https://qiita.com/rubytomato@github/items/6c6318c948398fa62275
 */
@EnableWebSecurity
class Wolf4busySecurityConfig() : WebSecurityConfigurerAdapter() {

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {

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
                // CSRF
                .csrf()
                .disable()
    }

    internal fun authenticationEntryPoint(): AuthenticationEntryPoint {
        return Wolf4busyAuthenticationEntryPoint()
    }

    internal fun accessDeniedHandler(): AccessDeniedHandler {
        return Wolf4busyAccessDeniedHandler()
    }
}