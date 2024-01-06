import React from "react";
import './style.css';
import {CommentListItem} from "../../types/interface";
import defaultProfileImage from "assests/image/default-profile-image.png"

interface Props {
    commentListItem: CommentListItem;
}

//component : Comment List Item Component
export default function CommentItem({commentListItem}:Props) {

    //properties
    const { nickname, profileImage, writeDatetime, content } = commentListItem;
    const {  } = commentListItem;

    //render : Comment List Item Rendering
    return(
        <div className='comment-list-item'>
            <div className='comment-list-item-top'>
                <div className='comment-list-item-profile-box'>
                    <div className='comment-list-item-profile-image' style={{backgroundImage: `url(${profileImage ? profileImage : defaultProfileImage})`}}></div>
                </div>
                <div className='comment-list-item-nickname'>{nickname}</div>
                <div className='comment-list-item-divider'>{`\|`}</div>
                <div className='comment-list-item-time'>{writeDatetime}</div>
            </div>
            <div className='comment-list-item-main'>
                <div className='comment-list-item-content'>{content}</div>
            </div>
        </div>
    )
}