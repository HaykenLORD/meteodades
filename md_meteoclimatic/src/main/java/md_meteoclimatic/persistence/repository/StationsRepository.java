package md_meteoclimatic.persistence.repository;

import md_meteoclimatic.persistence.entity.Stations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationsRepository extends JpaRepository<Stations,Long> {
}
