package com.eiecc.fire.spring_4_no_xml.taskscheduler;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.eiecc.fire.spring_4_no_xml.taskscheduler")
@EnableScheduling
public class TaskSchedulerConfig {

}
