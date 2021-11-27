package cz.czechitas.vanoceb.vanoceb;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Filip Jirsák
 */
@RestController
public class EnvController {

  @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
  public String env() {
    StringBuilder builder = new StringBuilder();
    System.getenv().keySet().forEach(key -> builder.append(key).append("\r\n"));
    return builder.toString();
  }
}
