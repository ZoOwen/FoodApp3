package com.zoowen.foodapp3.CallBack;

import com.zoowen.foodapp3.Model.CategoryModel;

import java.util.List;

public interface ICategoryCallbackListener {
    void  onCategoryLoadSuccess(List<CategoryModel> categoryModelList);
    void  onCategoryLoadFailed(String message);
}
