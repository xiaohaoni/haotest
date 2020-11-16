package com.hao.ding.domain

import lombok.Data


@Data
class EducationBureauBO {

    /**
     * 最近1天教师钉消息发
     * 送数
     * */
    String teacherSendDingCnt1d
    /**
     * 最近7天活跃教师数量
     * */
    String actTeacherCnt7d

    /**
     * 最近7天班级打卡使⽤
     * ⼈数
     * */
    String classCardUserCnt7d
    /**
     * 数字化教师数量
     * */
    String authTeacherCntStd

    /**
     * 最近1天活跃家⻓数量
     * */
    String actPatriarchCnt1d

    /**
     * 最近1天班级圈发送数
     * */
    String sendCirclePostCnt1d

    /**
     * 最近7天活跃班级圈数
     * */
    String actClassCircleCnt7d

    /**
     * 最近1天活跃班级圈数
     * */
    String actClassCircleCnt1d

    /**
     * 注册学校数
     * */
    String schoolCntStd

    /**
     * 最近1天活跃班级群数
     * */
    String actClassGroupCnt1d

    /**
     * 最近7天接收DING的家
     * ⻓数
     * */
    String rcvDingPatriarchCnt7d

    /**
     * 注册班级数
     * */
    String classCntStd

    /**
     * 最近1天班级群使⽤⼈
     * 数
     * */
    String classGroupUserCnt1d

    /**
     * 注册家⻓数
     * */
    String patriarchCntStd

    /**
     * 最近7天活跃班级群数
     * */
    String actClassGroupCnt7d

    /**
     * 最近7天活跃家⻓数量
     * */
    String actPatriarchCnt7d

    /**
     * 统计⽇期
     * */
    String statDate

    /**
     * 最近1天班级圈使⽤⼈
     * 数
     * */
    String classCircleUserCnt1d

    /**
     * 局id
     * */
    String corpId

    /**
     * 最近7天教师钉消息发
     * 送数
     * */
    String teacherSendDingCnt7d

    /**
     * 注册学⽣数
     * */
    String studentCntStd

    /**
     * 最近7天班级群使⽤⼈
     * 数
     * */
    String classGroupUserCnt7d

    /**
     * 最近1天接收DING的家
     * ⻓数
     * */
    String rcvDingPatriarchCnt1d

    /**
     * 最近1天班级打卡使⽤
     * ⼈数
     * */
    String classCardUserCnt1d

    /**
     * 最近7天班级圈使⽤⼈
     * 数
     * */
    String classCircleUserCnt7d

    /**
     * 最近1天活跃教师数量
     * */
    String actTeacherCnt1d

    /**
     * 注册教师数
     * */
    String teacherCntStd

    /**
     * 最近7天班级圈发送数
     * */
    String sendCirclePostCnt7d
}
