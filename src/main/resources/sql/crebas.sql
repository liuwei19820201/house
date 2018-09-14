/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/9/3 15:00:36                            */
/*==============================================================*/


drop table if exists area;

drop table if exists house;

drop table if exists house_image;

drop table if exists house_message;

drop table if exists house_record;

drop table if exists link;

drop table if exists link_person;

drop table if exists organization;

drop table if exists pay_record;

drop table if exists person;

drop table if exists project;

drop table if exists project_link;

drop table if exists req_record;

drop table if exists res_record_file;

drop table if exists resources_record;

drop table if exists template;

drop table if exists template_link;

/*==============================================================*/
/* Table: area                                                  */
/*==============================================================*/
create table area
(
   id                   int(11) not null comment '主键',
   name                 varchar(200) comment '模板名称',
   address              varchar(200) comment '描述',
   longitude            double(10,6) comment '删除标识 0未删除，1已删除',
   latitude             double(10,6) comment '创建时间',
   description          varchar(200) comment '描述',
   del                  int(1) comment '删除标识 0未删除，1已删除',
   create_time          datetime comment '创建时间',
   create_user          varchar(30) comment '创建人',
   update_time          datetime comment '修改时间',
   update_user          varchar(30) comment '修改人',
   primary key (id)
);

/*==============================================================*/
/* Table: house                                                 */
/*==============================================================*/
create table house
(
   id                   int(11) not null comment '主键',
   name                 varchar(200) comment '项目名称',
   landlord_name        varchar(200) comment '房主姓名',
   landlord_tel         varchar(200) comment '房主电话',
   landlord_idcard      varchar(200) comment '房主身份证号码',
   area_id              int(11) comment '小区ID',
   plots_name           varchar(200) comment '小区名称',
   location             varchar(200) comment '所在区域',
   house_type           varchar(200) comment '房屋户型',
   house_structure      varchar(200) comment '户型结构',
   floor                varchar(200) comment '所在楼层',
   build_area           varchar(200) comment '建筑面积',
   build_age            varchar(200) comment '建筑年代',
   inner_area           varchar(200) comment '套内面积',
   build_type           varchar(200) comment '建筑类型',
   house_direction      varchar(200) comment '房屋朝向',
   build_structure      varchar(200) comment '建筑结构',
   decoration_situation varchar(200) comment '装修情况',
   elevator_ratio       varchar(200) comment '梯户比例',
   heating_mode         varchar(200) comment '供暖方式',
   have_elevator        varchar(200) comment '配备电梯',
   property_right_years varchar(200) comment '产权年限',
   listing_time         datetime comment '挂牌时间',
   trade_attr           varchar(200) comment '交易属性',
   house_use            varchar(200) comment '房屋用途',
   house_years          varchar(200) comment '房屋年限',
   last_trade_time      datetime comment '上次交易时间',
   property_right_ascription varchar(200) comment '产权所属',
   mortgage_info        varchar(200) comment '抵押信息',
   property_copy        varchar(200) comment '房本备件',
   house_label          varchar(200) comment '房源标签',
   plots_introduce      varchar(200) comment '小区介绍',
   traffic_travel       varchar(200) comment '交通出行',
   house_type_introduce varchar(200) comment '户型介绍',
   core_selling_point   varchar(200) comment '核心卖点',
   landlord_recommend   varchar(200) comment '房主自荐',
   unit_price           decimal(10,2) comment '每平米单价',
   house_price          decimal(10,2) comment '房屋总价',
   register_time        datetime comment '登记时间',
   registrant           varchar(200) comment '登记人',
   longitude            double(10,6) comment '房源所在地经度',
   latitude             double(10,6) comment '房源所在地纬度',
   status               int(1) comment '当前状态 1未装修，2装修完成',
   contacts             varchar(200) comment '联系人',
   contacts_tel         varchar(200) comment '联系人电话',
   address              varchar(200) comment '地理位置',
   score                varchar(200) comment '评分',
   door_no              varchar(200) comment '门牌号',
   remark               varchar(200) comment '备注',
   del                  int(1) comment '删除标记 0未删除，1已删除',
   create_time          datetime comment '创建时间',
   create_user          varchar(30) comment '创建人',
   update_time          datetime comment '修改时间',
   update_user          varchar(30) comment '修改人',
   primary key (id)
);

