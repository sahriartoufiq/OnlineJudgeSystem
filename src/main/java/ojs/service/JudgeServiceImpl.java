package ojs.service;

import ojs.domain.db.Submissions;
import ojs.web.SubmissionController;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

/**
 * Created by sahriar on 1/7/17.
 */
@Service
public class JudgeServiceImpl implements JudgeService {
    private static final Logger log = Logger.getLogger(JudgeServiceImpl.class);

    @Override
    public String judgeSubmissions(Submissions submissions) {

//        String dest="/home/sahriar/Desktop/ojs/";
        String dest = "../Desktop/";
        int subId = submissions.getId();
        log.debug("......." + subId);
        int pbId = submissions.getProblems().getId();
        String k = "gcc -o " + dest + subId + ".out " + dest + subId + ".c";
        log.debug(k);
        log.debug(pbId);
        try {
            Process ss = Runtime.getRuntime().exec(k);
            try {
                ss.waitFor();
//                log.debug("ssssss");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            log.debug(e);
            e.printStackTrace();
        }
//        log.debug("wwwwwwww");
        //Process s=Runtime.getRuntime("gcc "+subId+".c");
        //pb.directory(new File(dest));
//        try {
//          //  pb.start();
//        } catch (IOException e) {
//            log.debug("error");
//            log.debug(e);
//            e.printStackTrace();
//        }

        if (new File(dest + subId + ".out").exists()) {
            log.debug("Compiled");

            ProcessBuilder pb = new ProcessBuilder(dest + subId + ".out");
            pb.redirectInput(new File(dest + pbId + "input.txt"));
            pb.redirectOutput(new File(dest + subId + "output.txt"));
            try {
                Process p = pb.start();
                try {
                    p.waitFor(10000, TimeUnit.MILLISECONDS);
                    if (p.isAlive()) {
                        log.debug("TLE");
                        p.destroy();
                        return "TLE";
                    } else if (p.exitValue() != 0) {
                        log.debug("Runtime Error");
                        return "Runtime Error";
                    } else if (p.exitValue() == 0) {
                        if (FileUtils.contentEquals(new File(dest + pbId + "output.txt"), new File(dest + subId + "output.txt"))) {
                            log.debug("Accepted");
                            return "Accepted";
                        } else {
                            log.debug("wrong answer");
                            return "Wrong Answer";
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return "Compilation error";
    }
}
