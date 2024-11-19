package org.example.cctv_cms.Repository;


import org.example.cctv_cms.Data.CCTVData;

import java.util.List;

public interface CCTVRepository {
    CCTVData findByCctvNum(String cctvNum);

    void save(CCTVData cctvData);
    List<CCTVData> findAll(); // 모든 CCTV 데이터 가져오기
}
