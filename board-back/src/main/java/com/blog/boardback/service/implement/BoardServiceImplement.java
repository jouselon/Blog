package com.blog.boardback.service.implement;

import com.blog.boardback.dto.request.board.PostBoardRequestDto;
import com.blog.boardback.dto.request.board.PostCommentRequestDto;
import com.blog.boardback.dto.response.ResponseDto;
import com.blog.boardback.dto.response.board.*;
import com.blog.boardback.entity.BoardEntity;
import com.blog.boardback.entity.CommentEntity;
import com.blog.boardback.entity.FavoriteEntity;
import com.blog.boardback.entity.ImageEntity;
import com.blog.boardback.repository.*;
import com.blog.boardback.repository.resultSet.GetBoardResultSet;
import com.blog.boardback.repository.resultSet.GetCommentListResultSet;
import com.blog.boardback.repository.resultSet.GetFavoriteListResultSet;
import com.blog.boardback.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImplement implements BoardService {

  private final BoardRepository boardRepository;
  private final ImageRepository imageRepository;
  private final UserRepository userRepository;
  private final FavoriteRepository favoriteRepository;
  private final CommentRepository commentRepository;


  @Override
  public ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber) {

    GetBoardResultSet resultSet = null;
    List<ImageEntity> imageEntities = new ArrayList<>();

    try {
      resultSet = boardRepository.getBoard(boardNumber);
      if (resultSet == null) return GetBoardResponseDto.notExistBoard();

      imageEntities = imageRepository.findByBoardNumber(boardNumber);

      BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
      boardEntity.increaseViewCount();
      boardRepository.save(boardEntity);

    }catch (Exception exception){
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return GetBoardResponseDto.success(resultSet, imageEntities);
  }

  @Override
  public ResponseEntity<? super GetFavoriteListResponseDto> getFavoriteList(Integer boardNumber) {

    List<GetFavoriteListResultSet> resultSets = new ArrayList<>();

    try {
      boolean existedBoard = boardRepository.existsByBoardNumber(boardNumber);
      if (!existedBoard) return GetFavoriteListResponseDto.noExistBoard();

      resultSets = favoriteRepository.getFavoriteList(boardNumber);

    }catch (Exception exception){
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return GetFavoriteListResponseDto.success(resultSets);
  }

  @Override
  public ResponseEntity<? super GetCommentListResponseDto> getCommentList(Integer boardNumber) {

    List<GetCommentListResultSet> resultSets = new ArrayList<>();

    try {
      boolean existedBoard = boardRepository.existsByBoardNumber(boardNumber);
      if (!existedBoard) return GetCommentListResponseDto.noExistBoard();

      resultSets = commentRepository.getCommentList(boardNumber);

    }catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return GetCommentListResponseDto.success(resultSets);
  }

  @Override
  public ResponseEntity<? super PostCommentResponseDto> postComment(PostCommentRequestDto dto, Integer boardNumber, String email) {
    try {

      BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
      if (boardEntity == null) return PostCommentResponseDto.noExistBoard();

      boolean existedUser = userRepository.existsByEmail(email);
      if (!existedUser) return PostCommentResponseDto.noExistBoard();

      CommentEntity commentEntity = new CommentEntity(dto, boardNumber, email);
      commentRepository.save(commentEntity);

      boardEntity.increaseCommentCount();
      boardRepository.save(boardEntity);

    } catch (Exception exception){
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return PostCommentResponseDto.success();
  }

  @Override
  public ResponseEntity<? super PostBoardResponseDto> postBoard(PostBoardRequestDto dto, String email) {

    try{
        boolean existedEmail = userRepository.existsByEmail(email);
        if (!existedEmail) return PostBoardResponseDto.notExistUser();

      BoardEntity boardEntity = new BoardEntity(dto,email);
      boardRepository.save(boardEntity);

      int boardNumber = boardEntity.getBoardNumber();


      List<String> boardImageList = dto.getBoardImageList();
      List<ImageEntity> imageEntities = new ArrayList<>();

      for (String image: boardImageList) {
        ImageEntity imageEntity = new ImageEntity(boardNumber, image);
        imageEntities.add(imageEntity);
      }

      imageRepository.saveAll(imageEntities);

    }catch (Exception exception){
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return PostBoardResponseDto.success();
  }

  @Override
  public ResponseEntity<? super PutFavoriteResponseDto> putFavorite(Integer boardNumber, String email) {

    try {

      boolean existedUser = userRepository.existsByEmail(email);
      if (!existedUser) return PutFavoriteResponseDto.noExistUser();

      BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
      if (boardEntity == null) return PutFavoriteResponseDto.noExistBoard();

      FavoriteEntity favoriteEntity = favoriteRepository.findByBoardNumberAndUserEmail(boardNumber, email);
      if (favoriteEntity == null) {
        favoriteEntity = new FavoriteEntity(email, boardNumber);
        favoriteRepository.save(favoriteEntity);

        boardEntity.increaseFavoriteCount();
      }
      else {
        favoriteRepository.delete(favoriteEntity);

        boardEntity.decreaseFavoriteCount();

      }

      boardRepository.save(boardEntity);

    }catch (Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }
    return PutFavoriteResponseDto.success();
  }
}
