package com.zoowen.foodapp3.ui.foodlist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.zoowen.foodapp3.Common.Common;
import com.zoowen.foodapp3.Model.FoodModel;

import java.util.List;

public class FoodListViewModel extends ViewModel {

    private MutableLiveData<List<FoodModel>> mutableLiveDataFoodList;

    public FoodListViewModel() {

    }

    public MutableLiveData<List<FoodModel>> getMutableLiveDataFoodList() {
        if (mutableLiveDataFoodList == null)
            mutableLiveDataFoodList = new MutableLiveData<>();
        mutableLiveDataFoodList.setValue(Common.categorySelected.getFoods());
        return mutableLiveDataFoodList;
    }
}