package com.msf.msfmng.repository;

import com.msf.msfmng.entity.DictData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author shihujiang
 * @date 2019-07-30
 */
public interface DictDataRepository extends JpaRepository<DictData, Long> {

    /**
     * get dict data .
     *
     * @param code code.
     * @return dict data.
     */
    List<DictData> getDictDataByCode(String code);
}
