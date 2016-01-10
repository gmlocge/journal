package by.gmlocge.journal.service;

import by.gmlocge.journal.entity.Device;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface IServiceData {

    List<Device> findAllDevices();

}
