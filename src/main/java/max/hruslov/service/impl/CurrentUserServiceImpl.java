package max.hruslov.service.impl;

import lombok.RequiredArgsConstructor;
import max.hruslov.model.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import max.hruslov.repository.ParticipantRepository;
import max.hruslov.service.CurrentUserService;

@Service
@RequiredArgsConstructor
public class CurrentUserServiceImpl implements CurrentUserService {

    private ParticipantRepository participantRepository;

    @Autowired
    public void userRepositoryDI(ParticipantRepository participantRepository){
        this.participantRepository = participantRepository;
    }

    @Override
    public Participant getCurrentUser() {
        return participantRepository.findAllByUserID(1L);
    }
}
