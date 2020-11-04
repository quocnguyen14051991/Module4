package com.quocnguyen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfig {
    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }

    public static class AuditorAwareImpl implements AuditorAware<String> {

        @Override
        // spring scrurity chứa thong tin còn auditing lấy thông tin từ spring khi có 1 sự thay đổitrong database

        public Optional<String> getCurrentAuditor() {
            Authentication authentication =SecurityContextHolder.getContext().getAuthentication();
            if(authentication==null)
            {
                return null;
            }
            return Optional.ofNullable(authentication.getName());
//            String usernam
//            e=SecurityContextHolder.getContext().getAuthentication().getName();
//            return Optional.empty();
        }
    }
}
