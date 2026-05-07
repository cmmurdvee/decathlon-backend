package ee.murdvee.decathlon.controller;

import ee.murdvee.decathlon.entity.Athlete;
import ee.murdvee.decathlon.entity.Result;
import ee.murdvee.decathlon.repository.AthleteRepository;
import ee.murdvee.decathlon.service.AthleteService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class AthleteController {

    private AthleteRepository athleteRepository;
    private AthleteService athleteService;

    @GetMapping("athletes")
    public Page<Athlete> getAthletes(Pageable pageable,
                                     @RequestParam(required = false) String country) {
        if (country == null || country.isBlank()) {
            return athleteRepository.findAll(pageable);
        }
        return athleteRepository.findAllByCountry(pageable, country);
    }

    @GetMapping("athletes/countries")
    public List<String> getCountries() {
        return athleteRepository.findDistinctCountries();
    }

    @PostMapping("athletes")
    public Athlete addAthlete(@RequestBody Athlete athlete) {
        athleteService.validateAthlete(athlete);
        return athleteRepository.save(athlete);
    }

    @DeleteMapping("athletes/{id}")
    public void deleteAthlete(@PathVariable Long id) {
        athleteRepository.deleteById(id);
    }

    @PostMapping("athletes/{id}/results")
    public Athlete addResult(@PathVariable Long id, @RequestBody Result result) {
        return athleteService.addResult(id, result);
    }

    @GetMapping("athletes/{id}/total")
    public Athlete getTotalPoints(@PathVariable Long id) {
        return athleteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sportlast ID-ga " + id + " ei leitud"));
    }
}
