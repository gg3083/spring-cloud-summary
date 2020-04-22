package com.gg.backend.controller;

import com.gg.backend.domain.dto.JsonBack;
import com.gg.backend.domain.dto.ParametersDTO;
import com.gg.backend.domain.dto.RouteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("open")
public class MappingController {

    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @GetMapping(value = "/mappings")
    public JsonBack list() {
        List<RouteDTO> res = new ArrayList<>();
        Map<RequestMappingInfo, HandlerMethod> map = requestMappingHandlerMapping.getHandlerMethods();
        for (Map.Entry<RequestMappingInfo, HandlerMethod> m : map.entrySet()) {
            RouteDTO routeDTO = new RouteDTO();
            RequestMappingInfo key = m.getKey();
            HandlerMethod value = m.getValue();
            PatternsRequestCondition p = key.getPatternsCondition();
            for (String url : p.getPatterns()) {
                routeDTO.setUrl(url);
            }
            routeDTO.setClassName(value.getMethod().getDeclaringClass().getName());
            routeDTO.setMethod(value.getMethod().getName());
            String type = key.getMethodsCondition().toString();
            if (type != null && type.startsWith("[") && type.endsWith("]")) {
                routeDTO.setType(type.substring(1, type.length() - 1));
            }
            Parameter[] parameters = value.getMethod().getParameters();
            List<ParametersDTO> parts = new ArrayList<>();
            for (Parameter parameter : parameters) {
                ParametersDTO part = new ParametersDTO();
                part.setName(parameter.getName());
                part.setType(parameter.getType().getName());
                parts.add(part);
            }
            routeDTO.setParameters(parts);
            res.add(routeDTO);
        }
        res = res.stream()
                        .sorted(Comparator.comparing(RouteDTO::getUrl))
                        .collect(Collectors.toList());

        return new JsonBack(res);
    }

}  