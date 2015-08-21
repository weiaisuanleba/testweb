DROP TABLE IF EXISTS test_user CASCADE;
CREATE TABLE test_user (
    t_id VARCHAR(32) NOT NULL ,  -- 'ID',
    t_account VARCHAR(50) NOT NULL ,  -- '账号',
    t_password VARCHAR(100) NOT NULL ,  -- '密码',
    t_name VARCHAR(50) ,  -- '姓名',
    t_code VARCHAR(20) ,  -- '员工编号',
    t_is_custom BOOLEAN DEFAULT 't',  -- '是否自定义',
    t_sex VARCHAR(6) ,  -- '性别, male:男,female:女',
    t_department_id INTEGER  ,  -- '所属部门',
    t_mobile VARCHAR(50) ,  -- '手机',
    t_email VARCHAR(100) ,  -- '邮箱',
    t_address VARCHAR(200) ,  -- '地址',
    t_desc VARCHAR(500) ,  -- '描述信息',
    t_modify_time TIMESTAMP ,  -- '修改时间',
    t_extend VARCHAR(500) ,  -- 'json格式扩展信息，如发送媒介，如bqq、微信号、qq号等',
    t_is_enabled BOOLEAN DEFAULT 't' ,  -- '是否启用',
    t_json VARCHAR(500) ,  -- 'json格式扩展信息',
    t_tag1 VARCHAR(32) ,  -- '冗余字段1',
    t_tag2 VARCHAR(32) ,  -- '冗余字段2',
    PRIMARY KEY (t_id),
    UNIQUE (t_account)
    -- ,  CONSTRAINT fk_su_dept_id FOREIGN KEY (t_department_id) REFERENCES test_department (t_id) ON DELETE CASCADE
); -- '用户';
COMMENT ON TABLE test_user IS '用户';
COMMENT ON COLUMN test_user.t_id IS 'ID';
COMMENT ON COLUMN test_user.t_account IS '账号';
COMMENT ON COLUMN test_user.t_password IS '密码';
COMMENT ON COLUMN test_user.t_name IS '姓名';
COMMENT ON COLUMN test_user.t_code IS '员工编号';
COMMENT ON COLUMN test_user.t_is_custom IS '是否自定义';
COMMENT ON COLUMN test_user.t_sex IS '性别, male:男,female:女';
COMMENT ON COLUMN test_user.t_department_id IS '所属部门';
COMMENT ON COLUMN test_user.t_mobile IS '手机';
COMMENT ON COLUMN test_user.t_email IS '邮箱';
COMMENT ON COLUMN test_user.t_address IS '地址';
COMMENT ON COLUMN test_user.t_desc IS '描述信息';
COMMENT ON COLUMN test_user.t_modify_time IS '修改时间';
COMMENT ON COLUMN test_user.t_extend IS 'json格式扩展信息，如发送媒介，如bqq、微信号、qq号等';
COMMENT ON COLUMN test_user.t_is_enabled IS '是否激活';
COMMENT ON COLUMN test_user.t_json IS 'json格式扩展信息';
COMMENT ON COLUMN test_user.t_tag1 IS '冗余字段1';
COMMENT ON COLUMN test_user.t_tag2 IS '冗余字段2';

DROP TABLE IF EXISTS test_role CASCADE;
CREATE TABLE test_role (
    t_id VARCHAR(32) NOT NULL ,  -- 'ID',
    t_name VARCHAR(50) NOT NULL ,  -- '名称',
    t_is_custom BOOLEAN DEFAULT 't',  -- '是否自定义',
    t_desc VARCHAR(500) ,  -- '备注',
    t_json VARCHAR(500) ,  -- 'json格式扩展信息',
    t_tag1 VARCHAR(32) ,  -- '冗余字段1',
    t_tag2 VARCHAR(32) ,  -- '冗余字段2',
    PRIMARY KEY (t_id)
); -- '角色表';
COMMENT ON TABLE test_role IS '角色表';
COMMENT ON COLUMN test_role.t_id IS 'ID';
COMMENT ON COLUMN test_role.t_name IS '名称';
COMMENT ON COLUMN test_role.t_is_custom IS '是否自定义';
COMMENT ON COLUMN test_role.t_desc IS '备注';
COMMENT ON COLUMN test_role.t_json IS 'json格式扩展信息';
COMMENT ON COLUMN test_role.t_tag1 IS '冗余字段1';
COMMENT ON COLUMN test_role.t_tag2 IS '冗余字段2';

