package com.springbootJpa.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Member {
    /**
     * 실무에서는 Entity에는 Setter를 사용하는 것을 추천 안함
     * DTO <-> Entity 변환
     * ModelMapper
     * MapStruct
     * Builder
     */

    @Id
    @GeneratedValue
    private Long id;
    private String username;
}
