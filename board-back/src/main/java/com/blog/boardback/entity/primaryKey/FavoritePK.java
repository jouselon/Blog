package com.blog.boardback.entity.primaryKey;

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
public class FavoritePK implements Serializable {

  @Column(name = "user_email")
  private String userEmail;

  @Column(name = "board_number")
  private int boardNumber;
}
