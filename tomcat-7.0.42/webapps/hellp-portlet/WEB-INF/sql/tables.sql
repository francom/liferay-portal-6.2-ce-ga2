create table db_test_AcademicYear (
	id_ LONG not null primary key,
	name VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table db_test_Students (
	id_ LONG not null primary key,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	examFee INTEGER,
	gender INTEGER,
	subjectsId INTEGER,
	address VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table db_test_Subjects (
	id_ LONG not null primary key,
	name VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table db_test_academicYear (
	id_ LONG not null primary key,
	name VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table tbl_AcademicYear (
	id_ LONG not null primary key,
	name VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table tbl_Student (
	id_ LONG not null primary key,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	examFee DOUBLE,
	gender VARCHAR(75) null,
	subjectsId INTEGER,
	academicYearId LONG,
	address VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table tbl_Subject (
	id_ LONG not null primary key,
	name VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table test_AcademicYear (
	id_ LONG not null primary key,
	name VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table test_Student (
	id_ LONG not null primary key,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	examFee DOUBLE,
	gender INTEGER,
	subjectsId INTEGER,
	academicYearId LONG,
	address VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table test_Student_AcademicYears (
	id_ LONG not null,
	id_ LONG not null,
	primary key (id_, id_)
);

create table test_Students (
	id_ LONG not null primary key,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	examFee DOUBLE,
	gender INTEGER,
	subjectsId INTEGER,
	address VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table test_Subject (
	id_ LONG not null primary key,
	name VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);

create table test_Subjects (
	id_ LONG not null primary key,
	name VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);