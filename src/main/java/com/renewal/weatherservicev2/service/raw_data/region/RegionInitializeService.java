package com.renewal.weatherservicev2.service.raw_data.region;

import com.renewal.weatherservicev2.domain.entity.common.BigRegion;
import com.renewal.weatherservicev2.domain.entity.common.SmallRegion;
import com.renewal.weatherservicev2.domain.vo.csv.RegionRequestVO;
import com.renewal.weatherservicev2.repository.common.BigRegionRepository;
import com.renewal.weatherservicev2.repository.common.SmallRegionRepository;
import com.renewal.weatherservicev2.service.parser.csv.RegionCsvParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegionInitializeService {

    private final BigRegionRepository bigRegionRepository;
    private final SmallRegionRepository smallRegionRepository;

    private final RegionCsvParser regionCsvParser;

    @Transactional
    public void initialize() {
        if (isAlreadyExistRegionTable()) {
            log.info("## All region data already exist in database");
            return;
        }

        initializeRegionTable();
    }

    public void initializeRegionTable() {
        try {
            bigRegionRepository.deleteAll();
            smallRegionRepository.deleteAll();

            List<RegionRequestVO> regionList = regionCsvParser.parseFromCsv();
            BigRegion lastBigRegion = null;

            for(RegionRequestVO region : regionList) {
                if(region.isBigRegion()) {
                    BigRegion bigRegion = region.createBigRegion();
                    lastBigRegion = bigRegion;
                    bigRegionRepository.save(bigRegion);

                } else {
                    assert lastBigRegion != null;
                    BigRegion bigRegion = region.getBigRegion().equals(lastBigRegion.getName()) ? lastBigRegion : bigRegionRepository.findByName(region.getBigRegion());
                    SmallRegion smallRegion = region.createSmallRegionWith(bigRegion);
                    smallRegionRepository.save(smallRegion);
                }
            }

        } catch (IOException e) {
            log.error("## occurred error during initializing region table!");
            log.error(e.getMessage(), e);
        }
    }

    private boolean isAlreadyExistRegionTable() {
        return bigRegionRepository.count() > 0 || smallRegionRepository.count() > 0;
    }
}
