package com.bushansirgur.moneymanager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_profiles")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;

    @Column(unique = true)
    private String email;

    private String password;
    private String profileImageUrl;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp

    private LocalDateTime updatedAt;
    private Boolean isActive;
    private String activationToken;

    @Version
    private Integer version;

    @PrePersist
    public void prePersist() {
        if (this.isActive == null) {
            this.isActive = false;
        }
        if (this.version == null) {
            this.version = 0;
        }
    }

}