DROP TABLE IF EXISTS test_role_user_rel CASCADE;
CREATE TABLE test_role_user_rel (
    t_role_id VARCHAR(32) ,  -- '角色ID',
    t_user_id VARCHAR(32) ,  -- '用户ID',
    PRIMARY KEY (t_role_id,t_user_id),
    CONSTRAINT fk_sur_role_id FOREIGN KEY (t_role_id) REFERENCES test_role (t_id) ON DELETE CASCADE,
    CONSTRAINT fk_sur_user_id FOREIGN KEY (t_user_id) REFERENCES test_user (t_id) ON DELETE CASCADE
); -- '角色用户关系';
COMMENT ON TABLE test_role_user_rel IS '角色用户关系';
COMMENT ON COLUMN test_role_user_rel.t_role_id IS '角色ID';
COMMENT ON COLUMN test_role_user_rel.t_user_id IS '用户ID';

DROP TABLE IF EXISTS test_function CASCADE;
CREATE TABLE test_function (
    t_id VARCHAR(32) NOT NULL ,  -- '主键',
    t_parent_id VARCHAR(32) ,  -- '上级ID',
    t_name VARCHAR(100) ,  -- '名称',
    t_icon VARCHAR(50) ,  -- '图标',
    t_level INTEGER  ,  -- '层级',
    t_url VARCHAR(255) ,  -- '链接地址',
    t_group VARCHAR(20) ,  -- '所属系统,产品.子系统.模块,如bmc.admin or rmc.portal',
    t_path VARCHAR(255) ,  -- '树级路径, 形式:1,5,3:表示当前节点为三级节点, 三个序号从右向左为当前节点, 父节点, 父节点的父级也即是一级节点所对应的路径序号, 序号用自然数表示, 同级节点每增加一个序号加1, 当前节点序号与上级序号以","分隔.',
    t_path_name VARCHAR(500) ,  -- '全路径名称',
    t_permissions VARCHAR(60) ,  -- '支持的操作权限，如create,delete,update,view等',
    t_order INTEGER  ,  -- '排序号',
    t_is_custom BOOLEAN DEFAULT 'f' ,  -- '是否自定义',
    t_is_enabled BOOLEAN DEFAULT 't' ,  -- '是否激活',
    t_json VARCHAR(500) ,  -- 'json格式扩展信息',
    t_tag1 VARCHAR(32) ,  -- '冗余字段1',
    t_tag2 VARCHAR(32) ,  -- '冗余字段2',
    PRIMARY KEY (t_id)
); -- '系统功能页签';
COMMENT ON TABLE test_function IS '系统功能页签';
COMMENT ON COLUMN test_function.t_id IS '主键';
COMMENT ON COLUMN test_function.t_parent_id IS '上级ID';
COMMENT ON COLUMN test_function.t_name IS '名称';
COMMENT ON COLUMN test_function.t_icon IS '图标';
COMMENT ON COLUMN test_function.t_level IS '层级';
COMMENT ON COLUMN test_function.t_url IS '链接地址';
COMMENT ON COLUMN test_function.t_group IS '所属系统,产品.子系统.模块,如bmc.admin or rmc.portal';
COMMENT ON COLUMN test_function.t_path IS '树级路径, 形式:1,5,3:表示当前节点为三级节点, 三个序号从右向左为当前节点, 父节点, 父节点的父级也即是一级节点所对应的路径序号, 序号用自然数表示, 同级节点每增加一个序号加1, 当前节点序号与上级序号以","分隔.';
COMMENT ON COLUMN test_function.t_path_name IS '全路径名称';
COMMENT ON COLUMN test_function.t_permissions IS '支持的操作权限，如create,delete,update,view等';

