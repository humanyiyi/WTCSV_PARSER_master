package com.udbac.csvparser;

import com.udbac.csvparser.repo.BackendBaseRepo;
import com.udbac.csvparser.repo.BackendTransRepo;
import com.udbac.csvparser.repo.FlowDailyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by 43890 on 2016/10/17.
 */
@SpringBootApplication
public class Application implements CommandLineRunner{

    @Autowired
    private BackendBaseRepo backendBaseRepo;
    @Autowired
    private BackendTransRepo backendTransRepo;
    @Autowired
    private FlowDailyRepo flowDailyRepo;

    @Override
    public void run(String... strings) throws Exception {
        backendBaseRepo.insertBackendBase();
        backendTransRepo.insertBackendTrans();
        flowDailyRepo.insertFlowMarket();
        flowDailyRepo.insertFlowNature();
        flowDailyRepo.insertFlowTotalDaily();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}