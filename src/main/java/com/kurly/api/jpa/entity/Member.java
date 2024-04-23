package com.kurly.api.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * packageName    : com.kurly.api.jpa.entity
 * fileName       : Member
 * author         : hagjoon
 * date           : 2024-04-23
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2024-04-23        hagjoon       최초 생성
 */
@Entity
public class Member {

    @Id
    private Long memberId;
}
