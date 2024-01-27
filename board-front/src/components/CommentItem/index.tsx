import React from "react";
import './style.css';
import {CommentListItem} from "../../types/interface";
import defaultProfileImage from "assests/image/default-profile-image.png"
import dayjs from "dayjs";

interface Props {
    commentListItem: CommentListItem;
}

//component : Comment List Item Component
export default function CommentItem({commentListItem}:Props) {

    //state : properties
    const { nickname, profileImage, writeDatetime, content } = commentListItem;
    const {  } = commentListItem;

    // function : 작성일 경과 시간 함수
    const getElapstedTime = () => {
        const now =dayjs().add(9, 'hour');
        const writeTime = dayjs(writeDatetime);

        const gap = now.diff(writeTime, 's');
        if (gap < 60) return `${gap}초 전`;
        if (gap < 3600) return `${Math.floor(gap / 60)} 분 전`;
        if (gap < 86400) return `${Math.floor(gap / 3600)}시간 전`;
        return `${Math.floor(gap/86400)}일 전`

    }


    //render : Comment List Item Rendering
    return(
        <div className='comment-list-item'>
            <div className='comment-list-item-top'>
                <div className='comment-list-item-profile-box'>
                    <div className='comment-list-item-profile-image' style={{backgroundImage: `url(${profileImage ? profileImage : defaultProfileImage})`}}></div>
                </div>
                <div className='comment-list-item-nickname'>{nickname}</div>
                <div className='comment-list-item-divider'>{`\|`}</div>
                <div className='comment-list-item-time'>{getElapstedTime()}</div>
            </div>
            <div className='comment-list-item-main'>
                <div className='comment-list-item-content'>{content}</div>
            </div>
        </div>
    )
}