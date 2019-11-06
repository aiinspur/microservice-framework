package com.msf.msfmng.service.sys;

import com.msf.msfmng.entity.Dict;
import com.msf.msfmng.entity.DictData;
import com.msf.msfmng.repository.DictDataRepository;
import com.msf.msfmng.repository.DictRepository;
import com.msf.msfmng.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shihujiang
 * @date 2019-08-01
 */
@Service
public class DictServiceImpl extends BaseServiceImpl<DictRepository, Dict> implements DictService {

    private DictDataRepository dictDataRepository;

    public DictServiceImpl(DictRepository dictRepository, DictDataRepository dictDataRepository) {
        super(dictRepository);
        this.dictDataRepository = dictDataRepository;
    }


    @Override
    public List<DictData> getDataByDictCode(String code) {
        return dictDataRepository.getDictDataByCode(code);
    }

    @Override
    public void saveDictData(DictData dictData) {
        dictDataRepository.save(dictData);
    }


    @Override
    public void deleteDictData(Long id) {
        dictDataRepository.deleteById(id);
    }
}
