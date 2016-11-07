package by.gmlocge.journal.repository;


import by.gmlocge.journal.entity.Device;
import by.gmlocge.journal.repository.common.CrudExtRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface IDeviceRepository extends CrudExtRepository<Device, Integer> {
    Device findOneByName(String name);

}