COMMENT ON COLUMN test_function.t_order IS '排序号';
COMMENT ON COLUMN test_function.t_is_custom IS '是否自定义';
COMMENT ON COLUMN test_function.t_is_enabled IS '是否激活';
COMMENT ON COLUMN test_function.t_json IS 'json格式扩展信息';
COMMENT ON COLUMN test_function.t_tag1 IS '冗余字段1';
COMMENT ON COLUMN test_function.t_tag2 IS '冗余字段2';

DROP TABLE IF EXISTS test_role_function_rel CASCADE;
CREATE TABLE test_role_function_rel (
    t_role_id VARCHAR(32) ,  -- '角色ID',
    t_function_id VARCHAR(32) ,  -- '页签ID',
    t_permissions varchar(60) ,  -- '操作权限，如create,delete,update,view等',
    PRIMARY KEY (t_role_id,t_function_id),
    CONSTRAINT fk_srpl_user_id FOREIGN KEY (t_role_id) REFERENCES test_role (t_id) ON DELETE CASCADE,
    CONSTRAINT fk_srpl_function_id FOREIGN KEY (t_function_id) REFERENCES test_function (t_id) ON DELETE CASCADE
); -- '角色页签关系表';
COMMENT ON TABLE test_role_function_rel IS '角色页签关系表';
COMMENT ON COLUMN test_role_function_rel.t_role_id IS '角色ID';
COMMENT ON COLUMN test_role_function_rel.t_function_id IS '页签ID';
COMMENT ON COLUMN test_role_function_rel.t_permissions IS '操作权限，如create,delete,update,view等';

DROP TABLE IF EXISTS test_user_function_rel CASCADE;
CREATE TABLE test_user_function_rel (
    t_user_id VARCHAR(32) ,  -- '用户ID',
    t_function_id VARCHAR(32) ,  -- '页签ID',
    t_permissions varchar(60) ,  -- '操作权限，如create,delete,update,view等',
    PRIMARY KEY (t_user_id,t_function_id),
    CONSTRAINT fk_sfr_function_id FOREIGN KEY (t_function_id) REFERENCES test_function (t_id) ON DELETE CASCADE,
    CONSTRAINT fk_sfr_user_id FOREIGN KEY (t_user_id) REFERENCES test_user (t_id) ON DELETE CASCADE
); -- '用户页签关系表';
COMMENT ON TABLE test_user_function_rel IS '用户页签关系表';
COMMENT ON COLUMN test_user_function_rel.t_user_id IS '用户ID';
COMMENT ON COLUMN test_user_function_rel.t_function_id IS '页签ID';
COMMENT ON COLUMN test_user_function_rel.t_permissions IS '操作权限，如create,delete,update,view等';


DROP TABLE IF EXISTS test_icon CASCADE;
CREATE TABLE test_icon (
    t_id SERIAL NOT NULL ,  -- 'ID',
    t_name VARCHAR(50) ,  -- '名称，如饼图',
    t_type VARCHAR(6) ,  -- '类型',
    t_css_class VARCHAR(100) ,  -- 'ccs类',
    t_path VARCHAR(150) ,  -- '路径,如plug-in/accordion/images/pie.png',
    t_desc VARCHAR(500) ,  -- '描述信息',
    t_json VARCHAR(500) ,  -- 'json格式扩展信息',
    t_tag1 VARCHAR(32) ,  -- '冗余字段1',
    t_tag2 VARCHAR(32) ,  -- '冗余字段2',
    PRIMARY KEY (t_id)
); -- '系统图标表';
COMMENT ON TABLE test_icon IS '系统图标表';
COMMENT ON COLUMN test_icon.t_id IS 'ID';
COMMENT ON COLUMN test_icon.t_name IS '名称，如饼图';
COMMENT ON COLUMN test_icon.t_type IS '类型';
COMMENT ON COLUMN test_icon.t_css_class IS 'ccs类';
COMMENT ON COLUMN test_icon.t_path IS '路径,如plug-in/accordion/images/pie.png';
COMMENT ON COLUMN test_icon.t_desc IS '描述信息';
COMMENT ON COLUMN test_icon.t_json IS 'json格式扩展信息';
COMMENT ON COLUMN test_icon.t_tag1 IS '冗余字段1';
COMMENT ON COLUMN test_icon.t_tag2 IS '冗余字段2';

