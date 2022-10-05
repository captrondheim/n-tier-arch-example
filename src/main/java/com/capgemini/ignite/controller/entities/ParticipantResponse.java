package com.capgemini.ignite.controller.entities;

import com.capgemini.ignite.model.Participant;
import com.capgemini.ignite.model.Role;

import java.util.List;
import java.util.UUID;

public record ParticipantResponse(UUID id, String name, int age, Role role) {

    public static ParticipantResponse from(Participant participant) {
        return new ParticipantResponse(
                participant.getId(),
                participant.getName(),
                participant.getAge(),
                participant.getRole()
        );
    }

    public static ParticipantsResponse from(List<Participant> participants) {
        return new ParticipantsResponse(participants.stream()
                .map(ParticipantResponse::from)
                .toList());
    }
}
