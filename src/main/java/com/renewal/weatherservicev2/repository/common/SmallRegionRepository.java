package com.renewal.weatherservicev2.repository.common;

import com.renewal.weatherservicev2.domain.entity.common.SmallRegion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmallRegionRepository extends JpaRepository<SmallRegion, Long> {
}
