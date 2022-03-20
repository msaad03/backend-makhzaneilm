package io.magazine.makhzaneilm.controllers;

import io.magazine.makhzaneilm.dto.RestResponseDto;
import io.magazine.makhzaneilm.dto.response.AllMagazinesResponse;
import io.magazine.makhzaneilm.dto.response.AllTopicsResponse;
import io.magazine.makhzaneilm.dto.response.MagazineResponse;
import io.magazine.makhzaneilm.service.MagazineService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.constraints.NotBlank;

@Controller
@RequestMapping("/magazine")
public class MagazineController {

    private final MagazineService magazineService;

    public MagazineController(MagazineService magazineService) {
        this.magazineService = magazineService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<RestResponseDto<AllMagazinesResponse>> getAllMagazines() {
        AllMagazinesResponse allMagazineResponse = magazineService.getAllMagazines();

        return BaseController.response(new RestResponseDto<AllMagazinesResponse>().makeSuccessResponse(allMagazineResponse));

    }

    @GetMapping("/{magazineId}")
    public ResponseEntity<RestResponseDto<MagazineResponse>> getMagazine(@PathVariable @NotBlank Long magazineId) {
        MagazineResponse magazineResponse = magazineService.getMagazineById(magazineId);

       return BaseController.response(new RestResponseDto<MagazineResponse>().makeSuccessResponse(magazineResponse));

    }

    @GetMapping("/currentMonth")
    public ResponseEntity<RestResponseDto<MagazineResponse>> getCurrentMonthMagazine() {
        MagazineResponse magazineResponse = magazineService.getCurrentMonthMagazine();

        return BaseController.response(new RestResponseDto<MagazineResponse>().makeSuccessResponse(magazineResponse));

    }

    @GetMapping("/allTopics")
    public ResponseEntity<RestResponseDto<AllTopicsResponse>> getAllTopics() {
        AllTopicsResponse magazineResponse = magazineService.getAllTopics();

        return BaseController.response(new RestResponseDto<AllTopicsResponse>().makeSuccessResponse(magazineResponse));

    }
}
