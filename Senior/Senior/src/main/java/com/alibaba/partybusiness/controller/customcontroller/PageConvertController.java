package com.alibaba.partybusiness.controller.customcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageConvertController {

	
	     //通知界面
		 @RequestMapping("/announcement")
		    public String announcementHtml() {
		        return "/html/announcement.html";
		    }
		 
		 //数据分析
		 @RequestMapping("/datastatistics")
		    public String datastatisticsHtml() {
		        return "/html/datastatistics.html";
		    }
		 
		 //首页界面
		 @RequestMapping("/main")
		    public String indextHtml() {
		        return "/html/index.html";
		    }
		 
		 //物流监控界面
		 @RequestMapping("/logisticsmonitor")
		    public String logisticsmonitorHtml() {
		        return "/html/logisticsmonitor.html";
		    }
		 
		 //打印发货界面
		 @RequestMapping("/printshipping")
		    public String printshippingHtml() {
		        return "/html/printshipping.html";
		    }
		 
		 //快速查单界面
		 @RequestMapping("/quickcheck")
		    public String quickcheckHtml() {
		        return "/html/quickcheck.html";
		    }
		 
		 //服务界面
		 @RequestMapping("/survey")
		    public String surveyHtml() {
		        return "/html/survey.html";
		    }
		 
		//用户管理界面
		 @RequestMapping("/usermanager")
		    public String usermanagerHtml() {
		        return "/html/usermanager.html";
		    }
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
}
