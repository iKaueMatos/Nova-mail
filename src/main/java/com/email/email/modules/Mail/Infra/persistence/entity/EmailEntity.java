/**
 * ----------------------------------------------------------------------------
 * Autor: Kaue de Matos
 * Empresa: Nova Software
 * Propriedade da Empresa: Todos os direitos reservados
 * ----------------------------------------------------------------------------
 */
package com.email.email.modules.Mail.Infra.persistence.entity;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;

import com.email.email.common.Enum.mail.SendStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "email")
@EqualsAndHashCode(of = "id")
public class EmailEntity {

    @Id
    @Column(name = "idEmail")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmail;

    @Column(name = "nome")
    private String name;

    @Column(name = "sobrenome")
    private String firstName;

    @Column(name = "email", unique = true)
    private String email;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "envio", unique = true)
    private SendStatus send;

    @CreatedDate
    @Column(name = "data_envio", unique = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateSend;
}
