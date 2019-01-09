-- 抢占执行资源逻辑：【当前时间-上次执行开始时间>间隔时长】抢占资源；使用update pre_start_dt = CURRENT_DATE() where UNIX_TIMESTAMP()-UNIX_TIMESTAMP(pre_start_dt)>interval_times
DROP TABLE IF EXISTS `global_job`;
CREATE TABLE `global_job` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `job_code` varchar(50) DEFAULT NULL COMMENT '定时任务code',
  `job_desc` varchar(100) DEFAULT NULL COMMENT '定时任务描述',
  `pre_start_interval` bigint DEFAULT 0 COMMENT '上一次执行开始时间时间戳',
  `pre_start_dt` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '上一次执行开始时间',
  `pre_end_dt` datetime DEFAULT NULL COMMENT '上一次执行结束时间',
  `interval_times` int DEFAULT NULL COMMENT '间隔时长：单位毫秒',
  `is_enabled` char(1) DEFAULT 'Y' COMMENT '是否启用：是Y；否N',
  `create_dt` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_dt` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `ind_gj_jc_1` (`job_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时任务状态表';


DROP TABLE IF EXISTS `demo`;
CREATE TABLE `demo` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `key` varchar(50) NOT NULL COMMENT 'key',
  `value` varchar(100) DEFAULT NULL COMMENT 'value',
  `create_dt` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_dt` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='demo表';

DROP TABLE IF EXISTS `demo1`;
CREATE TABLE `demo1` (
  `id` varchar(32) NOT NULL COMMENT '主键',
  `key` varchar(50) DEFAULT NULL COMMENT 'key',
  `value` varchar(100) DEFAULT NULL COMMENT 'value',
  `create_dt` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_dt` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='demo1表';