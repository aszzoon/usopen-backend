package com.usopenblog.usopen_blog_backend_20240515.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "image")
@Table(name = "image")
public class ImageEntity {

  @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
  private int sequence;
  private int boardNumber;
  private String image;

}
