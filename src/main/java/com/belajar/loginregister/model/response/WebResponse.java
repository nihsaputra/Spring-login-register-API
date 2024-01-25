package com.belajar.loginregister.model.response;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WebResponse<T> {

    private String status;
    private String message;
    private T data;
    private PagingResponse paging;

}
