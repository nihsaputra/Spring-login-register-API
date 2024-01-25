package com.belajar.loginregister.model.response;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PagingResponse {

    private String page;
    private String size;
    private String totalPage;
    private String totalElement;

}
