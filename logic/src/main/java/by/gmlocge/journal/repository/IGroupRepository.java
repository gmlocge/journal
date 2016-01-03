package by.gmlocge.journal.repository;


import by.gmlocge.journal.entity.security.Group;
import by.gmlocge.journal.entity.security.UserJournal;
import by.gmlocge.journal.repository.common.CrudExtRepository;

public interface IGroupRepository extends CrudExtRepository<Group, Integer> {
    Group findOneByName(String name);

}
