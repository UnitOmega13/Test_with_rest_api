package max.hruslov.repository;

import max.hruslov.model.Conference;
import max.hruslov.model.Participant;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConferenceRepository extends PagingAndSortingRepository<Conference, Long> {

    Conference findConferenceByConferenceID(long conferenceID);

    List<Conference> findAllByName(String name, Pageable pageable);

}
