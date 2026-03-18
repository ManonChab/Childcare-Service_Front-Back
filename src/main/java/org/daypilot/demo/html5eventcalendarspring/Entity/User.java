package org.daypilot.demo.html5eventcalendarspring.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @NotBlank(message = "Name cannot be empty")
    @Column(name="name", nullable = false)
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @NotBlank(message = "LastName cannot be empty")
    @Column(name="last_name", nullable = false)
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    @NotBlank(message = "Username cannot be empty")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    @Column(name="user_name", unique = true, nullable = false, length = 50)
    private String userName;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 6, max = 200, message = "Password must be between 6 and 200 characters")
    @Column(nullable = false)
    private String password;

    @NotBlank(message = "Email cannot be empty")
    @Column(unique = true, nullable = true)
    private String email;

    @Column(nullable = false)
    @Size(max = 150, message = "Adress must not exceed 150 characters")
    private String adress;

    @Column(nullable = false)
    private int children_id;

    @Column
    private int event_id;

    @Column(nullable = false)
    private String color;

}