/*==============================================================*/
/* Table: house_image                                           */
/*==============================================================*/
create table house_image
(
   id                   int(11) not null comment '主键',
   project_id           int(11) comment '房源ID',
   project_name         varchar(200) comment '房源名称',
   image_name           int(11) comment '资料名称',
   image_url            varchar(200) comment '资料url地址',
   type                 varchar(10) comment '资料分类',
   del                  int(1) comment '删除标识 0未删除，1已删除',
   create_time          datetime comment '创建时间',
   create_user          varchar(30) comment '创建人',
   update_time          datetime comment '修改时间',
   update_user          varchar(30) comment '修改人',
   primary key (id)
);

/*==============================================================*/
/* Table: house_message                                         */
/*==============================================================*/
create table house_message
(
   id                   int(11) not null comment '主键',
   house_id             varchar(200) comment '房源ID',
   from_person_id       int(11) comment '留言人ID',
   to_person_id         int(11) comment '给谁留言人ID',
   content              varchar(200) comment '留言信息',
   talk_time            datetime comment '留言时间',
   talk_back            varchar(200) comment '回复留言',
   back_time            datetime comment '回复时间',
   description          varchar(200) comment '描述',
   del                  int(1) comment '删除标识 0未删除，1已删除',
   create_time          datetime comment '创建时间',
   create_user          varchar(30) comment '创建人',
   update_time          datetime comment '修改时间',
   update_user          varchar(30) comment '修改人',
   primary key (id)
);

/*==============================================================*/
/* Table: house_record                                          */
/*==============================================================*/
create table house_record
(
   id                   int(11) not null comment '主键',
   project_id           varchar(200) comment '项目ID',
   number               varchar(200) comment '顾客人数',
   see_time             varchar(200) comment '带看时间',
   look_people          varchar(200) comment '带看人',
   customer             varchar(200) comment '顾客姓名',
   customer_contact     varchar(200) comment '顾客联系方式',
   del                  int(1) comment '删除标识 0未删除，1已删除',
   create_time          datetime comment '创建时间',
   create_user          varchar(30) comment '创建人',
   update_time          datetime comment '修改时间',
   update_user          varchar(30) comment '修改人',
   primary key (id)
);

/*==============================================================*/
/* Table: link                                                  */
/*==============================================================*/
create table link
(
   id                   int(11) not null comment '主键',
   name                 varchar(200) comment '环节名称',
   target               varchar(200) comment '环节目标',
   sort                 int(10) comment '顺序',
   description          varchar(200) comment '描述',
   del                  int(1) comment '删除标识 0未删除，1已删除',
   create_time          datetime comment '创建时间',
   create_user          varchar(30) comment '创建人',
   update_time          datetime comment '修改时间',
   update_user          varchar(30) comment '修改人',
   primary key (id)
);

/*==============================================================*/
/* Table: link_person                                           */
/*==============================================================*/
create table link_person
(
   id                   int(11) not null comment '主键',
   project_link_id      int(1) comment '项目环节ID',
   person_id            int(1) comment '人员ID',
   leader               varchar(200) comment '参与人或资源人',
   leader_tel           varchar(200) comment '参与人或资源人电话',
   type                 int(1) comment '人员类型  2参与人 3资源人',
   sort                 int(10) comment '顺序',
   description          varchar(200) comment '描述',
   del                  int(1) comment '删除标识 0未删除，1已删除',
   create_time          datetime comment '创建时间',
   create_user          varchar(30) comment '创建人',
   update_time          datetime comment '修改时间',
   update_user          varchar(30) comment '修改人',
   primary key (id)
);

