package shan.yan.main;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import shan.yan.dao.CodeMsg;
import shan.yan.dao.Result;

@Controller
@EnableAutoConfiguration
public class MainApplication {
	// doc url : https://docs.spring.io/spring-boot/docs/2.0.0.RELEASE/reference/htmlsingle/
		// 
		@RequestMapping("/")
		@ResponseBody
		String home(){
			return "Hello Spring Boot";
		}
		
		public static void main(String[] args) {
			SpringApplication.run(MainApplication.class, args);
		}
		
		
		@RequestMapping("/hello")
		@ResponseBody
		public Result<String> Hello(){
			return Result.success("begin work!");
		}
		@RequestMapping("/helloError")
		@ResponseBody
		public Result<String> HelloErr(){
			return Result.error(CodeMsg.SERVER_ERROR);
		}
		@RequestMapping("/thymeleaf")
		public String thymeleaf(Model model) {
			model.addAttribute("name", "我靠，跑起来了！amazing！");
			return "xiang";
		}
}
