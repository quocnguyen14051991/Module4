package com.quocnguyen.config;

import com.quocnguyen.entity.UserEntity;
import com.quocnguyen.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public AuditorAware<UserEntity> auditorProvider() {

        return new AuditorAwareImpl();
    }

    public static class AuditorAwareImpl implements AuditorAware<UserEntity> {
        @Autowired
        private UserEntityRepository userEntityRepository;

        @Override
        public Optional<UserEntity> getCurrentAuditor() {
            String userName = SecurityContextHolder.getContext().getAuthentication().getName();
            return Optional.ofNullable(userEntityRepository.findUserEntitiesByUserName(userName));
        }
    }
}
