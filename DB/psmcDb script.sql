use psmcdb;

drop table if exists employee;
drop table if exists injury;
drop table if exists medi_chat;
drop table if exists medi_connect;
drop table if exists medi_info;
drop table if exists medical_field;
drop table if exists member_regist;
drop table if exists patient;
drop table if exists position;
drop table if exists project;
drop table if exists res_time;
drop table if exists thera_chat;
drop table if exists thera_info;
drop table if exists thera_link;

CREATE TABLE `employee`
(
    `pm_code` VARCHAR(50) NOT NULL COMMENT 'pm_code',
    `emp_no` INTEGER NOT NULL COMMENT 'emp_no',
    `phone` VARCHAR(20) NOT NULL COMMENT 'phone',
    `email` VARCHAR(100) COMMENT 'email',
    `name` VARCHAR(100) NOT NULL COMMENT 'name',
    `age` INTEGER NOT NULL COMMENT 'age',
    `position_code` INTEGER NOT NULL COMMENT 'position_code',
    `gender` CHAR(1) NOT NULL COMMENT 'gender',
    `lab_no` VARCHAR(20) COMMENT 'lab_no',
    `field_code` INTEGER NOT NULL COMMENT 'field_code',
    PRIMARY KEY (`pm_code`)
) COMMENT = 'employee';

INSERT INTO `employee` (`pm_code`, `emp_no`, `phone`, `email`, `name`, `age`, `position_code`, `gender`, `lab_no`, `field_code`) VALUES
('d001', 1001, '01012345678', 'john@example.com', '홍길동', 35, 1, 'M', '02-123-4567', 1),
('d002', 1002, '01023456789', 'jane@example.com', '이영희', 28, 2, 'F', '02-234-5678', 2),
('d003', 1003, '01034567890', 'alice@example.com', '김철수', 42, 3, 'F', '02-345-6789',3),
('d004', 1004, '01045678901', 'peter@example.com', '박지영', 31, 4, 'M', '02-456-7890', 4),
('t001', 1005, '01056789012', 'sam@example.com', '최영호', 39, 5, 'M', '02-567-8901',5),
('t002', 1006, '01067890123', 'sarah@example.com', '이지은', 26, 6, 'F', '02-678-9012', 6),
('t003', 1007, '01078901234', 'mike@example.com', '정수민', 45, 7, 'M', '02-789-0123',  7),
('t004', 1008, '01089012345', 'emily@example.com', '배미경', 29, 8, 'F', '02-890-1234',  8),
('d005', 1009, '01090123456', 'david@example.com', '김동현', 38, 9, 'M', '02-901-2345', 9),
('t005', 1010, '01001234567', 'lisa@example.com', '이수진', 32, 10, 'F', '02-012-3456',  10);



CREATE TABLE `injury`
(
    `injury_code` INTEGER NOT NULL COMMENT 'injury_code',
    `injury_name` VARCHAR(100) NOT NULL COMMENT 'injury_name',
    PRIMARY KEY (`injury_code`)
) COMMENT = 'injury';



CREATE TABLE `medi_chat`
(
    `chat_no` bigint AUTO_INCREMENT COMMENT 'meid_chat_no',
    `contents` VARCHAR(255) NOT NULL COMMENT 'medi_chat_content',
    `medi_no` bigint NOT NULL COMMENT 'medi_no',
    `project_no` bigint NOT NULL COMMENT 'project_no',
    PRIMARY KEY (`chat_no`)
) COMMENT = 'medi_chat';

CREATE TABLE `medi_connect`
(
    `medi_no` bigint AUTO_INCREMENT COMMENT 'medi_no',
    `medi_title` VARCHAR(100) NOT NULL COMMENT 'medi_title',
    `medi_content` VARCHAR(255) NOT NULL COMMENT 'medi_content',
    `project_no` bigint NOT NULL COMMENT 'project_no',
    `medi_status` CHAR(1) NOT NULL COMMENT 'medi_status',
    PRIMARY KEY (`medi_no`)
) COMMENT = 'medi_connect';

CREATE TABLE `medi_info`
(
    `medi_code` bigint AUTO_INCREMENT COMMENT 'medi_code',
    `medi_date` DATE NOT NULL COMMENT 'medi_date',
    `project_no` bigint NOT NULL COMMENT 'project_no',
    `time_code` INTEGER NOT NULL COMMENT 'time_code',
    `medi_reg_date` DATETIME NOT NULL COMMENT 'medi_reg_date',
    `medi_status` CHAR(1) NOT NULL COMMENT 'medi_status',
    PRIMARY KEY (`medi_code`)
) COMMENT = 'medi_info';

CREATE TABLE `medical_field`
(
    `field_code` INTEGER NOT NULL COMMENT 'field_code',
    `field_name` VARCHAR(100) NOT NULL COMMENT 'field_name',
    PRIMARY KEY (`field_code`)
) COMMENT = 'medical_field';

