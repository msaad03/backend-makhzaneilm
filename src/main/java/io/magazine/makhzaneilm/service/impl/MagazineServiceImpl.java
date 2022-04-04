package io.magazine.makhzaneilm.service.impl;

import io.magazine.makhzaneilm.Exceptions.EntityNotFoundException;
import io.magazine.makhzaneilm.constants.enums.MonthsUrdu;
import io.magazine.makhzaneilm.dto.response.AllMagazinesResponse;
import io.magazine.makhzaneilm.dto.response.AllTopicsResponse;
import io.magazine.makhzaneilm.dto.response.MagazineInfoResponse;
import io.magazine.makhzaneilm.dto.response.MagazineResponse;
import io.magazine.makhzaneilm.constants.enums.Error;
import io.magazine.makhzaneilm.repository.MagazineInfoRepository;
import io.magazine.makhzaneilm.repository.MagazineRepository;
import io.magazine.makhzaneilm.service.MagazineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MagazineServiceImpl implements MagazineService {

    @Autowired
    MagazineRepository magazineRepository;

    @Autowired
    MagazineInfoRepository magazineInfoRepository;

    @Override
    public AllMagazinesResponse getAllMagazines() {
        final var magazines= magazineRepository.findAll();
        final var magazineResponses = magazines.stream().map(magazine -> new MagazineResponse(magazine.getId(), magazine.getName(), null, magazine.getYear(), magazine.getMonth())).collect(Collectors.toList());
        return new AllMagazinesResponse(magazineResponses);
    }

    @Override
    public MagazineResponse getMagazineById(Long id) {
        final var magazine=  Optional.ofNullable(magazineRepository.findById(id)).get().orElseThrow(() -> new EntityNotFoundException(Error.ENTITY_NOT_FOUND));
        final var magazineInfoList = magazine.getMagazineInfo().stream().map(magazineInfo -> new MagazineInfoResponse(magazineInfo.getId(), magazineInfo.getColumnName(), magazineInfo.getTopic(), magazineInfo.getAuthor(), magazineInfo.getContent())).collect(Collectors.toList());
        return new MagazineResponse(magazine.getId(), magazine.getName(), magazineInfoList, magazine.getYear(), magazine.getMonth());
    }

    @Override
    public MagazineResponse getCurrentMonthMagazine() {

        LocalDate currentdate = LocalDate.now();
        Month currentMonth = currentdate.getMonth();

        final var magazine=  Optional.ofNullable(magazineRepository.findByMonth(MonthsUrdu.valueOf(String.valueOf(currentMonth)).month)).get().orElseThrow(() -> new EntityNotFoundException(Error.ENTITY_NOT_FOUND));
        final var magazineInfoList = magazine.getMagazineInfo().stream().map(magazineInfo -> new MagazineInfoResponse(magazineInfo.getId(), magazineInfo.getColumnName(), magazineInfo.getTopic(), magazineInfo.getAuthor(), magazineInfo.getContent())).collect(Collectors.toList());
        return new MagazineResponse(magazine.getId(), magazine.getName(), magazineInfoList, magazine.getYear(), magazine.getMonth());
    }

    //Get All Topics
    @Override
    public AllTopicsResponse getAllTopics() {
        final var magazineInfos= magazineInfoRepository.findAll();
        final var magazineInfoList = magazineInfos.stream().map(magazineInfo -> new MagazineInfoResponse(magazineInfo.getId(), magazineInfo.getColumnName(), magazineInfo.getTopic(), magazineInfo.getAuthor(), magazineInfo.getContent())).collect(Collectors.toList());
        return new AllTopicsResponse(magazineInfoList);
    }
}
