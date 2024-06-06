package com.usopenblog.usopen_blog_backend_20240515.entity.primaeyKey;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FavoritePk implements Serializable {
  @Column(name="user_email")
  private String userEmail;
  @Column(name="board_number")
  private String boardNumber;
}
