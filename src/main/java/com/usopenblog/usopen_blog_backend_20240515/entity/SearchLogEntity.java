package com.usopenblog.usopen_blog_backend_20240515.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="search-log")
@Table(name="search-log")
public class SearchLogEntity {

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int sequnce;

  private String searchWord;

  private String relationWorld;

  private boolean relation;
}
