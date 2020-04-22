package com.gg.user.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * @author Gimi
 * @date 2020/4/22 14:48
 */
@Data
public class RouteDTO {

    /**类名  */
    private String url;
    /**类名  */
    private String className;
    /**类名  */
    private String method;
    /**类名  */
    private String type;
    /**类名  */
    private List<ParametersDTO> parameters;
}
