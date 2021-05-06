create table comment
(
	id BIGINT auto_increment,
	parent_id BIGINT not null,
	type INT not null,
	observer INT not null,
	gmt_create BIGINT not null,
	gmt_modified BIGINT not null,
	like_count int default 0,
	constraint COMMENT_PK
		primary key (id)
);