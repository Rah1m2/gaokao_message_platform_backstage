package com.gaokao.main.Controller;

import com.gaokao.main.Service.MajorService;
import com.gaokao.main.VO.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Map;

@RestController
@RequestMapping("/Major")
public class MajorController {

    private MajorService majorService;

    @Autowired
    public MajorController(MajorService majorService) {
        this.majorService = majorService;
    }

    @RequestMapping(value = "/reqCATClassInfo/{major_rank}")
    private ResponseData sendCATClassInfo(@PathVariable("major_rank") String major_rank) {
        return majorService.getCATClassInfo(major_rank);
    }

    @RequestMapping(value = "/reqMajorDetailInfo", method = RequestMethod.POST)
    private ResponseData sendMajorDetailInfo(@RequestBody Map<String, Object> queryForm) {
        return majorService.getMajorDetailInfo(queryForm);
    }

    @RequestMapping(value = "/reqRelativeMajorInfo/{major_class}")
    private ResponseData sendRelativeMajorInfo(@PathVariable("major_class") String major_class) {
        return majorService.getRelativeMajorInfo(major_class);
    }

    @RequestMapping(value = "/reqProvinceSalary/{id}")
    public ResponseData sendProvinceSalaryById(@PathVariable("id") String major_id) {
        return majorService.getProvinceSalaryInfo(Integer.parseInt(major_id));
    }

    @RequestMapping(value = "/reqMajorId/{id}/{major_name}")
    public ResponseData sendMajorIdByOfferMajorId(@PathVariable("id") String offer_major_id, @PathVariable("major_name") String major_name) {
        return majorService.getMajorIdByOfferMajorId(Integer.parseInt(offer_major_id), major_name);
    }

}
