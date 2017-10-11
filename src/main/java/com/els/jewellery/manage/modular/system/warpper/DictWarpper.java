package com.els.jewellery.manage.modular.system.warpper;

import com.els.jewellery.manage.common.constant.factory.ConstantFactory;
import com.els.jewellery.manage.common.warpper.BaseControllerWarpper;
import com.els.jewellery.manage.core.util.ToolUtil;
import com.els.jewellery.manage.common.persistence.model.Dict;

import java.util.List;
import java.util.Map;

/**
 * 字典列表的包装
 *
 * @author portal
 * @date 2017年4月25日 18:10:31
 */
public class DictWarpper extends BaseControllerWarpper {

    public DictWarpper(Object list) {
        super(list);
    }

    @Override
    public void warpTheMap(Map<String, Object> map) {
        StringBuffer detail = new StringBuffer();
        Integer id = (Integer) map.get("id");
        List<Dict> dicts = ConstantFactory.me().findInDict(id);
        if(dicts != null){
            for (Dict dict : dicts) {
                detail.append(dict.getNum() + ":" +dict.getName() + ",");
            }
            map.put("detail", ToolUtil.removeSuffix(detail.toString(),","));
        }
    }

}
