package by.gmlocge.journal.repository;


import by.gmlocge.journal.entity.Org;
import by.gmlocge.journal.repository.common.CrudExtRepository;

public interface IOrgRepository extends CrudExtRepository<Org, Integer> {
    Org findOneByName(String name);

}
