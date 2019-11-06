package com.msf.msfmng.repository;

import com.msf.msfmng.entity.Dict;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author shihujiang
 * @date 2019-07-30
 */
public interface DictRepository extends JpaRepository<Dict, Long> {
}
