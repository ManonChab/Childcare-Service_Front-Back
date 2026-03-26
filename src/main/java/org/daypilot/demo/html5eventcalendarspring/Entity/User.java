package org.daypilot.demo.html5eventcalendarspring.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "first_name cannot be empty")
    @Column(name="firstName", nullable = false)
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String firstName;

    @NotBlank(message = "LastName cannot be empty")
    @Column(name="last_name", nullable = false)
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 6, max = 200, message = "Password must be between 6 and 200 characters")
    @Column(nullable = false)
    private String password;

    @NotBlank(message = "Email cannot be empty")
    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    @Size(max = 150, message = "Address must not exceed 150 characters")
    private String address;

    @Column(nullable = false)
    private String phone;

    // @JsonIgnore
    // // @OneToMany(mappedBy="user", cascade= CascadeType.ALL)
    // private Integer childrenCount;

    @JsonIgnore
    @OneToMany(mappedBy="user", cascade= CascadeType.ALL)
    private List<Event> events = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Role role;

}
