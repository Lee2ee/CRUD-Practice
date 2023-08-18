package com.springboot.crudP1.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends TimeEntity {
    @Id @GeneratedValue
    private Long id;

    @Column(length = 10, nullable = false)
    private String writer;

    @Column(length =100, nullable = false)
    private String title;

    @Column(columnDefinition = "Text", nullable = false)
    private String content;

    @Builder
    public Board(Long id, String writer, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
