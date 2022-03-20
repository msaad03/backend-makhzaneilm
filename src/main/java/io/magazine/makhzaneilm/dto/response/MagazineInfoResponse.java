package io.magazine.makhzaneilm.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MagazineInfoResponse {
    public Long id;
    private String columnName;
    private String topic;
    private String author;
    private String content;
}
