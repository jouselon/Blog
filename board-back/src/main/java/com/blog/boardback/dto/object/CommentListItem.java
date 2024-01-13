package com.blog.boardback.dto.object;

import com.blog.boardback.dto.response.board.GetCommentListResponseDto;
import com.blog.boardback.repository.resultSet.GetCommentListResultSet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentListItem {
  private String nickname;
  private String profileImage;
  private String writeDatetime;
  private String content;

  public CommentListItem(GetCommentListResultSet resultSet) {
    this.nickname = resultSet.getNickname();
    this.profileImage = resultSet.getProfileImage();
    this.writeDatetime = resultSet.getWriteDatetime();
    this.content = resultSet.getContent();
  }

  public static List<CommentListItem> copyList(List<GetCommentListResultSet> resultSets){
    List<CommentListItem> list = new ArrayList<>();
    for (GetCommentListResultSet resultSet: resultSets){
      CommentListItem commentListItem = new CommentListItem(resultSet);
      list.add(commentListItem);
    }
    return list;
    }
  }
