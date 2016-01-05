package by.gmlocge.web.controllers;

import by.gmlocge.journal.entity.security.UserJournal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(value = "/signin/registration", method = RequestMethod.POST)
    public String index(@Valid UserJournal userForm, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            return "signin";
        }

//        return "redirect:/results";
        System.out.println("good!");
        System.out.println(userForm);
        return "j.login";
    }

    @RequestMapping(value = "/signin")
    public ModelAndView signin(HttpServletRequest request, HttpServletResponse response, ModelAndView mav) {
        mav.setViewName("j.signin");
        UserJournal userForm = new UserJournal();
        mav.addObject("userForm", userForm);


        return mav;
    }

//
//    @Autowired
//    IPlanDepartureRepository daoPlan;
//
//    @RequestMapping(value = "/po", method = RequestMethod.GET)
//    public ModelAndView getTrains(@RequestParam("esr") String esr
////            ,@RequestParam(value = "fid", defaultValue = "0") Integer forecastId
//            ,@RequestParam(value = "pd", defaultValue = "0") Integer pd
//            ,ModelAndView mav) {
//        mav.setViewName("usogdp.planotpr");
//
////        ForecastVO forecastVO;
////        if (forecastId == 0) {
////            forecastVO = getServiseData().getLastForecast();
////        } else {
////            forecastVO = getServiseData().getForecastById(forecastId);
////        }
//        PlanDeparture plan = getServiseData().getLastPlanDeparture();
//
//        if ( pd != 0){
//            PlanDeparture plan2 = daoPlan.findOne(pd);
//            if (null != plan2){
//                plan = plan2;
//            }
//        }
//        ForecastVO forecast = plan.getForecast();
//
//        List<TrainVO> trains = getServiseData().getTrainsOnStationForDirection(esr, forecast.id);
//        mav.addObject("trains", trains);
//        mav.addObject("station", getServiseData().getStationNsi(esr));
//        List<DirectionVO> directions = getServiseData().getDirectionByESR(esr);
//        mav.addObject("directions", directions);
//        mav.addObject("forecast", forecast);
////        mav.addObject("stations", getServiseData().getOnlyStations());
//        Date now = new Date();
//        RangeHours rangeHours = getServiseData().findRangeForDate(forecast.startDate);
//        mav.addObject("rangeHours", rangeHours);
//        Map<String, Object> map = new HashMap<>();
//        int length = 0;
//        for (DirectionVO direction : directions) {
//            List<TrainVO> trainsD = new ArrayList<>();
//            for (TrainVO train : trains) {
//                if (null != train.na && direction.styk.trim().equals(train.na.trim())) {
//                    trainsD.add(train);
//                }
//            }
//            trainsD = filteringAndSortingForRange(rangeHours, trainsD);
//            if (length < trainsD.size()) {
//                length = trainsD.size();
//            }
//            map.put(direction.styk, trainsD);
//        }
//
//        map.put("length", length);
//        mav.addObject("data", map);
//
//        return mav;
//    }
//
//    private List<TrainVO> filteringAndSortingForRange(RangeHours range, List<TrainVO> trains) {
//        List<TrainVO> list = new ArrayList<>();
//        for (TrainVO train : trains) {
//            if (null != train.otpr && (train.otpr.after(range.getBegin()) || train.otpr.equals(range.getBegin())) &&
//                    (train.otpr.before(range.getEnd()))) {
//                list.add(train);
//            }
//        }
//        Collections.sort(list, new Comparator<TrainVO>() {
//            @Override
//            public int compare(TrainVO o1, TrainVO o2) {
//                if (null == o1.otpr || null == o2.otpr) {
//                    return -1;
//                }
//                if (o1.otpr.equals(o2.otpr)) {
//                    return 0;
//                }
//                if (o1.otpr.after(o2.otpr)) {
//                    return 1;
//                } else {
//                    return -1;
//                }
//            }
//        });
//        return list;
//    }
//
//    //----------------------геттеры сеттеры-------------------
//    public IServiceData getServiseData() {
//        return serviseData;
//    }
//
//    public void setServiseData(IServiceData serviseData) {
//        this.serviseData = serviseData;
//    }

}