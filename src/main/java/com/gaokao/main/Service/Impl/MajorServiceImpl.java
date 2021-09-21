package com.gaokao.main.Service.Impl;

import com.gaokao.main.Mapper.MajorMapper;
import com.gaokao.main.Service.MajorService;
import com.gaokao.main.VO.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
@Service(value = "majorServiceImpl")
public class MajorServiceImpl implements MajorService {

    private MajorMapper majorMapper;

    @Autowired
    public MajorServiceImpl(MajorMapper majorMapper) {
        this.majorMapper = majorMapper;
    }

    public ResponseData getCATClassInfo() {

        List<Map<String, Object>> categoryList =  majorMapper.getCategoryInfo();
        List<Map<String, String>> detailList = majorMapper.getCATClassGroupByCAT();

        for (Map<String, Object> CATMap : categoryList) {
            //为每条大类信息（category）添加一个数组元素，用来装分类信息（class）
            CATMap.put("children", null);
            for (Map<String, String> detailMap : detailList) {
                if (CATMap.get("major_category_id").equals(detailMap.get("major_category_id"))) {
                    List<String> children = (List<String>) CATMap.get("children");
                    if (children == null)
                        children = new ArrayList<String>();
                    children.add(detailMap.get("major_class"));
                    CATMap.put("children", children);
                }
            }
            CATMap.put("major_category_id", CATMap.get("major_category_id").toString());
        }

        return ResponseData.ok().setData("CATClassInfo", categoryList);
    }

    public ResponseData getMajorDetailInfo(Map<String, Object> queryForm) {
        return ResponseData.ok().setData("MajorDetailInfo", majorMapper.getMajorDetailInfo(queryForm));
    }

}
