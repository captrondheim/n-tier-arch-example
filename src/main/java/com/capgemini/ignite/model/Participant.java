package com.capgemini.ignite.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
@Entity(name = "Product")
public class Participant {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    @Column(name = "id", columnDefinition = "UUID", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "role")
    private Role role;

    public static Participant newInstance(String name, int age, Role role) {
        return new Participant(
                UUID.randomUUID(),
                name,
                age,
                role
        );
    }

}