/*==============================================================*/
/* Table: organization                                          */
/*==============================================================*/
create table organization
(
   id                   int(11) not null comment '主键',
   name                 varchar(200) comment '机构名称',
   address              varchar(200) comment '机构地址',
   leader               varchar(200) comment '机构负责人',
   mobile               varchar(200) comment '机构负责人电话',
   type                 int(1) comment '类型 1中介，2运营，3装修， 4金融机构',
   remark               varchar(200) comment '备注',
   del                  int(1) comment '删除标识 0未删除，1已删除',
   create_time          datetime comment '创建时间',
   create_user          varchar(30) comment '创建人',
   update_time          datetime comment '修改时间',
   update_user          varchar(30) comment '修改人',
   primary key (id)
);

/*==============================================================*/
/* Table: pay_record                                            */
/*==============================================================*/
create table pay_record
(
   id                   int(11) not null comment '主键',
   project_link_id      int(11) comment '项目环节ID',
   resources_record_id  int(11) comment '资源记录ID',
   person_id            int(11) comment '资源人ID',
   person_name          varchar(200) comment '资源人名称',
   pay_money            decimal(10,2) comment '付款金额',
   pay_time             datetime comment '付款时间',
   req_record_ids       varchar(200) comment '关联请款流水账ID，逗号分隔',
   important_matters    varchar(200) comment '重要事项',
   remark               varchar(200) comment '备注',
   del                  int(1) comment '删除标识 0未删除，1已删除',
   create_time          datetime comment '创建时间',
   create_user          varchar(30) comment '创建人',
   update_time          datetime comment '修改时间',
   update_user          varchar(30) comment '修改人',
   primary key (id)
);

/*==============================================================*/
/* Table: person                                                */
/*==============================================================*/
create table person
(
   id                   int(11) not null comment '主键',
   name                 varchar(200) comment '模板名称',
   classify             varchar(200) comment '分类 1责任人，2参与人，3资源对接人',
   type                 int(1) comment '类型 1内部，2中介，3装修',
   org_id               varchar(200) comment '所属机构',
   mobile1              varchar(200) comment '手机号码1',
   mobile2              varchar(200) comment '手机号码2',
   add_time             datetime comment '添加时间',
   add_person           varchar(200) comment '添加人',
   status               int(1) comment '目前状态',
   username             varchar(200) comment '用户名',
   password             varchar(200) comment '密码',
   shield_state         int(1) comment '屏蔽状态',
   remark               varchar(200) comment '备注',
   del                  int(1) comment '删除标识 0未删除，1已删除',
   create_time          datetime comment '创建时间',
   create_user          varchar(30) comment '创建人',
   update_time          datetime comment '修改时间',
   update_user          varchar(30) comment '修改人',
   primary key (id)
);

/*==============================================================*/
/* Table: project                                               */
/*==============================================================*/
create table project
(
   id                   int(11) not null comment '主键',
   house_id             int(11) comment '房源ID',
   house_name           varchar(200) comment '房源名称',
   name                 varchar(200) comment '项目名称',
   leader               varchar(200) comment '项目负责人',
   lleader_tel          varchar(200) comment '项目负责人电话',
   status               int(1) comment '项目状态',
   remark               varchar(200) comment '备注',
   del                  int(1) comment '删除标识 0未删除，1已删除',
   create_time          datetime comment '创建时间',
   create_user          varchar(30) comment '创建人',
   update_time          datetime comment '修改时间',
   update_user          varchar(30) comment '修改人',
   primary key (id)
);

/*==============================================================*/
/* Table: project_link                                          */
/*==============================================================*/
create table project_link
(
   id                   int(11) not null comment '主键',
   project_id           int(11) comment '项目ID',
   project_name         varchar(200) comment '项目名称',
   link_id              int(11) comment '环节ID',
   link_name            varchar(200) comment '环节名称',
   leader               varchar(200) comment '负责人',
   leader_tel           varchar(200) comment '负责人电话',
   status               int(11) comment '环节状态完成、终止、暂停、失败',
   start_time           varchar(200) comment '环节开始时间',
   end_time             varchar(200) comment '环节截至时间',
   target               varchar(200) comment '环节目标',
   sort                 int(10) comment '顺序',
   description          varchar(200) comment '描述',
   del                  int(1) comment '删除标识 0未删除，1已删除',
   create_time          datetime comment '创建时间',
   create_user          varchar(30) comment '创建人',
   update_time          datetime comment '修改时间',
   update_user          varchar(30) comment '修改人',
   primary key (id)
);

