package com.udbac.csvparser;

import com.udbac.csvparser.repo.BackendBaseRepo;
import com.udbac.csvparser.repo.BackendTransRepo;
import com.udbac.csvparser.repo.FlowDailyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 43890 on 2016/10/17.
 */
@SpringBootApplication
public class Application implements CommandLineRunner,ExitCodeGenerator {

    public static void main(String[] args) {
        System.exit(SpringApplication.exit(SpringApplication.run(Application.class, args)));
    }
    @Override
    public void run(String... strings) throws Exception {
        application.insertAll();
    }
    @Override
    public int getExitCode() {
        return 0;
    }

    @Transactional
    public void insertAll() {
        backendBaseRepo.insertBackendBase();
        backendTransRepo.insertBackendTrans();
        flowDailyRepo.insertFlowMarket();
        flowDailyRepo.insertFlowNature();
        flowDailyRepo.insertFlowTotalDaily();
    }

    @Autowired
    Application application;
    @Autowired
    private BackendBaseRepo backendBaseRepo;
    @Autowired
    private BackendTransRepo backendTransRepo;
    @Autowired
    private FlowDailyRepo flowDailyRepo;
}