package by.gmlocge.journal.repository;


import by.gmlocge.journal.entity.security.UserJournal;
import by.gmlocge.journal.repository.common.CrudExtRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RepositoryRestResource(path = "rest")
public interface IUserJournalRepository extends CrudExtRepository<UserJournal, Long> {

    UserJournal findOneByUsername(String login);

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    List<UserJournal> findAll();
}
