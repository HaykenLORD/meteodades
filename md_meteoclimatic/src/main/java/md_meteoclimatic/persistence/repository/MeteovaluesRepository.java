package md_meteoclimatic.persistence.repository;

import md_meteoclimatic.persistence.entity.Meteovalues;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeteovaluesRepository extends JpaRepository<Meteovalues,Long> {
}
