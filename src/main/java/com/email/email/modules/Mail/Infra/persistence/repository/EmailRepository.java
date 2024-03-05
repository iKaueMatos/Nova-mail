/**
 * ----------------------------------------------------------------------------
 * Autor: Kaue de Matos
 * Empresa: Nova Software
 * Propriedade da Empresa: Todos os direitos reservados
 * ----------------------------------------------------------------------------
 */
package com.email.email.modules.Mail.Infra.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.email.email.modules.Mail.Infra.persistence.entity.EmailEntity;

public interface EmailRepository extends JpaRepository<EmailEntity, Long> { }
