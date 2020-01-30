package sqlfoodapp.zoowen.foodapp3.ui.comments;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import sqlfoodapp.zoowen.foodapp3.Model.CommentModel;

import java.util.List;

public class CommentViewModel extends ViewModel {
    private MutableLiveData<List<CommentModel>> mutablelivedataFoodList;
    public CommentViewModel() {
        mutablelivedataFoodList = new MutableLiveData<>();

    }

    public MutableLiveData<List<CommentModel>> getMutablelivedataFoodList() {
        return mutablelivedataFoodList;
    }

    public void setCommentList(List<CommentModel> commentList)
    {
        mutablelivedataFoodList.setValue(commentList);
    }
}
