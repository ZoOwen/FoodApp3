package com.zoowen.foodapp3.CallBack;

import com.zoowen.foodapp3.Model.PopularCategoryModel;

import java.util.List;

public interface IPopularCallbackListener {
    void  onPopularLoadSuccess(List<PopularCategoryModel> popularCategoryModelList);
    void  onPopularLoadFailed(String message);
}