CREATE TABLE `member_regist`
(
    `regist_no` bigint AUTO_INCREMENT COMMENT 'regist_no',
    `id` VARCHAR(50) NOT NULL COMMENT 'id',
    `password` VARCHAR(255) NOT NULL COMMENT 'password',
    `phone` VARCHAR(20) NOT NULL COMMENT 'phone',
    `pm_code` VARCHAR(50) NOT NULL COMMENT 'pm_code',
    `email` VARCHAR(100) NOT NULL COMMENT 'email',
    `birth` VARCHAR(10) NOT NULL COMMENT 'birth',
    `employee_status` CHAR(1) NOT NULL COMMENT 'employee_status',
    `role` char not null comment 'docorthera',
    PRIMARY KEY (`regist_no`)
) COMMENT = 'member_regist';

CREATE TABLE `patient`
(
    `patient_no` bigint AUTO_INCREMENT COMMENT 'patient_no',
    `name` VARCHAR(100) NOT NULL COMMENT 'name',
    `age` INTEGER NOT NULL COMMENT 'age',
    `gender` CHAR(1) COMMENT 'gender',
    `height` double COMMENT 'height',
    `weight` double COMMENT 'weight',
    `phone` VARCHAR(20) NOT NULL COMMENT 'phone',
    `agree` CHAR(1) COMMENT 'agree',
    `email` VARCHAR(100) COMMENT 'email',
    PRIMARY KEY (`patient_no`)
) COMMENT = 'patient';

INSERT INTO `patient` (`name`, `age`, `gender`, `height`, `weight`, `phone`, `agree`, `email`) VALUES
('김민지', 30, 'F', 165.5, 55.2, '01012345678', 'Y', 'minji@example.com'),
('이승우', 45, 'M', 175.3, 75.8, '01023456789', 'Y', 'seungwoo@example.com'),
('박지은', 22, 'F', 160.1, 48.5, '01034567890', 'Y', 'jieun@example.com'),
('최준호', 36, 'M', 180.0, 85.1, '01045678901', 'Y', 'junho@example.com'),
('정윤서', 28, 'F', 170.8, 63.7, '01056789012', 'Y', 'yunseo@example.com'),
('이성민', 50, 'M', 178.5, 80.5, '01067890123', 'Y', 'seongmin@example.com'),
('박지현', 19, 'F', 155.0, 45.0, '01078901234', 'Y', 'jihyun@example.com'),
('김태우', 42, 'M', 172.4, 78.3, '01089012345', 'Y', 'taewoo@example.com'),
('최서연', 35, 'F', 168.9, 60.6, '01090123456', 'Y', 'seoyeon@example.com'),
('이지훈', 29, 'M', 177.2, 70.9, '01001234567', 'Y', 'jihun@example.com');
CREATE TABLE `position`
(
    `position_code` INTEGER NOT NULL COMMENT 'position_code',
    `position_name` VARCHAR(100) NOT NULL COMMENT 'position_name',
    PRIMARY KEY (`position_code`)
) COMMENT = 'position';

CREATE TABLE `project`
(
    `project_no` bigint AUTO_INCREMENT COMMENT 'project_no',
    `patient_no` bigint NOT NULL COMMENT 'patient_no',
    `pm_code` VARCHAR(50) NOT NULL COMMENT 'pm_code',
    `injury_code` INTEGER NOT NULL COMMENT 'injury_code',
    `project_date` DATETIME NOT NULL COMMENT 'project_date',
    `project_status` CHAR(1) NOT NULL COMMENT 'project_status',
    PRIMARY KEY (`project_no`)
) COMMENT = 'project';

CREATE TABLE `res_time`
(
    `time_code` INTEGER NOT NULL COMMENT 'time_code',
    `time_val` DATETIME NOT NULL COMMENT 'time_val',
    PRIMARY KEY (`time_code`)
) COMMENT = 'res_time';

CREATE TABLE `thera_chat`
(
    `thera_chat_no` bigint AUTO_INCREMENT COMMENT 'thera_chat_no',
    `TheraLink_no` bigint NOT NULL COMMENT 'thera_no',
    `project_no` bigint NOT NULL COMMENT 'project_no',
    `thera_chat_content` VARCHAR(255) NOT NULL COMMENT 'thera_chat_content',
    PRIMARY KEY (`thera_chat_no`)
) COMMENT = 'thera_chat';

CREATE TABLE `thera_info`
(
    `thera_code` bigint AUTO_INCREMENT COMMENT 'thera_code',
    `thera_date` DATE NOT NULL COMMENT 'thera_date',
    `project_no` bigint NOT NULL COMMENT 'project_no',
    `time_code` INTEGER NOT NULL COMMENT 'time_code',
    `thera_reg_date` DATETIME NOT NULL COMMENT 'thera_reg_date',
    `thera_status` CHAR(1) NOT NULL COMMENT 'thera_status',
    PRIMARY KEY (`thera_code`)
) COMMENT = 'thera_info';

CREATE TABLE `thera_link`
(
    `project_no` bigint NOT NULL COMMENT 'project_no',
    `TheraLink_no` bigint AUTO_INCREMENT COMMENT 'thera_no',
    `title` VARCHAR(100) NOT NULL COMMENT 'thera_title',
    `contents` VARCHAR(255) NOT NULL COMMENT 'thera_content',
    `thera_status` CHAR(1) NOT NULL COMMENT 'thera_status',
    PRIMARY KEY (`TheraLink_no`)
) COMMENT = 'thera_link';
