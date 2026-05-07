package ee.murdvee.decathlon.dto;

import lombok.Data;

@Data
public class CompetitionLocation {
    private String id;
    private String name;
    private String city;
    private String country;
    private Integer capacity;
}
