package com.msf.msfmng.service.sys;


import com.msf.msfmng.entity.Dict;
import com.msf.msfmng.entity.DictData;
import com.msf.msfmng.service.base.BaseService;

import java.util.List;

/**
 * @author shihujiang
 * @date 2019-08-01
 */
public interface DictService extends BaseService<Dict> {


    /**
     * Get dictionary data by code.
     *
     * @param code dict unique code.
     * @return
     */
    List<DictData> getDataByDictCode(String code);


    /**
     * save dict data.
     *
     * @param dictData dict data.
     */
    void saveDictData(DictData dictData);


    /**
     * delete dict data by id.
     *
     * @param id dict data id.
     */
    void deleteDictData(Long id);


}
