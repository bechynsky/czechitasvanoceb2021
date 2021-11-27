package cz.czechitas.vanoceb.vanoceb;

import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Filip Jirsák
 */
@RestController
public class TestController {

  private final JdbcTemplate jdbcTemplate;

  public TestController(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
  public String count() {
    StringBuilder builder = new StringBuilder();
    builder.append(jdbcTemplate.queryForObject("SELECT COUNT(*) FROM prani", Integer.class));
    return builder.toString();
  }
}
