-- auto-generated definition
create table r_resume
(
    id                    int auto_increment
        primary key,
    sex                   varchar(10)             null comment '性别',
    birthday              varchar(30)             null comment '出生日期',
    work_year             varchar(100)            null comment '工作年限',
    phone                 varchar(20)             null comment '手机号码',
    email                 varchar(100)            null comment '邮箱',
    status                varchar(80)             null comment '目前状态',
    resumeName            varchar(500)            null comment '简历名称',
    name                  varchar(40)             null,
    createTime            datetime                null comment '创建日期',
    headPic               varchar(100)            null comment '头像',
    isDel                 int(2)                  null comment '是否删除 默认值0-未删除 1-已删除',
    updateTime            datetime                null comment '简历更新时间',
    userId                int                     null comment '用户ID',
    isDefault             int(2)                  null comment '是否为默认简历 0-默认 1-非默认',
    highestEducation      varchar(20)  default '' null comment '最高学历',
    deliverNearByConfirm  int(2)       default 0  null comment '投递附件简历确认 0-需要确认 1-不需要确认',
    refuseCount           int          default 0  not null comment '简历被拒绝次数',
    markCanInterviewCount int          default 0  not null comment '被标记为可面试次数',
    haveNoticeInterCount  int          default 0  not null comment '已通知面试次数',
    oneWord               varchar(100) default '' null comment '一句话介绍自己',
    liveCity              varchar(100) default '' null comment '居住城市',
    resumeScore           int(3)                  null comment '简历得分',
    userIdentity          int(1)       default 0  null comment '用户身份1-学生 2-工人',
    isOpenResume          int(1)       default 3  null comment '人才搜索-开放简历 0-关闭，1-打开，2-简历未达到投放标准被动关闭 3-从未设置过开放简历'
)
    charset = utf8;


