package com.zzc.paramtest.param;

import java.util.List;
import java.util.Map;

/**
 * @author zhaoZhengchang
 * @create_date 2019-03-15 17:22
 * Description:
 **/

public class ParamsVO {
    private List<Map<String,String>> parameters ;

    public List<Map<String, String>> getParameters() {
        return parameters;
    }

    public void setParameters(List<Map<String, String>> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "ParamsVO{" +
                "parameters=" + parameters +
                '}';
    }
}
