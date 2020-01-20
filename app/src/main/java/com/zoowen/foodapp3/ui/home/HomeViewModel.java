package com.zoowen.foodapp3.ui.home;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.zoowen.foodapp3.CallBack.IBestDeallCallbackListener;
import com.zoowen.foodapp3.CallBack.IPopularCallbackListener;
import com.zoowen.foodapp3.Common.Common;
import com.zoowen.foodapp3.Model.BestDealModel;
import com.zoowen.foodapp3.Model.PopularCategoryModel;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel implements IPopularCallbackListener, IBestDeallCallbackListener {

 private  MutableLiveData<List<PopularCategoryModel>> popularList;
    private  MutableLiveData<List<BestDealModel>> bestDealList;
 private  MutableLiveData<String> messageError;
 private IPopularCallbackListener popularCallbackListener;
 private IBestDeallCallbackListener bestDeallCallbackListener;



    public HomeViewModel() {

        popularCallbackListener = this;
        bestDeallCallbackListener = this;
    }

    public MutableLiveData<List<BestDealModel>> getBestDealList() {
        if (bestDealList == null)
        {
            bestDealList = new MutableLiveData<>();
            messageError = new MutableLiveData<>();
            loadBestDealList();
        }
        return bestDealList;
    }

    private void loadBestDealList() {
        List<BestDealModel> templist = new ArrayList<>();
        DatabaseReference bestDealRef = FirebaseDatabase.getInstance().getReference(Common.BEST_DEAL_REF);
        bestDealRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot itemSnapShot:dataSnapshot.getChildren()){
                    BestDealModel model = itemSnapShot.getValue(BestDealModel.class);
                    templist.add(model);
                }
                bestDeallCallbackListener.onBestDealLoadSuccess(templist);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                bestDeallCallbackListener.onBestDealLoadFailed(databaseError.getMessage());
            }
        });
    }

    public MutableLiveData<List<PopularCategoryModel>> getPopularList() {
       if (popularList == null)
       {
           popularList = new MutableLiveData<>();
           messageError = new MutableLiveData<>();
           loadPopularList();
       }
        return popularList;
    }

    private void loadPopularList() {
        List<PopularCategoryModel> templist = new ArrayList<>();
        DatabaseReference popularRef = FirebaseDatabase.getInstance().getReference(Common.POPULAR_CATEGORY_REF);
        popularRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot itemSnapShot:dataSnapshot.getChildren()){
                    PopularCategoryModel model = itemSnapShot.getValue(PopularCategoryModel.class);
                    templist.add(model);
                }
                popularCallbackListener.onPopularLoadSuccess(templist);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                popularCallbackListener.onPopularLoadFailed(databaseError.getMessage());

            }
        });
    }

    public MutableLiveData<String> getMessageError() {
        return messageError;
    }

    @Override
    public void onPopularLoadSuccess(List<PopularCategoryModel> popularCategoryModels) {
        popularList.setValue(popularCategoryModels);

    }

    @Override
    public void onPopularLoadFailed(String message) {
        messageError.setValue(message);
    }

    @Override
    public void onBestDealLoadSuccess(List<BestDealModel> bestDealModels) {
        bestDealList.setValue(bestDealModels);
    }

    @Override
    public void onBestDealLoadFailed(String message) {
    messageError.setValue(message);
    }
}