package com.usopen.backend.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

  //file을 받아와서 문자열로 반환
  String upload(MultipartFile file);
  //fileName을 받아와서 Resource로 반환
  Resource getImage(String fileName);


}
