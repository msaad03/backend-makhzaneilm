package io.magazine.makhzaneilm.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AllMagazinesResponse {
    private List<MagazineResponse> magazines;
}
