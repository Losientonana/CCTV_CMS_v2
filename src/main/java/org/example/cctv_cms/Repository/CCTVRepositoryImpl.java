package org.example.cctv_cms.Repository;

import org.example.cctv_cms.Data.CCTVData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CCTVRepositoryImpl implements CCTVRepository {
    private final Map<String, CCTVData> cctvDataMap = new HashMap<>();

    @Override
    public CCTVData findByCctvNum(String cctvNum) {
        return cctvDataMap.get(cctvNum);
    }

    @Override
    public void save(CCTVData cctvData) {
        cctvDataMap.put(cctvData.getCctvNum(), cctvData);
    }

    @Override
    public List<CCTVData> findAll() {
        return new ArrayList<>(cctvDataMap.values());
    }
}
