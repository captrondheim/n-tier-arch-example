package com.capgemini.ignite.controller.entities;

import com.capgemini.ignite.model.Participant;

import java.util.List;

public record ParticipantsResponse(List<ParticipantResponse> participants) {

    public static ParticipantsResponse from(List<Participant> participants) {
        return ParticipantResponse.from(participants);
    }
}
