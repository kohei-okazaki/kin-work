import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.classic.filter.ThresholdFilter
import ch.qos.logback.core.ConsoleAppender
import ch.qos.logback.core.rolling.RollingFileAppender
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy
import java.nio.charset.Charset

import static ch.qos.logback.classic.Level.*

scan("30 seconds")

def FILE_PATH = "/var/logs";
def ENCODE = "UTF-8";
def appenderList = ["FILE"];

appender("FILE", RollingFileAppender) {

  file = "${FILE_PATH}/dashboard.log"

  rollingPolicy(TimeBasedRollingPolicy) {
    fileNamePattern = "dashboard_%d{yyyy-MM-dd}.log"
    maxHistory = 30
  }

  encoder(PatternLayoutEncoder) {
    charset = Charset.forName("${ENCODE}")
    pattern = "%d [%thread] %X{id} %-5level %logger{10} - %msg%n"
  }

  filter(ThresholdFilter) {
    level = INFO
  }

}

root(INFO, appenderList)
