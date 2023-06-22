package kr.co.sample.repositories;

import kr.co.sample.entitys.TempEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TempRepository extends JpaRepository<TempEntity, Long> {
}
