package kr.co.sample.entitys;

import jakarta.persistence.*;
import kr.co.sample.entitys.common.BaseTimeEntity;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

@Getter
@Entity
@Builder
@ToString
@DynamicInsert
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "temp")
public class TempEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ColumnDefault("'N'")
    @Builder.Default
    private String deletedFlag = "N";
}
