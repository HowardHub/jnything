package com.ln;

import java.util.Map;

/**
 * @Description
 * @Author HeZhipeng
 * @Date 2022/2/26 22:54
 **/
public class ResourceNotFoundException extends BaseException{

    public ResourceNotFoundException(Map<String, Object> data) {
        super(ErrorCode.RESOURCE_NOT_FOUND, data);
    }


}
