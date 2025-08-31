package com.ort.howlingwolf.fw.security

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.ProviderManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.access.AccessDeniedHandler
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource


/**
 * see https://qiita.com/rubytomato@github/items/6c6318c948398fa62275
 */
@ConfigurationProperties(prefix = "security")
class HowlingWolfSecurityConfig(
    private val authenticationProvider: HowlingWolfAuthenticationProvider
) {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    // CORSを許可するドメイン
    lateinit var corsClientUrls: List<String>

    // ===================================================================================
    //                                                                             Execute
    //                                                                           =========
    @Bean
    @Throws(Exception::class)
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            // AUTHORIZE
            .authorizeHttpRequests { authz ->
                authz
                    // TODO うまく動作させられていないので調査
                    // LoginFilterあたり？
                    // .requestMatchers("/admin/**").hasRole("ADMIN")
                    .anyRequest().permitAll()
            }
            .formLogin {
                it.disable()
            }
            // EXCEPTION
            .exceptionHandling { exceptions ->
                exceptions
                    .authenticationEntryPoint(authenticationEntryPoint())
                    .accessDeniedHandler(accessDeniedHandler())
            }
            // CSRF
            .csrf { csrf -> csrf.disable() }
            // CORS
            .cors { cors -> cors.configurationSource(getCorsConfigurationSource()) }
            .build()
    }

    internal fun authenticationEntryPoint(): AuthenticationEntryPoint {
        return HowlingWolfAuthenticationEntryPoint()
    }

    internal fun accessDeniedHandler(): AccessDeniedHandler {
        return HowlingWolfAccessDeniedHandler()
    }

    @Bean
    @Throws(Exception::class)
    fun authenticationManager(): AuthenticationManager {
        return ProviderManager(authenticationProvider)
    }

    /**
     * see https://rennnosukesann.hatenablog.com/entry/2019/09/18/235731
     */
    private fun getCorsConfigurationSource(): CorsConfigurationSource {
        val corsConfiguration = CorsConfiguration()

        // CORSを許可するURLの登録(Access-Control-Allow-Origin) - Spring Boot 3対応
        this.corsClientUrls.forEach { corsConfiguration.addAllowedOriginPattern(it) }

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