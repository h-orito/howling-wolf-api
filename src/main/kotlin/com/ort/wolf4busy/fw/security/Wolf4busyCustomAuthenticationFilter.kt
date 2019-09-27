package com.ort.wolf4busy.fw.security

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


class Wolf4busyCustomAuthenticationFilter : UsernamePasswordAuthenticationFilter() {

    override fun attemptAuthentication(request: HttpServletRequest,
                                       response: HttpServletResponse?): Authentication {
        try {
            val principal = ObjectMapper().readValue(request.inputStream,
                    Wolf4busyPrincipal::class.java)
            val authRequest = UsernamePasswordAuthenticationToken(
                    principal, null)
            setDetails(request, authRequest)
            return this.authenticationManager.authenticate(authRequest)
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    override fun successfulAuthentication(req: HttpServletRequest,
                                          res: HttpServletResponse,
                                          chain: FilterChain,
                                          auth: Authentication) {
        SecurityContextHolder.getContext().authentication = auth
    }
}