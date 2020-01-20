package com.zoowen.foodapp3.CallBack;

import com.zoowen.foodapp3.Model.CommentModel;

import java.util.List;

public interface ICommentCallbackListener {
    void onCommentLoadSuccess(List<CommentModel> commentModels);
    void onCOmmentLoadFailed(String message);
}
