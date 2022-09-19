package com.bssb.controllers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.engine.jdbc.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.bssb.dao.PlanDao;
import com.bssb.dtos.PlanDto;
import com.bssb.entity.Plan;


import com.bssb.imageControl.FileService;


@CrossOrigin
@RestController
@RequestMapping("/plan")
public class PlanController {
	
	   @Autowired
	   private PlanDao dao;
	   
	   @Autowired
	   private FileService fileService;
	   
	   @Value("${project.image}")
	   private String path;
	   
	   	@PostMapping("/add")
	     public Plan add(@RequestBody Plan plan)
	     {
	    	  
	    	 return dao.addPlan(plan);
	    	 
	     }
	   	@GetMapping("/getPlans/{regNo}")
	   	public  List<PlanDto> getPlanList(@PathVariable int regNo) throws FileNotFoundException
	   	{
	   		return dao.getPlan(regNo);
	   	}
	  
	   	//store image
	   	@PostMapping("/uploadImage")
	   	public ResponseEntity<String> uploadFile(@RequestParam("image") MultipartFile image)
	   	{
//	   		System.out.println(file.getOriginalFilename());
//	   		System.out.println(file.getSize());
//	   		System.out.println(file.getContentType());
	   		String fileName;
	   		try {
				fileName = this.fileService.uploadImage(path, image);
			} catch (IOException e) {
				return ResponseEntity.internalServerError().body("image is not uploaded due to server error");
			}
	   		
	   		return ResponseEntity.ok().body(fileName);	
	   	}
	   	
	   	//get image
	   	@GetMapping("/images/{imageName}")
	   	public void downloadImage(@PathVariable("imageName") String imageName, HttpServletResponse response) throws IOException
	   	{
	   		InputStream resource = this.fileService.getResource(path, imageName);
	   		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
	   		StreamUtils.copy(resource, response.getOutputStream());
	   		
	   	}
}






