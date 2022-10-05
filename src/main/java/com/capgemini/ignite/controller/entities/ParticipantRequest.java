package com.capgemini.ignite.controller.entities;

import com.capgemini.ignite.model.Participant;
import com.capgemini.ignite.model.Role;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

public record ParticipantRequest(@NotBlank String name, @Max(value = 40) int age, Role role) {
    public Participant fromThis() {
        return Participant.newInstance(name, age, role);
    }

}