DROP TABLE IF EXISTS test_permission CASCADE;
CREATE TABLE test_permission (
    t_id SERIAL NOT NULL ,  -- 'ID',
    t_name VARCHAR(50) ,  -- '名称',
    t_permission VARCHAR(100) ,  -- '权限',
    t_desc VARCHAR(1000) ,  -- '描述',
    t_is_enabled BOOLEAN DEFAULT 't' ,  -- '是否启用',
    t_json VARCHAR(500) ,  -- 'json格式扩展信息',
    t_tag1 VARCHAR(32) ,  -- '冗余字段1',
    t_tag2 VARCHAR(32) ,  -- '冗余字段2',
    PRIMARY KEY (t_id)
); -- '系统数据权限表';
CREATE INDEX idx_sp_name  ON test_permission(t_name);
CREATE INDEX idx_sp_permission  ON test_permission(t_permission);
CREATE INDEX idx_sp_is_enabled  ON test_permission(t_is_enabled);
COMMENT ON TABLE test_permission IS '系统数据权限表';
COMMENT ON COLUMN test_permission.t_id IS 'ID';
COMMENT ON COLUMN test_permission.t_name IS '名称';
COMMENT ON COLUMN test_permission.t_permission IS '权限';
COMMENT ON COLUMN test_permission.t_desc IS '描述';
COMMENT ON COLUMN test_permission.t_is_enabled IS '是否启用';
COMMENT ON COLUMN test_permission.t_json IS 'json格式扩展信息';
COMMENT ON COLUMN test_permission.t_tag1 IS '冗余字段1';
COMMENT ON COLUMN test_permission.t_tag2 IS '冗余字段2';



---------------------------- 未修改 --------------------------------------
---------------------------- 未修改 --------------------------------------



DROP TABLE IF EXISTS test_mapping_type CASCADE;
CREATE TABLE test_mapping_type (
  t_id VARCHAR(50) NOT NULL ,  -- 'ID,如：mon.alarm.level,mon.snmp.version',
  t_name VARCHAR(50) ,  -- '名称',
  t_group VARCHAR(50) ,  -- '标签分组，可以构建二层树结构',
  t_desc VARCHAR(500) ,  -- '描述信息',
  PRIMARY KEY (t_id)
); -- '字典mapping类型表';
COMMENT ON TABLE test_mapping_type IS '字典mapping类型表';
COMMENT ON COLUMN test_mapping_type.t_id IS 'ID,如：mon.alarm.level,mon.snmp.version';
COMMENT ON COLUMN test_mapping_type.t_name IS '名称';
COMMENT ON COLUMN test_mapping_type.t_group IS '标签分组，可以构建二层树结构';
COMMENT ON COLUMN test_mapping_type.t_desc IS '描述信息';

