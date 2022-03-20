package io.magazine.makhzaneilm.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class MagazineResponse {
    private Long id;
    private String name;
    private List<MagazineInfoResponse> magazineInfo;
    private String year;
    private String month;
}
