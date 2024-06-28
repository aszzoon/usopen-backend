package com.usopen.backend.controller;

import com.usopen.backend.service.FileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController {

  private final FileService fileService;

  @PostMapping("/upload")
  public String upload(
          @RequestParam("file") MultipartFile file
  ) {
    String url = fileService.upload(file);
    return url;
  }

  @Operation(summary = "Get greeting message", description = "Returns a greeting message")
  @ApiResponse(responseCode = "200", description = "Successful operation", content = @Content(schema = @Schema(implementation = String.class)))
  @GetMapping(value = "{fileName}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
  public Resource getImage(
          @PathVariable("fileName")
          String fileName) {
    Resource resource = fileService.getImage(fileName);
    return resource;
  }
}
