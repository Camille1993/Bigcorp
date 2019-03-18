package com.training.bigcorp.bigcorp.controller;


import com.training.bigcorp.bigcorp.model.Captor;
import com.training.bigcorp.bigcorp.model.FixedCaptor;
import com.training.bigcorp.bigcorp.model.Site;
import com.training.bigcorp.bigcorp.repository.CaptorDao;
import com.training.bigcorp.bigcorp.repository.MeasureDao;
import com.training.bigcorp.bigcorp.repository.SiteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Transactional
@RequestMapping("/sites/{siteId}/captors/FIXED")
public class FixedCaptorController {
    @Autowired
    private SiteDao siteDao;
    @Autowired
    private CaptorDao captorDao;

    @GetMapping
    public ModelAndView list() {
        return new ModelAndView("captors").addObject("captors", captorDao.findAll());
    }
    @GetMapping("/{id}")
    public ModelAndView findById(@PathVariable String id, @PathVariable String siteId) {
        Site site = siteDao.findById(siteId).orElseThrow(IllegalArgumentException::new);
        return new ModelAndView("captor")
                .addObject("captor",
                        captorDao.findById(id).orElseThrow(IllegalArgumentException::new)).addObject("site", site);
    }

    @GetMapping("/create")
    public ModelAndView create(@PathVariable String siteId, FixedCaptor captor) {
        Site site = siteDao.findById(siteId).orElseThrow(IllegalArgumentException::new);
        return new ModelAndView("captor")
                .addObject("captor", new FixedCaptor()).addObject("site", site);
    }

    @Autowired
    MeasureDao measureDao;
    @PostMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable String siteId,String id) {
        Site site = siteDao.findById(siteId).orElseThrow(IllegalArgumentException::new);
        measureDao.deleteByCaptorId(id);
        captorDao.deleteById(id);
        return new ModelAndView("captor")
                .addObject("captor", captorDao.findAll());
    }

   @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ModelAndView save(@PathVariable String siteId, FixedCaptor captor) {
        Site site = siteDao.findById(siteId).orElseThrow(IllegalArgumentException::new);
        FixedCaptor captorToPersist;

        if (captor.getId() == null) {
            captorToPersist = new FixedCaptor(captor.getName(), site,
                    captor.getDefaultPowerInWatt());
        } else {
            captorToPersist = (FixedCaptor) captorDao.findById(captor.getId())
                    .orElseThrow(IllegalArgumentException::new);
            captorToPersist.setName(captor.getName());
            captorToPersist.setDefaultPowerInWatt(captor.getDefaultPowerInWatt());
        }
        captorDao.save(captorToPersist);
        return new ModelAndView("site").addObject("site", site);
    }

}
