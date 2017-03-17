package com.ryx.ryx.entity;

import com.bigkoo.pickerview.model.IPickerViewData;
import com.neo.duan.entity.base.BaseInfo;

/**
 * @author : joy.hu
 * @date : 	 2017/3/14
 * @desc : 性别实体
 */
public class GenderInfo extends BaseInfo implements IPickerViewData {
    private String id;
    private String name;
    public GenderInfo(){

    }
    public GenderInfo(String id, String name){
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPickerViewText() {
        return name;
    }
}

