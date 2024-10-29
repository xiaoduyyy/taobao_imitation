package com.example.my_taobao.Fragments.mvp;

import com.example.my_taobao.Base.BaseModel;
import com.example.my_taobao.Class.Commodity;
import com.example.my_taobao.R;

import java.util.ArrayList;
import java.util.List;

public class HomePagerModel extends BaseModel<HomePagerPresenter> {
    public HomePagerModel(HomePagerPresenter presenter) {
        super(presenter);
    }

    public List<Commodity> getCommodities() {
        List<Commodity> list = new ArrayList<>();
        list.add(new Commodity(R.drawable.commodity1, "回力潮牌休闲宽松连帽"));
        list.add(new Commodity(R.drawable.commodity2, "森马集团棉致小鲨鱼淡蓝色卫衣"));
        list.add(new Commodity(R.drawable.commodity3, "400张80包抽纸整箱"));
        list.add(new Commodity(R.drawable.commodity4, "数据线保护套防折断充电"));
        list.add(new Commodity(R.drawable.commodity5, "多模式无线鼠标静音可充电"));
        list.add(new Commodity(R.drawable.commodity1, "回力潮牌休闲宽松连帽"));
        list.add(new Commodity(R.drawable.commodity2, "森马集团棉致小鲨鱼淡蓝色卫衣"));
        list.add(new Commodity(R.drawable.commodity3, "400张80包抽纸整箱"));
        list.add(new Commodity(R.drawable.commodity4, "数据线保护套防折断充电"));
        list.add(new Commodity(R.drawable.commodity5, "多模式无线鼠标静音可充电"));
        list.add(new Commodity(R.drawable.commodity1, "回力潮牌休闲宽松连帽"));
        list.add(new Commodity(R.drawable.commodity2, "森马集团棉致小鲨鱼淡蓝色卫衣"));
        list.add(new Commodity(R.drawable.commodity3, "400张80包抽纸整箱"));
        list.add(new Commodity(R.drawable.commodity4, "数据线保护套防折断充电"));
        list.add(new Commodity(R.drawable.commodity5, "多模式无线鼠标静音可充电"));
        return list;
    }
}
