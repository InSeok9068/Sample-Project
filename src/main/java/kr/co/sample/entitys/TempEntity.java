package kr.co.sample.entitys;

import jakarta.persistence.*;
import kr.co.sample.entitys.common.BaseTimeEntity;
import lombok.*;

@Getter
@Entity
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "temp")
public class TempEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
