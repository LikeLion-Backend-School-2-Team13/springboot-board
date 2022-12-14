package com.likelion.springbootboard.domain.entity;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNum;
    @Column(unique = true,nullable = false)
    private String id;
    @NotNull
    private String password;
    @NotNull
    private String name;

}
