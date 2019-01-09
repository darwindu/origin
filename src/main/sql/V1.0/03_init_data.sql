-- 定时任务列表
delete from global_job where job_code in ('JOB_RESEND_PAY_FAIL');
insert into global_job(id, job_code, job_desc, interval_times) VALUES (REPLACE(UUID(), '-', ''), 'JOB_RESEND_PAY_FAIL', '支付结果通知失败重发：每3秒执行一次', 3000);