/*==============================================================*/
/* Table: req_record                                            */
/*==============================================================*/
create table req_record
(
   id                   int(11) not null comment '主键',
   project_link_id      int(11) comment '项目环节ID',
   resources_record_id  int(11) comment '资源记录ID',
   person_id            int(11) comment '资源人ID',
   person_name          varchar(200) comment '资源人名称',
   req_content          varchar(200) comment '请款内容',
   already_pay          decimal(10,2) comment '已支付金额',
   req_money            decimal(10,2) comment '请款金额',
   req_time             datetime comment '请款时间',
   important_matters    varchar(200) comment '重要事项',
   remark               varchar(200) comment '备注',
   del                  int(1) comment '删除标识 0未删除，1已删除',
   create_time          datetime comment '创建时间',
   create_user          varchar(30) comment '创建人',
   update_time          datetime comment '修改时间',
   update_user          varchar(30) comment '修改人',
   primary key (id)
);

/*==============================================================*/
/* Table: res_record_file                                       */
/*==============================================================*/
create table res_record_file
(
   id                   int(11) not null comment '主键',
   project_link_id      int(11) comment '项目环节ID',
   resources_record_id  int(11) comment '资源记录ID',
   person_id            int(11) comment '资源人ID',
   person_name          varchar(200) comment '资源人名称',
   type                 int(11) comment '文件类型 1 图片，2视频',
   url                  varchar(200) comment '地址',
   remark               varchar(200) comment '备注',
   del                  int(1) comment '删除标识 0未删除，1已删除',
   create_time          datetime comment '创建时间',
   create_user          varchar(30) comment '创建人',
   update_time          datetime comment '修改时间',
   update_user          varchar(30) comment '修改人',
   primary key (id)
);

/*==============================================================*/
/* Table: resources_record                                      */
/*==============================================================*/
create table resources_record
(
   id                   int(11) not null comment '主键',
   project_link_id      int(11) comment '项目环节ID',
   res_name             varchar(200) comment '资源名称',
   person_id            int(11) comment '资源人ID',
   person_name          varchar(200) comment '资源人名称',
   budget               decimal(10.2) comment '预算',
   pay                  decimal(10.2) comment '支出',
   important_matters    varchar(200) comment '重要事项',
   content              varchar(200) comment '记录内容',
   type                 int(11) comment '记录类型',
   commit_person        varchar(200) comment '提交人',
   commit_time          datetime comment '提交时间',
   remark               varchar(200) comment '备注',
   del                  int(1) comment '删除标识 0未删除，1已删除',
   create_time          datetime comment '创建时间',
   create_user          varchar(30) comment '创建人',
   update_time          datetime comment '修改时间',
   update_user          varchar(30) comment '修改人',
   primary key (id)
);

/*==============================================================*/
/* Table: template                                              */
/*==============================================================*/
create table template
(
   id                   int(11) not null comment '主键',
   name                 varchar(200) comment '模板名称',
   description          varchar(200) comment '描述',
   del                  int(1) comment '删除标识 0未删除，1已删除',
   create_time          datetime comment '创建时间',
   create_user          varchar(30) comment '创建人',
   update_time          datetime comment '修改时间',
   update_user          varchar(30) comment '修改人',
   primary key (id)
);

/*==============================================================*/
/* Table: template_link                                         */
/*==============================================================*/
create table template_link
(
   id                   int(11) not null comment '主键',
   template_id          int(11) comment '模板ID',
   template_name        varchar(200) comment '模板名称',
   link_id              int(11) comment '环节ID',
   link_name            varchar(200) comment '环节名称',
   del                  int(1) comment '删除标识 0未删除，1已删除',
   create_time          datetime comment '创建时间',
   create_user          varchar(30) comment '创建人',
   update_time          datetime comment '修改时间',
   update_user          varchar(30) comment '修改人',
   primary key (id)
);

