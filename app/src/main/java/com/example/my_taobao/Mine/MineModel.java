package com.example.my_taobao.Mine;

import com.example.my_taobao.Base.BaseModel;
import com.example.my_taobao.Class.Commodity;
import com.example.my_taobao.R;

import java.util.ArrayList;
import java.util.List;

public class MineModel extends BaseModel<MinePresenter> {

    public MineModel(MinePresenter presenter) {
        super(presenter);
    }

    public List<Commodity> getCommodities() {
        List<Commodity> list = new ArrayList<>();
        list.add(new Commodity(R.drawable.commodity1, "回力潮牌休闲宽松连帽", "每300减50", "¥69.9", "已售500+"));
        list.add(new Commodity(R.drawable.commodity1, "回力潮牌休闲宽松连帽", "每300减50", "¥69.9", "已售500+"));
        list.add(new Commodity(R.drawable.commodity2, "森马集团棉致小鲨鱼淡蓝色卫衣", "每300减50", "¥35.9", "已售2000+"));
        list.add(new Commodity(R.drawable.commodity2, "森马集团棉致小鲨鱼淡蓝色卫衣", "每300减50", "¥35.9", "已售2000+"));
        list.add(new Commodity(R.drawable.commodity3, "400张80包抽纸整箱", "直降2.09元", "¥18.81", "全网热销100万+"));
        list.add(new Commodity(R.drawable.commodity3, "400张80包抽纸整箱", "直降2.09元", "¥18.81", "全网热销100万+"));
        list.add(new Commodity(R.drawable.commodity4, "数据线保护套防折断充电", "每300减50", "¥3.69", "已售1万+"));
        list.add(new Commodity(R.drawable.commodity5, "多模式无线鼠标静音可充电", "官方8.5者", "¥39.98", "已售3万+"));
        list.add(new Commodity(R.drawable.commodity5, "多模式无线鼠标静音可充电", "官方8.5者", "¥39.98", "已售3万+"));
        list.add(new Commodity(R.drawable.commodity1, "回力潮牌休闲宽松连帽", "每300减50", "¥69.9", "已售500+"));
        list.add(new Commodity(R.drawable.commodity2, "森马集团棉致小鲨鱼淡蓝色卫衣", "每300减50", "¥35.9", "已售2000+"));
        list.add(new Commodity(R.drawable.commodity3, "400张80包抽纸整箱", "直降2.09元", "¥18.81", "全网热销100万+"));
        list.add(new Commodity(R.drawable.commodity4, "数据线保护套防折断充电", "每300减50", "¥3.69", "已售1万+"));
        list.add(new Commodity(R.drawable.commodity5, "多模式无线鼠标静音可充电", "官方8.5者", "¥39.98", "已售3万+"));
        return list;
    }
}
