package com.book.manager.security

import com.book.manager.domain.enum.RoleType
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.JdbcUserDetailsManager
import org.springframework.security.provisioning.UserDetailsManager
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import javax.sql.DataSource


@EnableWebSecurity
@Configuration
class SecurityConfig {

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain? {
        http.formLogin { login ->
            login
                .loginProcessingUrl("/login") // ログイン処理のパス
                .usernameParameter("email")
                .passwordParameter("pass")
                .successHandler(BookManagerAuthenticationSuccessHandler())
                .failureHandler(BookManagerAuthenticationFailureHandler())
        }.exceptionHandling { exception ->
            exception
                .authenticationEntryPoint(BookManagerAuthenticationEntryPoint())
                .accessDeniedHandler(BookManagerAccessDeniedHandler())
        }.authorizeRequests { authz ->
            authz
                .mvcMatchers("/login").permitAll() // 直リンクOK
                .mvcMatchers("/admin/**").hasAuthority(RoleType.ADMIN.toString()) // 権限制御
                .anyRequest().authenticated()
        }.cors {
            it.configurationSource(corsConfigurationSource())
        }
        http.csrf().disable()
        return http.build()
    }

    private fun corsConfigurationSource(): CorsConfigurationSource {
        val corsConfiguration = CorsConfiguration()
        corsConfiguration.addAllowedMethod(CorsConfiguration.ALL)
        corsConfiguration.addAllowedHeader(CorsConfiguration.ALL)
        corsConfiguration.addAllowedOrigin("http://localhost:8081")
        corsConfiguration.allowCredentials = true

        val corsConfigurationSource = UrlBasedCorsConfigurationSource()
        corsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration)

        return corsConfigurationSource
    }

    @Bean
    fun users(dataSource: DataSource?): UserDetailsManager? {
        val userQuery = "select email,password,true from user where email = ?"
        val authoritiesQuery = "select email,role_type from user where email = ?"
        val users = JdbcUserDetailsManager(dataSource)
        users.usersByUsernameQuery = userQuery
        users.setAuthoritiesByUsernameQuery(authoritiesQuery)
        return users
    }
}
