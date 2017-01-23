package controller.web.admin.page;

import com.sun.org.apache.xpath.internal.operations.Mod;
import controller.web.admin.AdminUriPreFix;
import dao.ComboDao;
import dao.ConcessionProductDao;
import entity.Combo;
import entity.ConcessionProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Sarwar on 1/18/2017.
 */
@Controller
@RequestMapping(AdminUriPreFix.pageUriPrefix+"/combo")
public class AdminComboController {
    @Autowired
    ConcessionProductDao concessionProductDao;
    @Autowired
    ComboDao comboDao;

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public ModelAndView index(){
        List<Combo> comboList=comboDao.getAll();
        ModelAndView modelAndView=new ModelAndView("web-admin/combo/all-combo");
        modelAndView.addObject("comboList",comboList);
        return modelAndView;
    }

    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public ModelAndView create(){
        List<ConcessionProduct> concessionProductList= concessionProductDao.getAll();
        ModelAndView modelAndView=new ModelAndView("web-admin/combo/create-combo");
        modelAndView.addObject("concessionProductList",concessionProductList);
        return modelAndView;
    }
}