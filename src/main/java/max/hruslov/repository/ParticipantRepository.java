package max.hruslov.repository;

import max.hruslov.model.Participant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipantRepository extends CrudRepository<Participant,Long> {

    Participant findByName(String name);

    Participant findBySurName(String surName);

    Participant findAllByUserID(long userID);

}
