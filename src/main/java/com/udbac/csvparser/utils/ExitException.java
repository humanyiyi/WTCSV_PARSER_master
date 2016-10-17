package com.udbac.csvparser.utils;

/**
 * Created by 43890 on 2016/10/17.
 */
import org.springframework.boot.ExitCodeGenerator;

public class ExitException extends RuntimeException implements ExitCodeGenerator {

    @Override
    public int getExitCode() {
        return 10;
    }

}