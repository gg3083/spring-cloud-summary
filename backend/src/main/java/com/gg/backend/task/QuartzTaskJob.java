package com.gg.backend.task;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;


/**
 * @author gimi
 */
@Slf4j
public class QuartzTaskJob extends QuartzJobBean {

  @Override
  protected void executeInternal(JobExecutionContext jobExecutionContext)
      throws JobExecutionException {
    log.info("start quartz task 。。。");
  }

}