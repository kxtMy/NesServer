package testMaven3;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import testMaven3.AndroidNewsDAO;
import testMaven3.GetJsonUtil;

@Controller
public class BaseController {

	AndroidNewsDAO androidNewsDAO;
	
	@Resource(name="androidNewsDAOImpl")
	public void setAndroidNewsDAO(AndroidNewsDAO androidNewsDAO) {
		System.out.println("setAndroidNewsDAO!!!!!!");
		this.androidNewsDAO = androidNewsDAO;
		System.out.println("androidNewsDAO: "+androidNewsDAO);
		System.out.println("this.androidNewsDAO: "+this.androidNewsDAO);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(Model model, HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.out.println("register");
		//GetJsonUtil getJson=new GetJsonUtil();
		List<Object> list=GetJsonUtil.getJson("");
		System.out.println("androidNewsDAO: "+androidNewsDAO);
		for(int i=0;i<list.size();i++)
		androidNewsDAO.addAndroidNews((AndroidNews)list.get(i));
		return "test.jsp";
	}
	

	
}