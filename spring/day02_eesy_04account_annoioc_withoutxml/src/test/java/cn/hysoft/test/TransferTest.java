package cn.hysoft.test;

import cn.hysoft.service.IAccoutService;
import config.SpringConfigration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfigration.class)
public class TransferTest {
    @Autowired
    @Qualifier("proxyAccoutService")
    private IAccoutService as;

    @Test
    public void testTransfer(){
        as.tranfer("aaa","bbb",100f);
    }
}
