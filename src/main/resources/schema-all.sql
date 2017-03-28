DROP TABLE IF EXISTS `springboottest`.`people`;

CREATE TABLE `springboottest`.`people` (
  `person_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(255) NOT NULL ,
  `last_name` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`person_id`),
  FULLTEXT  `last_name_index` (`last_name`),
  FULLTEXT  `first_name_index` (`first_name`)
) ENGINE = InnoDB CHARSET=utf8 COLLATE utf8_general_ci;


SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE `BATCH_JOB_EXECUTION`;
TRUNCATE `BATCH_JOB_EXECUTION_CONTEXT`;
TRUNCATE `BATCH_JOB_EXECUTION_PARAMS`;
TRUNCATE `BATCH_JOB_EXECUTION_SEQ`;
TRUNCATE `BATCH_JOB_INSTANCE`;
TRUNCATE `BATCH_JOB_SEQ`;
TRUNCATE `BATCH_STEP_EXECUTION`;
TRUNCATE `BATCH_STEP_EXECUTION_CONTEXT`;
TRUNCATE `BATCH_STEP_EXECUTION_SEQ`;
SET FOREIGN_KEY_CHECKS = 1;