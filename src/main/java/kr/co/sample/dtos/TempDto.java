package kr.co.sample.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TempDto {

    @NotNull
    private Long id;
}
