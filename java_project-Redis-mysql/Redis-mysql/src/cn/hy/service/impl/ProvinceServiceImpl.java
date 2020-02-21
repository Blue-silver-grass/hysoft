package cn.hy.service.impl;

import cn.hy.dao.ProvinceDao;
import cn.hy.dao.impl.ProvinceDaoImpl;
import cn.hy.domain.Province;
import cn.hy.jedis.util.JedisPoolUtils;
import cn.hy.service.ProvinceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    //声明dao
    private ProvinceDao dao = new ProvinceDaoImpl();
    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    @Override
    public String findAllJson() {
        //先从Redis中查询数据
        //获取Redis客户端连接
        Jedis jedis = JedisPoolUtils.getJedis();
        String privince_json = jedis.get("privince");
        //2判断privince_json是否为null
        if (privince_json == null || privince_json.length() == 0){
            //Redis中没有数据
            System.out.println("redis中没有数据，查询数据库");
            //2.1从数据库中查询
            List<Province> ps = dao.findAll();
            //2.2将list序列化为json
            ObjectMapper mapper = new ObjectMapper();
            try {
                privince_json = mapper.writeValueAsString(ps);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            //2.3将json数据存入Redis
            jedis.set("privince",privince_json);
            //归还连接
            jedis.close();
        }else {
            System.out.println("redis中有数据，查询缓存");
        }
        return privince_json;
    }
}
