package ee.murdvee.decathlon.dto;

import lombok.Data;

@Data
public class Judge {
    private String id;
    private String firstName;
    private String lastName;
    private String country;
    private Boolean certified;
}
