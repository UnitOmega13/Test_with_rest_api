package max.hruslov.Auditor;

import max.hruslov.model.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import max.hruslov.service.CurrentUserService;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<Participant> {

    private CurrentUserService currentUserService;

    @Autowired
    public void currentUserServiceDI(CurrentUserService currentUserService){
        this.currentUserService = currentUserService;
    }

    @Override
    public Optional<Participant> getCurrentAuditor() {
        return Optional.ofNullable(currentUserService.getCurrentUser());
    }
}
