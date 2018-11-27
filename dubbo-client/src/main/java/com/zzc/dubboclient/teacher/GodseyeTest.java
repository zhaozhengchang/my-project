package com.zzc.dubboclient.teacher;

import com.ceiec.ge.service.sdk.VideoMarkSDK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhaoZhengchang
 * @create_date 2018-11-27 10:04
 * Description:
 **/
@Component
public class GodseyeTest {

    @Autowired
    VideoMarkSDK videoMarkSDK ;

    public void get(){
        videoMarkSDK.videoMark("zzzc","","","","","","");
    }

}
