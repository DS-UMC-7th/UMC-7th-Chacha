package umc.spring.domain.member;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    @Column(nullable = false, length = 100)
    private String city;
    @Column(nullable = false, length = 100)
    private String street;
    @Column(nullable = false, length = 100)
    private String zipcode;
}
