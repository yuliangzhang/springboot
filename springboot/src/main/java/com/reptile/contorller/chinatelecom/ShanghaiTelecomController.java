package com.reptile.contorller.chinatelecom;

import io.swagger.annotations.ApiOperation;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.reptile.service.chinatelecom.ShanghaiTelecomService;
import com.reptile.util.CustomAnnotation;
/**
 * 
 * @ClassName: ShanghaiTelecomController  
 * @Description: TODO  
 * @author: 111
 * @date 2018年1月2日  
 *
 */
@Controller
@RequestMapping("shhaiTelecom")
public class ShanghaiTelecomController {
	
@Autowired	
private ShanghaiTelecomService telecomService;
@ResponseBody
@RequestMapping(value = "shhaigetCode", method = RequestMethod.POST)
public  Map<String,Object> afterLogin(HttpServletRequest request){
	
	return telecomService.afterLogin(request);
}
@ApiOperation(value = "0.2获取内容",notes = "参数：手机号,服务密码,验证码")
@ResponseBody
@CustomAnnotation
@RequestMapping(value = "shhaigetDetial", method = RequestMethod.POST)
public  Map<String,Object> getDetial(HttpServletRequest request,@RequestParam("phoneNumber")String phoneNumber,@RequestParam("servePwd") String servePwd,@RequestParam("code")String code,@RequestParam("longitude")String longitude,@RequestParam("latitude")String latitude,@RequestParam("UUID")String uuid){
	return telecomService.getDetial(phoneNumber,servePwd, request, code,longitude,latitude,uuid);
}
}
