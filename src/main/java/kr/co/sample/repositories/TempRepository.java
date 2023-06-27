package kr.co.sample.repositories;

import kr.co.sample.entitys.TempEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TempRepository extends JpaRepository<TempEntity, Long> {

    @Query("""
            select t.id 
            from TempEntity t 
            where t.id = :id
            """)
    TempEntity findByIdForQuery(Long id);
}
