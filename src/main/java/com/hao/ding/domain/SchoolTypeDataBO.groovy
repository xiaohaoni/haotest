package com.hao.ding.domain

import lombok.Data

@Data
class SchoolTypeDataBO {

    /**
     *统计⽇期
     * */
    String stat_date

    /**
     *多家⻓监管学⽣数
     * */
    String multi_patriarch_student_cnt

    /**
     *单家⻓监管学⽣⽐率
     * */
    String single_patriarch_student_ratio

    /**
     *学校id
     * */
    String corp_id

    /**
     *双家⻓监管学⽣数
     * */
    String two_patriarch_student_cnt

    /**
     *数字化教师数量
     * */
    String auth_teacher_cnt_std

    /**
     *双家⻓监管学⽣⽐率
     * */
    String two_patriarch_student_ratio

    /**
     *学校类型
     * */
    String school_type

    /**
     *学⽣数量
     * */
    String student_cnt_std

    /**
     *学校数量
     * */
    String school_cnt_std

    /**
     *多家⻓监管学⽣⽐率
     * */
    String multi_patriarch_student_ratio

    /**
     *⽆家⻓监管学⽣数
     * */
    String none_patriarch_student_cnt

    /**
     *⽆家⻓监管学⽣⽐率
     * */
    String none_patriarch_student_ratio

    /**
     *班级数量
     * */
    String class_cnt_std

    /**
     *家⻓数量
     * */
    String patriarch_cnt_std

    /**
     *单家⻓监管学⽣数
     * */
    String single_patriarch_student_cnt

    /**
     *教师数量
     * */
    String teacher_cnt_std

}
