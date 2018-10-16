package ojs.service;

import ojs.domain.db.Submissions;

/**
 * Created by sahriar on 1/7/17.
 */
public interface JudgeService {

    String judgeSubmissions(Submissions submissions);

}
