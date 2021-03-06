package com.reptile.contorller.accumulationfund;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reptile.service.accumulationfund.TaiAnFundService;
/**
 * 
 * @ClassName: TaiAnFundController  
 * @Description: TODO  
 * @author: 111
 * @date 2018年1月2日  
 *
 */

@Controller
@RequestMapping("TaiAnFundController")
public class TaiAnFundController {
	@Autowired
    private TaiAnFundService service;
	@ApiOperation(value = "1.泰安公积金", notes = "参数：身份证号，密码")
    @ResponseBody
    @RequestMapping(value = "TAlogin", method = RequestMethod.POST)
	public Map<String, Object> login(HttpServletRequest request,@RequestParam("idCard")String idCard,@RequestParam("idCardNum")String idCardNum,@RequestParam("userName")String userName,@RequestParam("passWord")String passWord,@RequestParam("catpy")String catpy,@RequestParam("cityCode")String cityCode,@RequestParam("fundCard")String fundCard){
		return service.login(request, idCard, passWord,cityCode,idCardNum);
				
	}
}
