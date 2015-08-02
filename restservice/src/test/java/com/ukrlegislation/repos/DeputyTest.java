package com.ukrlegislation.repos;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ramax on 8/2/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value="classpath:config/repo.xml")
@Transactional
public class DeputyTest {

    @Autowired
    DeputyRepository deputyRepository;

    @Before
    public void init(){

    }

    @Test
    public void test() {
        System.out.println(deputyRepository.findByUniquePersonCode(1));
    }

    @After
    public void unInit() {

    }

}
