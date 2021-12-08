-- auto-generated definition
create table users
(
    id       int auto_increment
        primary key,
    username char(10)  null,
    password char(100) null
)
    charset = utf8;

-- auto-generated definition
create table oauth_client_details
(
    client_id               varchar(48)   not null
        primary key,
    resource_ids            varchar(256)  null,
    client_secret           varchar(256)  null,
    scope                   varchar(256)  null,
    authorized_grant_types  varchar(256)  null,
    web_server_redirect_uri varchar(256)  null,
    authorities             varchar(256)  null,
    access_token_validity   int           null,
    refresh_token_validity  int           null,
    additional_information  varchar(4096) null,
    autoapprove             varchar(256)  null
)
    charset = utf8;

INSERT INTO oauth2.users (id, username, password) VALUES (4, 'lagou-user', 'iuxyzds');

INSERT INTO oauth2.oauth_client_details (client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove) VALUES ('client_lagou123', 'autodeliver,resume', 'abcxyz', 'all', 'password,refresh_token', null, null, 7200, 259200, null, null);