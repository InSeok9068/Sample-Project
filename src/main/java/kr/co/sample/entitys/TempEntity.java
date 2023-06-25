package kr.co.sample.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.sample.entitys.common.BaseTimeEntity;
import lombok.*;

@Getter
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "temp")
public class TempEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue
    private Long id;
}
