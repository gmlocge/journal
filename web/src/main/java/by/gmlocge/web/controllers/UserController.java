package by.gmlocge.web.controllers;

import by.gmlocge.journal.entity.security.UserJournal;
import by.gmlocge.journal.service.ISecurityManage;
import by.gmlocge.web.form.PasswordForm;
import by.gmlocge.web.security.CurrentAuthUser;
import by.gmlocge.web.validator.UserFormValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    protected Validator userFormValidator;

    @Autowired
    protected Validator passwordFormValidator;

    @Autowired
    @Qualifier("userDetailsServiceImpl")
    protected UserDetailsService userDetailsService;

    @InitBinder("userForm")
    protected void initBinder1(WebDataBinder binder) {
        binder.setValidator(userFormValidator);
    }

    @InitBinder("passwordForm")
    protected void initBinder2(WebDataBinder binder) {
        binder.setValidator(passwordFormValidator);
    }

    @Autowired
    protected ISecurityManage sm;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "forward:/welcome";
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView showMain(ModelAndView mav) {
        mav.setViewName("j.welcome");
        mav.addObject("userForm", new UserJournal());
        return mav;
    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public ModelAndView showSignin(ModelAndView mav) {
        mav.setViewName("j.signin");
//        userForm userForm = new userForm();
        mav.addObject("userForm", new UserJournal());
        return mav;
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ModelAndView signinComplete(@ModelAttribute("userForm") @Valid final UserJournal userForm, final BindingResult result, ModelAndView mav) {
        if (result.hasErrors()) {
            mav.setViewName("j.signin");
            return mav;
        }
        UserJournal uj = sm.createUser(userForm);
        authenticate(uj);
        mav.setViewName("redirect:/");
//        userForm = new userForm();
//        mav.addObject("userForm", userForm);
        return mav;
    }

    private void authenticate(UserJournal uj) {
        UserDetails ud = userDetailsService.loadUserByUsername(uj.getUsername());
        Authentication authentication = new UsernamePasswordAuthenticationToken(ud, ud.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    @RequestMapping(value = "/user/password/update", method = RequestMethod.GET)
    public ModelAndView passwordFormGet(ModelAndView mav) {
        mav.setViewName("j.password");
        mav.addObject("passwordForm", new PasswordForm());
        return mav;
    }


    @RequestMapping(value = "/user/password/update", method = RequestMethod.POST)
    public ModelAndView passwordUpdate(@ModelAttribute("passwordForm") @Valid final PasswordForm passwordForm, final BindingResult result, ModelAndView mav, @AuthenticationPrincipal Authentication authentication) {
        if (result.hasErrors()) {
            mav.setViewName("j.password");
            return mav;
        }
        UserJournal uj = (UserJournal) authentication.getPrincipal();
        uj.setPassword(passwordForm.getPasswordNew());
        uj = sm.updateUser(uj);
        authenticate(uj);
//        sm.updateUser()
//        UserJournal uj = sm.createUser(userForm);
//        UserDetails ud = userDetailsService.loadUserByUsername(uj.getUsername());
//        Authentication authentication = new UsernamePasswordAuthenticationToken(ud, ud.getAuthorities());
//        SecurityContextHolder.getContext().setAuthentication(authentication);
        mav.setViewName("redirect:/");
//        userForm = new userForm();
//        mav.addObject("userForm", userForm);
        return mav;
    }

    @RequestMapping(value = "/user/settings/update", method = RequestMethod.GET)
    public ModelAndView settingUpdateFormGet(ModelAndView mav, @AuthenticationPrincipal Authentication authentication) {
        UserJournal uj = (UserJournal) authentication.getPrincipal();
        UserJournal userJournal = sm.loadFullUser(uj);
        mav.setViewName("j.settings.update");
        mav.addObject("userSettForm", userJournal);
        return mav;
    }

    @RequestMapping(value = "/user/settings/update", method = RequestMethod.POST)
    public ModelAndView settingUpdate(@ModelAttribute("userSettForm") @Valid final UserJournal form, final BindingResult result, ModelAndView mav, @AuthenticationPrincipal Authentication authentication) {
        if (result.hasErrors()) {
            mav.setViewName("j.settings.update");
            return mav;
        }
        UserJournal uj = (UserJournal) authentication.getPrincipal();
        UserJournal userJournal = sm.loadFullUser(uj);
        userJournal.setFirstName(form.getFirstName());
        userJournal.setMiddleName(form.getMiddleName());
        userJournal.setLastName(form.getLastName());
        sm.updateUser(userJournal);
        mav.setViewName("j.settings.update");
        return mav;
    }


//    @RequestMapping(value = "/signin/registration", method = RequestMethod.POST)
//    public ModelAndView index(@Valid userForm userForm, BindingResult bindingResult, ModelAndView mav, HttpServletRequest request, HttpServletResponse response) {
//        if (bindingResult.hasErrors()) {
//            mav.addObject("userForm", userForm);
//            mav.setViewName("j.signin");
//            return mav;
//        }
//        mav.setViewName("j.login");
//
////        return "redirect:/results";
//        System.out.println("good!");
//        System.out.println(userForm);
//        return mav;
//    }

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