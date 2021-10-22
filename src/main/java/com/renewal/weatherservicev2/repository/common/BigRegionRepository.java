package com.renewal.weatherservicev2.repository.common;

import com.renewal.weatherservicev2.domain.entity.common.BigRegion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BigRegionRepository extends JpaRepository<BigRegion, Long> {
    BigRegion findByName(String name);

    BigRegion findByAdmCode(String admCode);
}
