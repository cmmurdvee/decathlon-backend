package ee.murdvee.decathlon.repository;

import ee.murdvee.decathlon.entity.Athlete;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AthleteRepository extends JpaRepository<Athlete, Long> {

    Page<Athlete> findAllByCountry(Pageable pageable, String country);

    @Query("SELECT DISTINCT a.country FROM Athlete a ORDER BY a.country")
    List<String> findDistinctCountries();
}
