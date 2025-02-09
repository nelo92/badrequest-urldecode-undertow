package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Map;

public class DecodedPathVariableResolver implements HandlerMethodArgumentResolver {

    private static final Logger LOG = LoggerFactory.getLogger(DecodedPathVariableResolver.class);

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(DecodedPathVariable.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws UnsupportedEncodingException {
       LOG.info("[MAU] DecodedPathVariableResolver...");
//        String value = webRequest.getAttribute(parameter.getParameterName(), NativeWebRequest.SCOPE_REQUEST).toString();

        DecodedPathVariable annotation = parameter.getParameterAnnotation(DecodedPathVariable.class);
        String pathVariableName = annotation.value();
        Map<String, String> uriTemplateVars = (Map<String, String>) webRequest.getAttribute(
                HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE, NativeWebRequest.SCOPE_REQUEST);
        String value = uriTemplateVars.get(pathVariableName);

        String encoding = "UTF-8"; // ou l'encodage que vous souhaitez utiliser
        return URLDecoder.decode(value, encoding);
    }
}
