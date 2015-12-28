package by.gmlocge.journal.repository;


import by.gmlocge.journal.entity.security.Account;
import by.gmlocge.journal.entity.security.UserJournal;
import by.gmlocge.journal.repository.common.CrudExtRepository;

public interface IUserJournalRepository extends CrudExtRepository<UserJournal, Integer> {
    UserJournal findOneByAccounts(Account account);

}
