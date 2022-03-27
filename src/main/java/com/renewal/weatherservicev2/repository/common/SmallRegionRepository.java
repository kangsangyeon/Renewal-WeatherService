package com.renewal.weatherservicev2.repository.common;

import com.renewal.weatherservicev2.domain.entity.common.BigRegion;
import com.renewal.weatherservicev2.domain.entity.common.SmallRegion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SmallRegionRepository extends JpaRepository<SmallRegion, Long> {

    Optional<SmallRegion> findByBigRegionAndName(BigRegion bigRegion, String name);
}
