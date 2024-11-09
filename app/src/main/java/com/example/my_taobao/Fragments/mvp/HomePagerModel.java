package com.example.my_taobao.Fragments.mvp;

import androidx.fragment.app.Fragment;

import com.example.my_taobao.Base.BaseModel;
import com.example.my_taobao.Class.Commodity;
import com.example.my_taobao.Fragments.PictureFragment1;
import com.example.my_taobao.Fragments.PictureFragment2;
import com.example.my_taobao.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomePagerModel extends BaseModel<HomePagerPresenter> {
    public HomePagerModel(HomePagerPresenter presenter) {
        super(presenter);
    }

    public List<Commodity> getCommodities() {
        List<Commodity> list = new ArrayList<>();

        list.add(new Commodity(R.drawable.shayuweiyi1, "森马集团棉致小鲨鱼淡蓝色长袖t恤男纯棉卡通青少年宽松情路上衣", "每300减50", "35.9", "已售2000+", new ArrayList<>(Arrays.asList(
                R.drawable.shayuweiyi1,
                R.drawable.shayuweiyi2,
                R.drawable.shayuweiyi3
        ))));
        list.add(new Commodity(R.drawable.weiyi1, "回力卫衣男秋冬青少年鲨鱼男款上衣2024冬季新款男生加绒连帽衣服", "每300减50", "69.9", "已售500+", new ArrayList<>(Arrays.asList(
                R.drawable.weiyi1,
                R.drawable.weiyi2,
                R.drawable.weiyi3,
                R.drawable.weiyi4
        ))));
        list.add(new Commodity(R.drawable.chouzhi1, "400张80包抽纸整箱批发餐巾纸家用实惠装卫生纸巾擦手纸面巾纸抽", "直降2.09元", "18.81", "全网热销100万+", new ArrayList<>(Arrays.asList(
                R.drawable.chouzhi1,
                R.drawable.chouzhi2,
                R.drawable.chouzhi3,
                R.drawable.chouzhi4
        ))));
        list.add(new Commodity(R.drawable.baohutao1, "数据线保护套防折断充电线咬线器适用华为oppo小米vivo专用手机接头全包荣耀破损断裂", "每300减50", "3.69", "已售1万+", new ArrayList<>(Arrays.asList(
                R.drawable.baohutao1,
                R.drawable.baohutao2,
                R.drawable.baohutao3,
                R.drawable.baohutao4
        ))));
        list.add(new Commodity(R.drawable.shubiao1, "蓝牙无线鼠标静音无声可充电游戏电竞男女生台式笔记本电脑通用", "官方8.5者", "39.98", "已售3万+", new ArrayList<>(Arrays.asList(
                R.drawable.shubiao1,
                R.drawable.shubiao2,
                R.drawable.shubiao3,
                R.drawable.shubiao4
        ))));
        list.add(new Commodity(R.drawable.shayuweiyi1, "森马集团棉致小鲨鱼淡蓝色长袖t恤男纯棉卡通青少年宽松情路上衣", "每300减50", "35.9", "已售2000+", new ArrayList<>(Arrays.asList(
                R.drawable.shayuweiyi1,
                R.drawable.shayuweiyi2,
                R.drawable.shayuweiyi3
        ))));
        list.add(new Commodity(R.drawable.weiyi1, "回力卫衣男秋冬青少年鲨鱼男款上衣2024冬季新款男生加绒连帽衣服", "每300减50", "69.9", "已售500+", new ArrayList<>(Arrays.asList(
                R.drawable.weiyi1,
                R.drawable.weiyi2,
                R.drawable.weiyi3,
                R.drawable.weiyi4
        ))));
        list.add(new Commodity(R.drawable.chouzhi1, "400张80包抽纸整箱批发餐巾纸家用实惠装卫生纸巾擦手纸面巾纸抽", "直降2.09元", "18.81", "全网热销100万+", new ArrayList<>(Arrays.asList(
                R.drawable.chouzhi1,
                R.drawable.chouzhi2,
                R.drawable.chouzhi3,
                R.drawable.chouzhi4
        ))));
        list.add(new Commodity(R.drawable.baohutao1, "数据线保护套防折断充电线咬线器适用华为oppo小米vivo专用手机接头全包荣耀破损断裂", "每300减50", "3.69", "已售1万+", new ArrayList<>(Arrays.asList(
                R.drawable.baohutao1,
                R.drawable.baohutao2,
                R.drawable.baohutao3,
                R.drawable.baohutao4
        ))));
        list.add(new Commodity(R.drawable.shubiao1, "蓝牙无线鼠标静音无声可充电游戏电竞男女生台式笔记本电脑通用", "官方8.5者", "39.98", "已售3万+", new ArrayList<>(Arrays.asList(
                R.drawable.shubiao1,
                R.drawable.shubiao2,
                R.drawable.shubiao3,
                R.drawable.shubiao4
        ))));


        return list;
    }

    public List<Fragment> getFragments() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new PictureFragment1());
        fragmentList.add(new PictureFragment2());
        return fragmentList;
    }

}
