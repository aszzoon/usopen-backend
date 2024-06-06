package com.usopenblog.usopen_blog_backend_20240515.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="comment")
@Table(name="comment")
public class CommentEntity {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private  int commentNumber;
  private String content;
  private String writeDatetime;
  private String userEmail;
  private int boardNumber;


}
