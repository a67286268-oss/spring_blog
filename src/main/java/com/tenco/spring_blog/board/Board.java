package com.tenco.spring_blog.board;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Table(name = "board_tb")
@Entity
public class Board {

    @Id // 이필드가 기본기 임을 나타냄
    // 기본키 값을 자동으로 생성(IDENTITY -> db기본 설정 따른다.) AUTO_INCREMENT 기능 사용
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 별도 어노테이션이 없으면 필드명이 컬럼명이 된다.
    private String title;
    private String content;
    private String username;
    private Timestamp createdAt;
}
