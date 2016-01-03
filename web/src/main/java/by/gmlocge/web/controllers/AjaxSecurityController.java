package by.gmlocge.web.controllers;

import by.gmlocge.journal.entity.Device;
import by.gmlocge.journal.entity.security.UserJournal;
import by.gmlocge.journal.service.ISecurityManage;
import by.gmlocge.journal.service.IServiseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/ajax/denied")
public class AjaxSecurityController {
    private static final Logger logger = LoggerFactory.getLogger(AjaxSecurityController.class);

    @Autowired
    IServiseData serviseData;
    @Autowired
    ISecurityManage securityManage;

    @ResponseBody
    @RequestMapping(value = "/devices/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Device> findAllDevices() {
        return serviseData.findAllDevices();
    }

    @ResponseBody
    @RequestMapping(value = "/users/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    public List<UserJournal> usersall() {
        return securityManage.findAllUsers();
    }
//
//    @ResponseBody
//    @RequestMapping(value = "/forecast", method = RequestMethod.GET, produces = "application/json")
//    public ForecastVO forecast(@RequestParam("id") Integer id) {
//        return getServiseData().getForecastById(id);
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/forecast/delete/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public String deleteForecasts(@PathVariable int id) {
//        return getServiseData().deleteForecast(id);
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/forecasts", method = RequestMethod.GET, produces = "application/json")
//    public List<ForecastVO> getForecasts() {
//        return getServiseData().getForecasts();
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/lastforecast", method = RequestMethod.GET, produces = "application/json")
//    public ForecastVO getLastForecast() {
//        ForecastVO lastfForecast = getServiseData().getLastForecast();
//        return lastfForecast;
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/districts", method = RequestMethod.GET, produces = "application/json")
//    public List<DistrictVO> getDistricts() {
//        List<DistrictVO> list = serviseData.getDistricts();
//        return list;
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/stations", method = RequestMethod.GET, produces = "application/json")
//    public List<StationNsi> getStationsNsi() {
//        List<StationNsi> list = serviseData.getOnlyStations();
//        return list;
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/stabch", method = RequestMethod.GET, produces = "application/json")
//    public List<StationNsi> getStationsNsiBch() {
//        List<StationNsi> list = serviseData.getOnlyStationsBCH();
//        return list;
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/stascript/save", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public StaModScript saveStaScript(@RequestParam("esr") String esr) throws DaoException {
//        return getServiseData().addStaModScript(esr);
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/stascript/delete", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public StaModScript daleteStaScript(@RequestParam("esr") String esr) throws DaoException {
//        return getServiseData().deleteStaModScript(esr);
//    }
//
//
//    @ResponseBody
//    @RequestMapping(value = "/station", method = RequestMethod.GET, produces = "application/json")
//    public StationNsi getStationNsi(@RequestParam("esr") String esr) {
//        return getServiseData().getStationNsi(esr);
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/iaspurgp/ipo", method = RequestMethod.GET, produces = "application/json")
//    public Date getLastDatopOPIPO() {
//        return getProjectData().getLastDatopOPIPO();
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/service/bd", method = RequestMethod.GET, produces = "application/json")
//    public String serviceBD(@RequestParam("cmd") String cmd) {
//        if ("runCleanBD".equals(cmd)) {
//            getServiseData().deleteForecastBySettings();
//            return "runCleanBD complete";
//        }
//        return "runCleanBD not start";
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/service/createPlan", method = RequestMethod.GET, produces = "application/json")
//    public PlanDeparture createNewPlan(@RequestParam("cmd") String cmd) {
//        if ("createPlan".equals(cmd)) {
//
//            return getServiseData().createNewPlan();
//        }
//        return null;
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/setting/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<Setting> setttingAll() {
//        return daoSetting.findAll();
//    }
//
//    @ResponseBody
//    @RequestMapping(value = "/setting/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//    public Setting settingSave(@RequestBody Setting setting) throws DaoException {
//        System.out.println(setting);
//        return setting;
//    }

//    @ResponseBody
//    @RequestMapping(value = "/setting/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//    public Setting settingSave(HttpServletRequest req, HttpServletResponse resp) throws DaoException {
//        String oper = req.getParameter("oper");
//        if ("edit".equals(oper)) {
//            String value = req.getParameter("value");
//            String idStr = req.getParameter("id");
////            Setting s = daoSetting.findOne(idStr);
//            int id = Integer.parseInt(idStr) - 1;
//            Setting setting = daoSetting.findAll().get(id);
//            setting.setValue(value);
//            daoSetting.save(setting);
//            return setting;
//        }
////        System.out.println(setting);
//        return null;
//    }
//
//    // getter and setters
//    public IServiseData getServiseData() {
//        return serviseData;
//    }
//
//    public void setServiseData(IServiseData serviseData) {
//        this.serviseData = serviseData;
//    }
//
//    public IProjectData getProjectData() {
//        return projectData;
//    }
//
//    public void setProjectData(IProjectData projectData) {
//        this.projectData = projectData;
//    }
}
