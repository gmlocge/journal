package by.gmlocge.journal.service;

import by.gmlocge.journal.entity.Device;
import by.gmlocge.journal.entity.security.UserJournal;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Transactional(readOnly = true)

public interface IServiceData {

    List<Device> findAllDevices();

}
