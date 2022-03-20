package io.magazine.makhzaneilm.service;

import io.magazine.makhzaneilm.dto.response.AllMagazinesResponse;
import io.magazine.makhzaneilm.dto.response.AllTopicsResponse;
import io.magazine.makhzaneilm.dto.response.MagazineResponse;

public interface MagazineService {
    AllMagazinesResponse getAllMagazines();
    MagazineResponse getMagazineById(Long id);
    MagazineResponse getCurrentMonthMagazine();
    AllTopicsResponse getAllTopics();
}
