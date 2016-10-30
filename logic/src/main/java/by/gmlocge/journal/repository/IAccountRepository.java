package by.gmlocge.journal.repository;


import by.gmlocge.journal.entity.security.Account;
import by.gmlocge.journal.repository.common.CrudExtRepository;

public interface IAccountRepository extends CrudExtRepository<Account, Integer> {
    Account findOneByLogin(String login);
    Account findOneByEmail(String email);

}
