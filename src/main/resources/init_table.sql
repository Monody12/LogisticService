create table logistic
(
    id            serial primary key,
    source_id     integer,
    create_time   timestamp,
    update_time   timestamp,
    parameters    varchar(255),
    response_json text,
    operators     varchar(255)
);

comment on column logistic.source_id is '所用于的服务ID，金桂飞(1)';

comment on column logistic.parameters is '请求参数';

comment on column logistic.response_json is 'api响应结果';

comment on column logistic.operators is '运营商';

alter table logistic owner to postgres;