DROP TABLE IF EXISTS test_mapping CASCADE;
CREATE TABLE test_mapping(
  t_type VARCHAR(50) NOT NULL ,  -- '分类,如：mon.alarm.level,mon.snmp.version',
  t_value VARCHAR(50) ,  -- '数据字典项值',
  t_text VARCHAR(255) ,  -- '数据字典项的文本描述，如t_value=1表示男性',
  t_order SMALLINT  ,  -- '排序号',
  t_is_enabled BOOLEAN DEFAULT 't' ,  -- '是否启用',
  PRIMARY KEY (t_type,t_value),
  CONSTRAINT fk_sm_type FOREIGN KEY (t_type) REFERENCES test_mapping_type (t_id) ON DELETE CASCADE
); -- '系统字典表，类似枚举值的转换  如 1=up、2=down';
COMMENT ON TABLE test_mapping IS '系统字典表，类似枚举值的转换  如 1=up、2=down';
COMMENT ON COLUMN test_mapping.t_type IS '分类,如：mon.alarm.level,mon.snmp.version';
COMMENT ON COLUMN test_mapping.t_value IS '数据字典项值';
COMMENT ON COLUMN test_mapping.t_text IS '数据字典项的文本描述，如t_value=1表示男性';
COMMENT ON COLUMN test_mapping.t_order IS '排序号';
COMMENT ON COLUMN test_mapping.t_is_enabled IS '是否启用';

DROP TABLE IF EXISTS test_config_def CASCADE;
CREATE TABLE test_config_def (
  t_id VARCHAR(32) NOT NULL ,  -- 'ID，.分割字符串或uuid',
  t_name VARCHAR(100) ,  -- '显示名称',
  t_item_type VARCHAR(32) NOT NULL ,  -- '配置类型,如mon.collector、mon.model等',
  t_item_id VARCHAR(32) NOT NULL ,  -- '配置项标识信息，如采集插件id、模型id',
    -- t_group VARCHAR(32),  -- '分组分类',
  t_url VARCHAR(200) ,  -- '配置页面，界面的crud由调用参数决定',
  t_tooltip VARCHAR(200) ,  -- '提示信息',
  t_desc VARCHAR(200),  -- '描述',
  t_help_message VARCHAR(2000),  -- '帮助信息',
  t_json VARCHAR(500) ,  -- 'json格式扩展信息',
  PRIMARY KEY (t_id)
); -- '系统配置定义,如：插件连接信息；存储配置类型和id，使用端不存储配置定义信息，与使用端解耦';
COMMENT ON TABLE test_config_def IS '系统配置定义,如：插件连接信息；存储配置类型和id，使用端不存储配置定义信息，与使用端解耦';
COMMENT ON COLUMN test_config_def.t_id IS 'ID，.分割字符串或uuid';
COMMENT ON COLUMN test_config_def.t_name IS '显示名称';
COMMENT ON COLUMN test_config_def.t_item_type IS '配置类型,如mon.collector、mon.model等';
COMMENT ON COLUMN test_config_def.t_item_id IS '配置项标识信息，如采集插件id、模型id';
COMMENT ON COLUMN test_config_def.t_url IS '配置页面，界面的crud由调用参数决定';
COMMENT ON COLUMN test_config_def.t_tooltip IS '提示信息';
COMMENT ON COLUMN test_config_def.t_json IS 'json格式扩展信息';
-- COMMENT ON COLUMN test_config_def.t_group IS '分组分类';
COMMENT ON COLUMN test_config_def.t_desc IS '描述';
COMMENT ON COLUMN test_config_def.t_help_message IS '帮助信息';

