package by.gmlocge.journal.service;

import by.gmlocge.journal.entity.Device;
import by.gmlocge.journal.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ServiceData implements IServiseData {
    private static final Logger logger = LoggerFactory.getLogger(ServiceData.class);

    @Autowired
    private IDeviceRepository daoDevice;
    @Autowired
    private IOrgRepository daoOrg;
    @Autowired
    private IServeRepository daoServe;
    @Autowired
    private IUserJournalRepository daoUser;

    @Override
    public List<Device> findAllDevices() {
        return daoDevice.findAll();
    }

//    @Autowired
//    public ServiceData(@Value("${usogdp.road.nameForSearch}") String bchRoadName) {
//        this.bchRoadName = bchRoadName;
//    }

}
