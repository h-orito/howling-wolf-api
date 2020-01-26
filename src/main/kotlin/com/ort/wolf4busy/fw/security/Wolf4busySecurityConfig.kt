package com.ort.wolf4busy.fw.security

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.security.web.access.AccessDeniedHandler
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

/**
 * see https://qiita.com/rubytomato@github/items/6c6318c948398fa62275
 */
@EnableWebSecurity
@ConfigurationProperties(prefix = "security")
class Wolf4busySecurityConfig() : WebSecurityConfigurerAdapter() {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // CORSを許可するドメイン
    lateinit var corsClientUrls: List<String>

    // ===================================================================================
    //                                                                             Execute
    //                                                                           =========
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
            // CORS
            .cors()
            .configurationSource(getCorsConfigurationSource())
    }

    internal fun authenticationEntryPoint(): AuthenticationEntryPoint {
        return Wolf4busyAuthenticationEntryPoint()
    }

    internal fun accessDeniedHandler(): AccessDeniedHandler {
        return Wolf4busyAccessDeniedHandler()
    }

    /**
     * see https://rennnosukesann.hatenablog.com/entry/2019/09/18/235731
     */
    private fun getCorsConfigurationSource(): CorsConfigurationSource {
        val corsConfiguration = CorsConfiguration()

        // CORSを許可するURLの登録(Access-Control-Allow-Origin)
        this.corsClientUrls.forEach { corsConfiguration.addAllowedOrigin(it) }

        // 許可するHeaderの登録(Access-Control-Allow-Headers)
        corsConfiguration.addAllowedHeader(CorsConfiguration.ALL)

        // 許可するMethodの登録(Access-Control-AllowMethods)
        corsConfiguration.addAllowedMethod(CorsConfiguration.ALL)

        // 認証情報送信許可の登録(Access-Control-Allow-Credentials)
        corsConfiguration.allowCredentials = true

        val corsSource = UrlBasedCorsConfigurationSource()

        // どのパスに上記ルールを適用するか
        corsSource.registerCorsConfiguration("/**", corsConfiguration)

        return corsSource
    }
}