DROP TABLE IF EXISTS test_config_property_def CASCADE;
CREATE TABLE test_config_property_def (
  t_id VARCHAR(32) NOT NULL ,  -- 'ID，uuid',
  t_config_def_id VARCHAR(32) ,  -- '配置定义id',
  t_name VARCHAR(100) NOT NULL ,  -- '属性或参数名称',
  t_display_name VARCHAR(256) ,  -- '显示名称',
  t_default_value VARCHAR(100) ,  -- '默认值',
  t_edit_type VARCHAR(100) ,  -- '编辑类型',
  t_tooltip VARCHAR(200) ,  -- '提示信息',
  t_validate_rule VARCHAR(300) ,  -- '校验规则',
  t_error_message VARCHAR(100) ,  -- '错误信息',
  t_data_type VARCHAR(32) ,  -- '数据类型',
  t_is_required BOOLEAN  ,  -- '是否必填项',
  t_option_config VARCHAR(300) ,  -- '可选配置，如数据范围，可选值等',
  t_help_message VARCHAR(2000),  -- '帮助信息',
  t_order SMALLINT  ,  -- '排序号',
  t_json VARCHAR(500) ,  -- 'json格式扩展信息',
  t_tag1 VARCHAR(32) ,  -- '冗余字段1',
  t_tag2 VARCHAR(32) ,  -- '冗余字段2',
  PRIMARY KEY (t_id),
  CONSTRAINT fk_scdd_config_def_id FOREIGN KEY (t_config_def_id) REFERENCES test_config_def (t_id) ON DELETE CASCADE
); -- '配置定义属性详细信息,如：连接信息';
COMMENT ON TABLE test_config_property_def IS '配置定义属性详细信息,如：连接信息';
COMMENT ON COLUMN test_config_property_def.t_id IS 'ID，uuid';
COMMENT ON COLUMN test_config_property_def.t_config_def_id IS '配置定义id';
COMMENT ON COLUMN test_config_property_def.t_name IS '属性或参数名称';
COMMENT ON COLUMN test_config_property_def.t_display_name IS '显示名称';
COMMENT ON COLUMN test_config_property_def.t_default_value IS '默认值';
COMMENT ON COLUMN test_config_property_def.t_edit_type IS '编辑类型';
COMMENT ON COLUMN test_config_property_def.t_tooltip IS '提示信息';
COMMENT ON COLUMN test_config_property_def.t_validate_rule IS '校验规则';
COMMENT ON COLUMN test_config_property_def.t_error_message IS '错误信息';
COMMENT ON COLUMN test_config_property_def.t_data_type IS '数据类型';
COMMENT ON COLUMN test_config_property_def.t_is_required IS '是否必填项';
COMMENT ON COLUMN test_config_property_def.t_option_config IS '可选配置，如数据范围，可选值等';
COMMENT ON COLUMN test_config_property_def.t_help_message IS '帮助信息';
COMMENT ON COLUMN test_config_property_def.t_order IS '排序号';
COMMENT ON COLUMN test_config_property_def.t_json IS 'json格式扩展信息';
COMMENT ON COLUMN test_config_property_def.t_tag1 IS '冗余字段1';
COMMENT ON COLUMN test_config_property_def.t_tag2 IS '冗余字段2';

DROP TABLE IF EXISTS test_config CASCADE;
CREATE TABLE test_config (
  t_id SERIAL NOT NULL ,  -- 'ID',
  t_config_def_id VARCHAR(32) ,  -- '配置定义id',
  t_item_type VARCHAR(32) NOT NULL ,  -- '配置类型,如res、portlet、sender.email、sender.sms、sender.ftp等',
  t_item_id VARCHAR(32) NOT NULL ,  -- '配置项标识信息，如资源id',
  t_values TEXT NOT NULL ,  -- 'json格式属性值，如连接信息snmp端口、团体串；文件目录s',
  t_modify_time TIMESTAMP ,  -- '修改时间',
  t_modify_user VARCHAR(32)  ,  -- '修改人，登录账号',
  t_json VARCHAR(500) ,  -- 'json格式扩展信息',
  t_tag1 VARCHAR(32) ,  -- '冗余字段1',
  t_tag2 VARCHAR(32) ,  -- '冗余字段2',
  PRIMARY KEY (t_id),
  UNIQUE (t_config_def_id,t_item_type,t_item_id),
  CONSTRAINT fk_st_config_def_id FOREIGN KEY (t_config_def_id) REFERENCES test_config_def (t_id) ON DELETE CASCADE
); -- '系统配置实例表，如连接访问授权属性表、sender的配置,如资源配置信息res、portlet配置、邮件服务器、短信服务器、ftp服务器等';
COMMENT ON TABLE test_config IS '系统配置实例表，如连接访问授权属性表、sender的配置,如资源配置信息res、portlet配置、邮件服务器、短信服务器、ftp服务器等';
COMMENT ON COLUMN test_config.t_id IS 'ID';
COMMENT ON COLUMN test_config.t_config_def_id IS '配置定义id';
COMMENT ON COLUMN test_config.t_item_type IS '配置类型,如res、portlet、sender.email、sender.sms、sender.ftp等';
COMMENT ON COLUMN test_config.t_item_id IS '配置项标识信息，如资源id';
COMMENT ON COLUMN test_config.t_values IS 'json格式属性值，如连接信息snmp端口、团体串；文件目录s';
COMMENT ON COLUMN test_config.t_modify_time IS '修改时间';
COMMENT ON COLUMN test_config.t_modify_user IS '修改人，登录账号';
COMMENT ON COLUMN test_config.t_json IS 'json格式扩展信息';
COMMENT ON COLUMN test_config.t_tag1 IS '冗余字段1';
COMMENT ON COLUMN test_config.t_tag2 IS '冗余字段2';












