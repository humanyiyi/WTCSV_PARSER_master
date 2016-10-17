package com.udbac.csvparser.main;

import com.udbac.csvparser.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by 43890 on 2016/10/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class ApplicationMainTest {
    @Autowired
    ApplicationContext ctx;

    @Test
    public void run() throws Exception {
        assertThat(this.ctx).isNotNull();
        assertThat(this.ctx.containsBean("backendBaseRepoImpl")).isTrue();
    }

}