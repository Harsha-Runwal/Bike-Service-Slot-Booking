package com.bssb.imageControl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {

	@Override
	public String uploadImage(String path, MultipartFile file) throws IOException {

		//filename
		String name = file.getOriginalFilename();

		//creating full path
		String fullpath = path+File.separator+name;

		//create folder if not exists
		File f = new File(path);
		if(!f.exists())
		{
			f.mkdir();
		}

		//copy file to full path 
		Files.copy(file.getInputStream(), Paths.get(fullpath));
;		return name;
	}

	@Override
	public InputStream getResource(String path, String fileName) throws FileNotFoundException {
		String fullPath = path+File.separator+fileName;
		InputStream is = new FileInputStream(fullPath);
		return is;
	}


}