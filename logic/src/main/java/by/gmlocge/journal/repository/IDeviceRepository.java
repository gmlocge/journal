package by.gmlocge.journal.repository;


import by.gmlocge.journal.entity.Device;
import by.gmlocge.journal.repository.common.CrudExtRepository;

public interface IDeviceRepository extends CrudExtRepository<Device, Integer> {
    Device findOneByName(String name);

}
