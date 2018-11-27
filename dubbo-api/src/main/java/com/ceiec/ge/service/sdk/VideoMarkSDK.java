package com.ceiec.ge.service.sdk;

/**
 * @author zhaoZhengchang
 * @create_date 2018-11-27 10:06
 * Description:
 **/
public interface VideoMarkSDK {

    /**
     * 视频标注服务
     * @param groupName 源视频组名
     * @param fileName 源视频文件名
     * @param info 标注信息
     * @param srcVideoID 源视频ID
     * @param userTaskID 用户任务ID
     * @param videoProcessJobID 视频处理任务ID
     * @return 任务提交是否成功
     */
    Boolean videoMark(String groupName, String fileName, String info, String srcVideoID, String userTaskID, String videoProcessJobID, String userName);
}
