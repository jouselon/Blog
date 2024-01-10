package com.blog.boardback.service.implement;

import com.blog.boardback.dto.request.board.PostBoardRequestDto;
import com.blog.boardback.dto.response.ResponseDto;
import com.blog.boardback.dto.response.board.PostBoardResponseDto;
import com.blog.boardback.entity.BoardEntity;
import com.blog.boardback.entity.ImageEntity;
import com.blog.boardback.repository.BoardRepository;
import com.blog.boardback.repository.ImageRepository;
import com.blog.boardback.repository.UserRepository;
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
}
