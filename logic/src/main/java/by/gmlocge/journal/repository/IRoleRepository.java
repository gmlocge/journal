package by.gmlocge.journal.repository;


import by.gmlocge.journal.entity.security.Role;
import by.gmlocge.journal.repository.common.CrudExtRepository;

public interface IRoleRepository extends CrudExtRepository<Role, Integer> {
    Role findOneByName(String name);


}
