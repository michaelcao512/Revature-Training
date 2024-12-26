import React from 'react';
import { Box, Typography, Divider } from '@mui/material';
import styled from '@emotion/styled';
import Comment from './Comment';

const CommentsContainer = styled(Box)(({ theme }) => ({
    display: 'flex',
    flexDirection: 'column',
    padding: '1rem',
    width: '100%',
    boxSizing: 'border-box', // Include padding and border in the element's total width and height
}));

function DisplayComments({ fetchComments, user, comments }) {
    if (comments.length === 0) {
        return (
            <CommentsContainer>
                <Typography variant="body1" align="center">No comments yet</Typography>
            </CommentsContainer>
        );
    }
    return (
        <CommentsContainer>
            <Divider textAlign='left' >Replies</Divider>
            {comments.map(comment => (
                <Comment key={comment.commentId} user={user} comment={comment} fetchComments={fetchComments} />
            ))}
        </CommentsContainer>
    );
}

export default DisplayComments;