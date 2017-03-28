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
DROP TABLE IF EXISTS `springboottest`.`BATCH_JOB_EXECUTION`;
DROP TABLE IF EXISTS `springboottest`.`BATCH_JOB_EXECUTION_CONTEXT`;
DROP TABLE IF EXISTS `springboottest`.`BATCH_JOB_EXECUTION_PARAMS`;
DROP TABLE IF EXISTS `springboottest`.`BATCH_JOB_EXECUTION_SEQ`;
DROP TABLE IF EXISTS `springboottest`.`BATCH_JOB_INSTANCE`;
DROP TABLE IF EXISTS `springboottest`.`BATCH_JOB_SEQ`;
DROP TABLE IF EXISTS `springboottest`.`BATCH_STEP_EXECUTION`;
DROP TABLE IF EXISTS `springboottest`.`BATCH_STEP_EXECUTION_CONTEXT`;
DROP TABLE IF EXISTS `springboottest`.`BATCH_STEP_EXECUTION_SEQ`;
SET FOREIGN_KEY_CHECKS = 1;
