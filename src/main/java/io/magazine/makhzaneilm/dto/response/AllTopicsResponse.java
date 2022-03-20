package io.magazine.makhzaneilm.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AllTopicsResponse {
    private List<MagazineInfoResponse> allTopics;
}
