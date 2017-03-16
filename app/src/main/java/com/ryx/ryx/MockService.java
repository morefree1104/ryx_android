package com.ryx.ryx;

import android.content.Context;
import android.util.Log;

import com.neo.duan.ui.adapter.base.base.entity.MultiItemEntity;
import com.ryx.ryx.entity.GenderInfo;
import com.ryx.ryx.entity.IndustryInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : neo.duan
 * @date : 	 2016/9/15
 * @desc : 手动模拟数据
 */
public class MockService {

//    <select id="industry" name="industry">
//    <option value="">====选择行业====</option>
//    <option value="1">银行</option>
//    <option value="2">证券</option>
//    <option value="3">融资租赁</option>
//    <option value="4">供应链金融</option>
//    <option value="5">商业保理</option>
//    <option value="6">新三板</option>
//    <option value="7">私募基金</option>
//    <option value="8">VC</option>
//    <option value="9">财富管理</option>
//    <option value="10">互联网金融</option>
//    <option value="11">众筹</option>
//    <option value="12">投行</option>
//    <option value="13">跨境电商</option>
//    <option value="14">进出口</option>
//    <option value="15">传统行业</option>
//    <option value="16">其他</option>
//    </select>
    public static ArrayList<IndustryInfo> mockIndustry(){
        ArrayList<IndustryInfo> arr = new ArrayList<>();
        arr.add(new IndustryInfo("1", "银行"));
        arr.add(new IndustryInfo("1", "银行"));
        arr.add(new IndustryInfo("1", "银行"));
        arr.add(new IndustryInfo("1", "银行"));
        arr.add(new IndustryInfo("1", "银行"));
        arr.add(new IndustryInfo("1", "银行"));
        arr.add(new IndustryInfo("1", "银行"));
        return arr;
    }

    public static ArrayList<GenderInfo> mockGender(){
        ArrayList<GenderInfo> arr = new ArrayList<>();
        arr.add(new GenderInfo("1", "男"));
        arr.add(new GenderInfo("2", "女"));
        return arr;
    }
}
