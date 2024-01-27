import ResponseDto from "../response.dto";
import CommentListMock from "../../../mocks/comment-list.mock";
import {CommentListItem} from "../../../types/interface";

export default interface GetCommentListResponseDto extends ResponseDto {
    commentList : CommentListItem[]
}