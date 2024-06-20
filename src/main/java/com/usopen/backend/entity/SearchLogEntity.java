package com.usopen.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


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
