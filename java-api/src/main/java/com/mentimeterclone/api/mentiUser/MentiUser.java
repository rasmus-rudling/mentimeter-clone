package com.mentimeterclone.api.mentiUser;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
public @Data class MentiUser {
    @Id
    @SequenceGenerator(
            name = "menti_user_sequence",
            sequenceName = "menti_user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "menti_user_sequence"
    )
    private Long id;
    private String username;
    private String email;

    public MentiUser(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public MentiUser() {

    }
}
