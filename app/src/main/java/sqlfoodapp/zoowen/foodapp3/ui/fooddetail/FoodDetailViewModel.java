package sqlfoodapp.zoowen.foodapp3.ui.fooddetail;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import sqlfoodapp.zoowen.foodapp3.Common.Common;
import sqlfoodapp.zoowen.foodapp3.Model.CommentModel;
import sqlfoodapp.zoowen.foodapp3.Model.FoodModel;

public class FoodDetailViewModel extends ViewModel {

    private MutableLiveData<FoodModel> mutableLiveDataFood;
    private MutableLiveData<CommentModel> mutableLiveDataComment;
    public void setCommentModel(CommentModel commentModel)
    {
        if (mutableLiveDataComment !=  null )
            mutableLiveDataComment.setValue(commentModel);
    }

    public MutableLiveData<CommentModel> getMutableLiveDataComment() {
        return mutableLiveDataComment;
    }

    public FoodDetailViewModel() {
    mutableLiveDataComment = new MutableLiveData<>();
    }

    public MutableLiveData<FoodModel> getMutableLiveDataFood() {
        if (mutableLiveDataFood == null)
            mutableLiveDataFood = new MutableLiveData<>();
        mutableLiveDataFood.setValue(Common.selectedFood);
        return mutableLiveDataFood;
    }

    public void setFoodModel(FoodModel foodmodel) {
    if (mutableLiveDataFood != null)
        mutableLiveDataFood.setValue(foodmodel);

    }
}