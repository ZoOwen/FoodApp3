package sqlfoodapp.zoowen.foodapp3.CallBack;

import sqlfoodapp.zoowen.foodapp3.Model.BestDealModel;

import java.util.List;

public interface IBestDeallCallbackListener {
    void  onBestDealLoadSuccess(List<BestDealModel> bestDealModels);
    void  onBestDealLoadFailed(String message);
}