------------------  添加 ---------------------

DROP TABLE IF EXISTS test_product CASCADE;
CREATE TABLE test_product (
  t_id VARCHAR(32) NOT NULL ,  -- 'ID，.分割字符串或uuid',
  t_name VARCHAR(100) ,  -- '显示名称',
  t_model_number VARCHAR(100), --'产品型号'
  t_version VARCHAR(32) NOT NULL ,  -- '产品版本',
  t_group VARCHAR(100),  -- t_group VARCHAR(32),  -- '分组分类',
  t_user_id VARCHAR(100),  -- t_group VARCHAR(32),  -- '分组分类',
  t_desc VARCHAR(200),  -- '描述',
  t_json VARCHAR(500) ,  -- 'json格式扩展信息',
  PRIMARY KEY (t_id),
  CONSTRAINT t_fk_user_id FOREIGN KEY (t_user_id) REFERENCES test_user (t_id),
  UNIQUE (t_model_number)
); -- '系统配置定义,如：插件连接信息；存储配置类型和id，使用端不存储配置定义信息，与使用端解耦';
COMMENT ON TABLE test_product IS '产品定义表';
COMMENT ON COLUMN test_product.t_id IS 'ID，.分割字符串或uuid';
COMMENT ON COLUMN test_product.t_name IS '显示名称';
COMMENT ON COLUMN test_product.t_model_number IS '产品型号';
COMMENT ON COLUMN test_product.t_version IS '产品版本';
COMMENT ON COLUMN test_product.t_group IS '产品分组';
COMMENT ON COLUMN test_product.t_user_id IS '归属用户';
COMMENT ON COLUMN test_product.t_desc IS '描述';
COMMENT ON COLUMN test_product.t_json IS 'json格式扩展信息';


DROP TABLE IF EXISTS test_user_product_rel CASCADE;
CREATE TABLE test_user_product_rel
(
   t_user_id VARCHAR(32) NOT NULL ,
   t_product_id VARCHAR(32) NOT NULL ,
   PRIMARY KEY (t_user_id, t_product_id),
   CONSTRAINT t_fk_user_id FOREIGN KEY (t_user_id) REFERENCES test_user (t_id) ON UPDATE CASCADE ON DELETE CASCADE,
   CONSTRAINT t_fk_product_id FOREIGN KEY (t_product_id) REFERENCES test_product (t_id) ON UPDATE CASCADE ON DELETE CASCADE
);
COMMENT ON TABLE test_user_product_rel IS '用户产品关联表';
COMMENT ON COLUMN test_user_product_rel.t_user_id IS '用户ID';
COMMENT ON COLUMN test_user_product_rel.t_product_id IS '产品ID';





