TRUNCATE TABLE test_user CASCADE;
INSERT INTO test_user VALUES ('admin', 'admin', '3ef7164d1f6167cb9f2658c07d3c2f0a', '系统管理员', 'admin', false, NULL, NULL, '13811849165', 'gaofubing@gmail.com', NULL, NULL, '2014-10-5 17:33:02', NULL, NULL, NULL, NULL);

INSERT INTO test_product( t_id, t_name, t_model_number, t_version, t_group, t_desc, t_json) VALUES ('1', 'WIFI 插座', 'wifi_cz_v1', 'v1', 'cz', '测试WIFI插座功能', null);
