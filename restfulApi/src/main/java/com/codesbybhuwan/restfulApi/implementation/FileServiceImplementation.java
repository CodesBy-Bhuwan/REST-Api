package com.codesbybhuwan.restfulApi.implementation;

import com.codesbybhuwan.restfulApi.services.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImplementation implements FileService {

    @Override
    public String uploadImage(String path, MultipartFile file) throws IOException {

//        FileName
        String name = file.getOriginalFilename();

//        Generate random fileName
        String randomID = UUID.randomUUID().toString();
        String fileName1 = randomID.concat(name.substring(name.lastIndexOf(".")));

//        FullPath
        String filePath = path + File.separator + fileName1;


//        Create folder if not created
        File f = new File(path);
        if(!f.exists()){
            f.mkdir();
        }

//        copy file
        Files.copy(file.getInputStream(), Paths.get(filePath));

        return name;
    }

    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {

        String fullPath = path+File.separator+fileName;
        InputStream is = new FileInputStream(fullPath);
//        bd to return inputstream
        return is;
    }
}
