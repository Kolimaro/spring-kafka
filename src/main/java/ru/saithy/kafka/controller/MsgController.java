package ru.saithy.kafka.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pavel Tokarev, 28.01.2021
 */

@RestController
@RequestMapping("msg")
public class MsgController {

  private final KafkaTemplate<String, String> kafkaTemplate;

  public MsgController(KafkaTemplate<String, String> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  @PostMapping
  public void sendOrder(String msgId, String msg) {
    kafkaTemplate.send("msg", msgId, msg);
  }
}
